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

import com.lab.data.model.old.Projeto;
import com.lab.data.service.old.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoService service;
	
	@GetMapping
	public String index(Model model) {
		List<Projeto> projs = service.listar();
		model.addAttribute("projetos", projs);
		return "projeto/index";
	}
	
	@GetMapping("/cadastrar")
	public String formProjetoCad(@ModelAttribute("projeto") Projeto projeto) {
		return "projeto/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("projeto") Projeto projeto, RedirectAttributes redirectAtrributes) {
		try {
			service.inserir(projeto);
			redirectAtrributes.addFlashAttribute("sucesso", "Projeto inserido com sucesso!");
		} catch (Exception e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/projetos";
	}
	
	@GetMapping("/{id}/editar")
	public String formProjetoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		if(id != null) {
			Projeto p = service.buscarPorId(id);
			if(p == null) {
				redirectAttributes.addFlashAttribute("erro", "Falha ao tentar editar projeto: Projeto não existe!");
				return "redirect:/projetos";
			}
			model.addAttribute("projeto", p);
		}
		return "projeto/form";
	}
	
	@PutMapping
	public String edit(Projeto projeto, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(projeto);
			redirectAttributes.addFlashAttribute("sucesso", "Projeto editado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/projetos";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			service.removerPorId(id);
			redirectAttributes.addFlashAttribute("sucesso", "Projeto deletado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/projetos";
	}
	
	@GetMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") Projeto filtro) {
		return "projeto/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") Projeto filtro, RedirectAttributes redirectAttributes) {
		filtro.setDescricao(null);
		if(filtro.getNome().trim().isEmpty())
			filtro.setNome(null);
		if(filtro.getInicio().trim().isEmpty())
			filtro.setInicio(null);
		
		List<Projeto> projetos = service.buscar(filtro);
		redirectAttributes.addFlashAttribute("projetos", projetos);
		return "redirect:/projetos/buscar";
	}
}