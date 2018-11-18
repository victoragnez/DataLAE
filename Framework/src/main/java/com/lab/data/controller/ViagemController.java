package com.lab.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lab.data.model.Local;
import com.lab.data.model.Projeto;
import com.lab.data.model.Viagem;
import com.lab.data.service.LocalService;
import com.lab.data.service.ProjetoService;
import com.lab.data.service.ViagemService;

@Controller
@RequestMapping("/viagens")
public class ViagemController {
	
	@Autowired
	private ViagemService viagemService;
	
	@Autowired
	private LocalService localService;
	
	@Autowired
	private ProjetoService projetoService;
	
	@GetMapping
	public String index(Model model) {
		List<Viagem> viagens = viagemService.listar();
		model.addAttribute("viagens", viagens);
		return "viagem/index";
	}
	
	@GetMapping("/cadastrar")
	public String formViagemCad(Model model, @ModelAttribute("viagem") Viagem viagem) {
		List<Projeto> projetos = projetoService.listar();
		List<Local> locais = localService.listar();
		model.addAttribute("projetos", projetos);
		model.addAttribute("locais", locais);
		return "viagem/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("viagem") Viagem viagem, RedirectAttributes redirectAtrributes) {
		try {
			viagemService.inserir(viagem);
			redirectAtrributes.addFlashAttribute("sucesso", "Viagem inserida com sucesso!");
		} catch (Exception e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens";
	}
}
