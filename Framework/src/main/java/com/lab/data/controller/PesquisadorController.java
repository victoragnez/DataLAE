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

import com.lab.data.model.Pesquisador;
import com.lab.data.service.PesquisadorService;

@Controller
@RequestMapping("/pesquisadores")
public class PesquisadorController {
	@Autowired
	private PesquisadorService service;
	
	@GetMapping
	public String index(Model model) {
		List<Pesquisador> pesqs = service.listar();
		model.addAttribute("pesquisadores", pesqs);
		return "pesquisador/index";
	}
	
	@GetMapping("/cadastrar")
	public String formPesquisadorCad(@ModelAttribute("pesquisador") Pesquisador pesquisador) {
		return "pesquisador/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("pesquisador") Pesquisador pesquisador, RedirectAttributes redirectAtrributes) {
		try {
			service.inserir(pesquisador);
			redirectAtrributes.addFlashAttribute("sucesso", "Pesquisador inserido com sucesso!");
		} catch (Exception e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisadores";
	}
	
	@GetMapping("/{id}/editar")
	public String formPesquisadorEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		if(id != null) {
			Pesquisador p = service.buscarPorId(id);
			if(p == null) {
				redirectAttributes.addFlashAttribute("erro", "Falha ao tentar editar pesquisador: Pesquisador não existe!");
				return "redirect:/pesquisadores";
			}
			model.addAttribute("pesquisador", p);
		}
		return "pesquisador/form";
	}
	
	@PutMapping
	public String edit(Pesquisador pesquisador, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(pesquisador);
			redirectAttributes.addFlashAttribute("sucesso", "Pesquisador editado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisadores";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			service.removerPorId(id);
			redirectAttributes.addFlashAttribute("sucesso", "Pesquisador deletado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisadores";
	}
}
