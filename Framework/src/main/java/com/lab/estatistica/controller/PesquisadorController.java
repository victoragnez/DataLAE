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
import com.lab.estatistica.model.ParticipanteEstatistica;

import framework.dao.interfaces.DatabaseException;
import framework.service.interfaces.IServiceParticipante;

@Controller
@RequestMapping("/pesquisadores")
public class PesquisadorController {
	@Autowired
	private IServiceParticipante<ParticipanteEstatistica> service;
	
	private static final String ERROR = "Falha ao tentar acessar banco de dados. Não foi possível listar os pesquisadores.";
	private static final String INSERT_SUCCESS = "Pesquisador inserido com sucesso!";
	private static final String EDIT_SUCCESS = "Pesquisador editado com sucesso!";
	
	private ParticipanteEstatistica buscarParticipantePorId(Integer id) throws DatabaseException, NenhumEncontradoException {
		ParticipanteEstatistica p = new ParticipanteEstatistica();
		p.setCodigo(id);
		List<ParticipanteEstatistica> list = service.consultar(p);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Pesquisador com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@GetMapping
	public String index(Model model) {
		try {
			List<ParticipanteEstatistica> pesqs = service.listar();
			model.addAttribute("pesquisadores", pesqs);
		} catch (DatabaseException e) {
			model.addAttribute("erro", ERROR);
		}	
		return "dataest/pesquisador/index";
	}
	
	@GetMapping("/cadastrar")
	public String formPesquisadorCad(@ModelAttribute("pesquisador") ParticipanteEstatistica pesquisador) {
		return "dataest/pesquisador/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("pesquisador") ParticipanteEstatistica pesquisador, RedirectAttributes redirectAtrributes) {
		try {
			service.inserir(pesquisador);
			redirectAtrributes.addFlashAttribute("sucesso", INSERT_SUCCESS);
		} catch (Exception e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisadores";
	}
	
	@GetMapping("/{id}/editar")
	public String formPesquisadorEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			ParticipanteEstatistica p = buscarParticipantePorId(id);
			model.addAttribute("pesquisador", p);
			return "dataest/pesquisador/form";
		} catch (DatabaseException | NenhumEncontradoException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisadores";
		}
	}
	
	@PutMapping
	public String edit(ParticipanteEstatistica pesquisador, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(pesquisador);
			redirectAttributes.addFlashAttribute("sucesso", EDIT_SUCCESS);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisadores";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			ParticipanteEstatistica p = new ParticipanteEstatistica();
			p.setCodigo(id);
			service.remover(p);
			redirectAttributes.addFlashAttribute("sucesso", "Pesquisador deletado com sucesso!");
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisadores";
	}
}
