package com.lab.data.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lab.data.exception.NenhumEncontradoException;
import com.lab.data.model.AreaGeologia;
import com.lab.data.model.PraticaGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.dao.interfaces.DatabaseException;
import framework.model.Arquivo;
import framework.service.interfaces.IServiceArquivo;
import framework.service.interfaces.IServiceAtividade;
import framework.service.interfaces.IServiceProjeto;
import groovy.util.ResourceException;

@Controller
@RequestMapping("/arquivos")
public class ArquivoController {
	
	private static final String LIST_ERROR = "Falha ao listar arquivos!";
	
	@Autowired
	private IServiceArquivo<ProjetoGeologia, PraticaGeologia> service;
	
	@Autowired
	private IServiceProjeto<ProjetoGeologia> projetoService;
	
	@Autowired
	private IServiceAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia> praticaService;
	
	private Arquivo<ProjetoGeologia, PraticaGeologia> buscarArquivoPorId(Integer id) throws DatabaseException, NenhumEncontradoException {
		Arquivo<ProjetoGeologia, PraticaGeologia> a = new Arquivo<>();
		a.setCodigo(id);
		List<Arquivo<ProjetoGeologia, PraticaGeologia>> list = service.consultar(a);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Arquivo com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@GetMapping
	public String index(Model model, RedirectAttributes redirectAttributes) {
		List<Arquivo<ProjetoGeologia, PraticaGeologia>> arquivos;
		try {
			arquivos = service.listar();
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", LIST_ERROR);
			return "redirect:/";
		}
		model.addAttribute("arquivos", arquivos);
		return "arquivo/index";
	}
	
	@GetMapping("/cadastrar")
	public String formArquivoCad(
			Model model, 
			@ModelAttribute("arquivo") Arquivo<ProjetoGeologia, PraticaGeologia> arquivo, 
			RedirectAttributes redirectAttributes) 
	{
		try {
			List<ProjetoGeologia> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/arquivos";
		}
		try {
			List<PraticaGeologia> praticas = praticaService.listar();
			model.addAttribute("praticas", praticas);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/arquivos";
		}
		return "arquivo/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("arquivo") Arquivo<ProjetoGeologia, PraticaGeologia> arquivo, @PathVariable("file") MultipartFile file, RedirectAttributes redirectAtrributes) {
		
		if(file.isEmpty()) {
			redirectAtrributes.addFlashAttribute("erro", "Não foi possível salvar o arquivo!");
			return "redirect:/arquivos";
		}
		
		try {
			arquivo.setDados(file.getBytes());
			arquivo.setTipo(file.getContentType());
			arquivo.setTamanho(file.getSize());
		} catch (IOException e1) {
			redirectAtrributes.addFlashAttribute("erro", "Não foi possível salvar o arquivo!");
			return "redirect:/arquivos";
		}
		
		try {
			service.inserir(arquivo);
			redirectAtrributes.addFlashAttribute("sucesso", "Arquivo inserido com sucesso!");
		} catch (DatabaseException e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		
		return "redirect:/arquivos";
	}
	
	@ExceptionHandler(ResourceException.class)
	public String handlerResourceException(ResourceException e, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("erro", e.getMessage());
		return "redirect:/arquivos";
	}
	
	@GetMapping("/{id}/baixar")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") Integer id) throws ResourceException {
		
		try {
			Arquivo<ProjetoGeologia, PraticaGeologia> a = buscarArquivoPorId(id);
			
			//a = service.ler(a);
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(a.getTipo() != null ? a.getTipo() : ""))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + a.getNome() + "\"")
	                .body(new ByteArrayResource(a.getDados()));
		} catch (DatabaseException | NenhumEncontradoException e) {
			throw new ResourceException(e);
		}
	}
	
	@GetMapping("/{id}/editar")
	public String formArquivoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoGeologia> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/arquivos";
		}
		try {
			List<PraticaGeologia> praticas = praticaService.listar();
			model.addAttribute("praticas", praticas);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/arquivos";
		}
		
		try {
			Arquivo<ProjetoGeologia, PraticaGeologia> a = buscarArquivoPorId(id);
			model.addAttribute("arquivo", a);
			return "arquivo/form";
		} catch (DatabaseException | NenhumEncontradoException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/arquivos";
		}
	}
	
	@PutMapping
	public String edit(Arquivo<ProjetoGeologia, PraticaGeologia> arquivo, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(arquivo);
			redirectAttributes.addFlashAttribute("sucesso", "Arquivo editado com sucesso!");
		} catch (DatabaseException | IllegalArgumentException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			if(arquivo != null && arquivo.getCodigo() != null) {
				redirectAttributes.addFlashAttribute("arquivo", arquivo);
				return "redirect:/arquivos/" + arquivo.getCodigo() + "/editar";
			}
		}
		return "redirect:/arquivos";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		
		try {
			Arquivo<ProjetoGeologia, PraticaGeologia> a = new Arquivo<>();
			a.setCodigo(id);
			service.remover(a);
			redirectAttributes.addFlashAttribute("sucesso", "Arquivo deletado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/arquivos";
	}
}
