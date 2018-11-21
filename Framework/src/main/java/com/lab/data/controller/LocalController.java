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

import framework.dao.interfaces.DatabaseException;
import framework.service.interfaces.IServiceArea;

@Controller
@RequestMapping("/locais")
public class LocalController {
	
	private static final String SUCCESS_INSERT = "Local inserido com sucesso!";
	private static final String ERROR_EDIT = "Não foi possível editar projeto!";
	private static final String SUCCESS_EDIT = "Local editado com sucesso!";
	private static final String SUCCESS_DELETE = "Local deletado com sucesso!";
	
	@Autowired
	private IServiceArea<AreaGeologia> service;
	
	private AreaGeologia buscarAreaPorId(Integer id) throws DatabaseException, NenhumEncontradoException {
		AreaGeologia a = new AreaGeologia();
		a.setCodigo(id);
		List<AreaGeologia> list = service.consultar(a);
		if(list.size() != 1)
			throw new NenhumEncontradoException("Local com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@GetMapping
	public String index(Model model, RedirectAttributes redirectAttributes) {
		List<AreaGeologia> locais;
		try {
			locais = service.listar();
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/";
		}
		model.addAttribute("locais", locais);
		return "local/index";
	}
	
	@GetMapping("/cadastrar")
	public String formLocalCad(@ModelAttribute("local") AreaGeologia local) {
		return "local/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("local") AreaGeologia local, RedirectAttributes redirectAtrributes) {
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
			AreaGeologia a = buscarAreaPorId(id);
			model.addAttribute("local", a);
			return "local/form";
		} catch (DatabaseException | NenhumEncontradoException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/locais";
		}
	}
	
	@PutMapping
	public String edit(AreaGeologia local, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(local);
			redirectAttributes.addFlashAttribute("sucesso", SUCCESS_EDIT);
			return "redirect:/locais";
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			if(local == null)
				return "redirect:/locais"; 
			return "redirect:/locais/" + local.getCodigo() + "/editar";
		}
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		AreaGeologia a = new AreaGeologia();
		a.setCodigo(id);
		
		try {
			service.remover(a);
			redirectAttributes.addFlashAttribute("sucesso", SUCCESS_DELETE);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/locais";
	}
	
	@GetMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") AreaGeologia filtro) {
		return "local/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") AreaGeologia filtro, RedirectAttributes redirectAttributes) {
		if(filtro != null && filtro.getNome().trim().isEmpty())
			filtro.setNome(null);
		try {
			List<AreaGeologia> locais = service.consultar(filtro);
			redirectAttributes.addFlashAttribute("locais", locais);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/locais/buscar";
	}
}
