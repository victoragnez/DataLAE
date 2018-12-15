package com.lab.data.controller;

import java.util.ArrayList;
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
import com.lab.data.model.Categoria;
import com.lab.data.model.ParticipanteGeologia;

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.service.interfaces.IServiceParticipante;

@Controller
@RequestMapping("/pesquisadores")
public class PesquisadorController {
	@Autowired
	private IServiceParticipante<ParticipanteGeologia> service;
	
	private static final String ERROR = "Falha ao tentar acessar banco de dados. Não foi possível listar os pesquisadores.";
	private static final String INSERT_SUCCESS = "Pesquisador inserido com sucesso!";
	private static final String EDIT_SUCCESS = "Pesquisador editado com sucesso!";
	
	private ParticipanteGeologia buscarParticipantePorId(Integer id) throws DatabaseException, NenhumEncontradoException, BadAttributeException {
		ParticipanteGeologia p = new ParticipanteGeologia();
		p.setCodigo(id);
		List<ParticipanteGeologia> list = service.consultar(p);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Pesquisador com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = new ArrayList<>();
		for(Categoria c : Categoria.values())
			categorias.add(c);
		return categorias;
	}
	
	@GetMapping
	public String index(Model model) {
		try {
			List<ParticipanteGeologia> pesqs = service.listar();
			model.addAttribute("pesquisadores", pesqs);
		} catch (DatabaseException e) {
			model.addAttribute("erro", ERROR);
		}	
		return "datalae/pesquisador/index";
	}
	
	@GetMapping("/cadastrar")
	public String formPesquisadorCad(@ModelAttribute("pesquisador") ParticipanteGeologia pesquisador) {
		return "datalae/pesquisador/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("pesquisador") ParticipanteGeologia pesquisador, RedirectAttributes redirectAtrributes) {
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
			ParticipanteGeologia p = buscarParticipantePorId(id);
			model.addAttribute("pesquisador", p);
			return "datalae/pesquisador/form";
		} catch (DatabaseException | NenhumEncontradoException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisadores";
		}
	}
	
	@PutMapping
	public String edit(ParticipanteGeologia pesquisador, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(pesquisador);
			redirectAttributes.addFlashAttribute("sucesso", EDIT_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisadores";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			ParticipanteGeologia p = new ParticipanteGeologia();
			p.setCodigo(id);
			service.remover(p);
			redirectAttributes.addFlashAttribute("sucesso", "Pesquisador deletado com sucesso!");
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisadores";
	}
}
