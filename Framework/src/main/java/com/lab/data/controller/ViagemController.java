package com.lab.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lab.data.exception.NenhumEncontradoException;
import com.lab.data.model.AreaGeologia;
import com.lab.data.model.PraticaGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.dao.interfaces.DatabaseException;
import framework.service.interfaces.IServiceArea;
import framework.service.interfaces.IServiceAtividade;
import framework.service.interfaces.IServiceProjeto;

@Controller
@RequestMapping("/viagens")
public class ViagemController {
	
	private static final String LIST_ERROR = "Falha ao tentar acessar banco de dados. Não foi possível listar os pesquisadores.";
	private static final String INSERT_SUCCESS = "Viagem inserida com sucesso!";
	private static final String EDIT_SUCCESS = "Viagem editada com sucesso!";
	private static final String DELETE_SUCCESS = "Viagem deletada com sucesso!";
	
	
	private PraticaGeologia buscarViagemPorId(Integer id) throws DatabaseException, NenhumEncontradoException {
		PraticaGeologia v = new PraticaGeologia();
		v.setCodigo(id);
		List<PraticaGeologia> list = viagemService.consultar(v);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Viagem com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@Autowired
	private IServiceAtividade<PraticaGeologia> viagemService;
	
	@Autowired
	private IServiceArea<AreaGeologia> localService;
	
	@Autowired
	private IServiceProjeto<ProjetoGeologia> projetoService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<PraticaGeologia> viagens = viagemService.listar();
			model.addAttribute("viagens", viagens);
		} catch (DatabaseException e) {
			model.addAttribute("erro", LIST_ERROR);
		}
		return "viagem/index";
	}
	
	@GetMapping("/cadastrar")
	public String formViagemCad(Model model, @ModelAttribute("viagem") PraticaGeologia viagem, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoGeologia> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		try {
			List<AreaGeologia> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		return "viagem/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("viagem") PraticaGeologia viagem, RedirectAttributes redirectAtrributes) {
		try {
			viagemService.inserir(viagem);
			redirectAtrributes.addFlashAttribute("sucesso", INSERT_SUCCESS);
		} catch (DatabaseException e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens";
	}
	
	@GetMapping("/{id}/editar")
	public String formProjetoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoGeologia> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		try {
			List<AreaGeologia> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		try {
			PraticaGeologia v = buscarViagemPorId(id);
			model.addAttribute("viagem", v);
			return "viagem/form";
		} catch (DatabaseException | NenhumEncontradoException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
	}
	
	@PutMapping
	public String edit(PraticaGeologia viagem, RedirectAttributes redirectAttributes) {
		try {
			viagemService.atualizar(viagem);
			redirectAttributes.addFlashAttribute("sucesso", EDIT_SUCCESS);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			PraticaGeologia v = new PraticaGeologia();
			v.setCodigo(id);
			viagemService.remover(v);
			redirectAttributes.addFlashAttribute("sucesso", DELETE_SUCCESS);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens";
	}
	
	@GetMapping("/buscar")
	public String filtros(Model model, @ModelAttribute("filtro") PraticaGeologia  filtro, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoGeologia> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		try {
			List<AreaGeologia> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		return "viagem/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") PraticaGeologia filtro, RedirectAttributes redirectAttributes) {		
		/*
		if(filtro.getInicio().trim().isEmpty())
			filtro.setInicio(null);
		if(filtro.getFim().trim().isEmpty())
			filtro.setFim(null);
		
		List<Viagem> viagens = viagemService.buscar(filtro);
		redirectAttributes.addFlashAttribute("viagens", viagens);
		*/
		return "redirect:/viagens/buscar";
	}
}
