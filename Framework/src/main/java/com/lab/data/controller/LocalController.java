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

import com.lab.data.model.AreaGeologia;
import com.lab.data.model.old.Local;
import com.lab.data.service.old.LocalService;

import framework.dao.interfaces.DatabaseException;
import framework.service.ServiceArea;

@Controller
@RequestMapping("/locais")
public class LocalController {
	
	private static final String SUCCESS_INSERT = "Local inserido com sucesso!";
	
	@Autowired
	private ServiceArea<AreaGeologia> service;
	
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
		/*
		if(id != null) {
			AreaGeologia local = new AreaGeologia();
			local.setCodigo(id);
			List<AreaGeologia> list = service.consultar(local);
			
		}
		
		*/
		/*
		if(id != null) {
			Local l = service.buscarPorId(id);
			if(l == null) {
				redirectAttributes.addFlashAttribute("erro", "Falha ao tentar editar local: Local não existe!");
				return "redirect:/locais";
			}
			model.addAttribute("local", l);
		}
		*/
		return "local/form";
	}
	
	@PutMapping
	public String edit(Local local, RedirectAttributes redirectAttributes) {
		/*
		try {
			service.atualizar(local);
			redirectAttributes.addFlashAttribute("sucesso", "Local editado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		*/
		return "redirect:/locais";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		/*
		try {
			service.removerPorId(id);
			redirectAttributes.addFlashAttribute("sucesso", "Local deletado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		*/
		return "redirect:/locais";
	}
	
	@GetMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") Local filtro) {
		return "local/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") Local filtro, RedirectAttributes redirectAttributes) {
		/*
		if(filtro.getNome().trim().isEmpty())
			filtro.setNome(null);
		
		List<Local> locais = service.buscar(filtro);
		redirectAttributes.addFlashAttribute("locais", locais);
		*/
		return "redirect:/locais/buscar";
	}
}
