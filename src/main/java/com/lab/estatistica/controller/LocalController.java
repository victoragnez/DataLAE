package com.lab.estatistica.controller;

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
import com.lab.estatistica.model.AreaEstatistica;

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.service.interfaces.IServiceArea;

@Controller
@RequestMapping("/locais")
public class LocalController {
	
	private static final String SUCCESS_INSERT = "Local inserido com sucesso!";
	private static final String ERROR_EDIT = "Não foi possível editar projeto!";
	private static final String SUCCESS_EDIT = "Local editado com sucesso!";
	private static final String SUCCESS_DELETE = "Local deletado com sucesso!";
	
	@Autowired
	private IServiceArea<AreaEstatistica> service;
	
	private AreaEstatistica buscarAreaPorId(Integer id) throws DatabaseException, NenhumEncontradoException, BadAttributeException {
		AreaEstatistica a = new AreaEstatistica();
		a.setCodigo(id);
		List<AreaEstatistica> list = service.consultar(a);
		if(list.size() != 1)
			throw new NenhumEncontradoException("Local com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@GetMapping
	public String index(Model model, RedirectAttributes redirectAttributes) {
		List<AreaEstatistica> locais;
		try {
			locais = service.listar();
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/";
		}
		model.addAttribute("locais", locais);
		return "dataest/local/index";
	}
	
	@GetMapping("/cadastrar")
	public String formLocalCad(@ModelAttribute("local") AreaEstatistica local) {
		return "dataest/local/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("local") AreaEstatistica local, RedirectAttributes redirectAtrributes) {
		try {
			service.inserir(local);
			redirectAtrributes.addFlashAttribute("sucesso", SUCCESS_INSERT);
		} catch (Exception e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/locais/cadastrar";
		}
		return "redirect:/locais";
	}
	
	@GetMapping("/{id}/editar")
	public String formLocalEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		if(id == null) {
			redirectAttributes.addFlashAttribute("erro", ERROR_EDIT);
			return "redirect:/locais";
		}
		try {
			AreaEstatistica a = buscarAreaPorId(id);
			model.addAttribute("local", a);
			return "dataest/local/form";
		} catch (DatabaseException | NenhumEncontradoException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/locais";
		}
	}
	
	@PutMapping
	public String edit(AreaEstatistica local, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(local);
			redirectAttributes.addFlashAttribute("sucesso", SUCCESS_EDIT);
			return "redirect:/locais";
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			if(local == null)
				return "redirect:/locais"; 
			return "redirect:/locais/" + local.getCodigo() + "/editar";
		}
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		AreaEstatistica a = new AreaEstatistica();
		a.setCodigo(id);
		
		try {
			service.remover(a);
			redirectAttributes.addFlashAttribute("sucesso", SUCCESS_DELETE);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/locais";
	}
	
	@GetMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") AreaEstatistica filtro) {
		return "dataest/local/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") AreaEstatistica filtro, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filtro", filtro);
		if(filtro != null && filtro.getNome().trim().isEmpty())
			filtro.setNome(null);
		try {
			List<AreaEstatistica> locais = service.consultar(filtro);
			redirectAttributes.addFlashAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/locais/buscar";
	}
}
