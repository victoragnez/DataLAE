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

import com.lab.data.model.Arquivo;
import com.lab.data.service.ArquivoService;

@Controller
@RequestMapping("/arquivos")
public class ArquivoController {
	
	@Autowired
	private ArquivoService service;
	
	@GetMapping
	public String index(Model model) {
		List<Arquivo> arquivos = service.listar();
		model.addAttribute("arquivos", arquivos);
		return "arquivo/index";
	}
	
	@GetMapping("/cadastrar")
	public String formArquivoCad(@ModelAttribute("arquivo") Arquivo arquivo) {
		return "arquivo/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("arquivo") Arquivo arquivo, RedirectAttributes redirectAtrributes) {
		try {
			service.inserir(arquivo);
			redirectAtrributes.addFlashAttribute("sucesso", "Arquivo inserido com sucesso!");
		} catch (Exception e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/arquivos";
	}
	
	@GetMapping("/{id}/editar")
	public String formArquivoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		if(id != null) {
			Arquivo a = service.buscarPorId(id);
			if(a == null) {
				redirectAttributes.addFlashAttribute("erro", "Falha ao tentar editar Arquivo: Arquivo não existe!");
				return "redirect:/arquivos";
			}
			model.addAttribute("arquivo", a);
		}
		return "arquivo/form";
	}
	
	@PutMapping
	public String edit(Arquivo arquivo, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(arquivo);
			redirectAttributes.addFlashAttribute("sucesso", "Arquivo editado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/arquivos";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			service.removerPorId(id);
			redirectAttributes.addFlashAttribute("sucesso", "Arquivo deletado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/arquivos";
	}
}
