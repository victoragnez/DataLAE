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
import com.lab.estatistica.model.ProjetoEstatistica;

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.service.interfaces.IServiceParticipante;
import framework.service.interfaces.IServiceProjeto;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
	
	private static final String SUCCESS_INSERT = "Projeto inserido com sucesso!";
	private static final String ERROR_EDIT = "Falha ao tentar editar projeto!";
	private static final String SUCCESS_EDIT = "Projeto editado com sucesso!";
	private static final String SUCCESS_DELETE = "Projeto deletado com sucesso!";

	private ProjetoEstatistica buscarProjetoPorId(Integer id) throws DatabaseException, NenhumEncontradoException, BadAttributeException {
		ProjetoEstatistica p = new ProjetoEstatistica();
		p.setCodigo(id);
		List<ProjetoEstatistica> list = service.consultar(p);
		if(list.size() != 1)
			throw new NenhumEncontradoException("Projeto com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	private class Comparador {
		@SuppressWarnings("unused") // usado pelo thymeleaf
		public boolean compare(List<ParticipanteEstatistica> p1, ParticipanteEstatistica p2) {
			for(ParticipanteEstatistica p : p1)
				if(p.getCodigo().equals(p2.getCodigo()))
					return true;
			return false;
		}
	}
	
	@Autowired
	private IServiceProjeto<ProjetoEstatistica> service;
	
	@Autowired
	private IServiceParticipante<ParticipanteEstatistica> serviceParticipante;
	
	@GetMapping
	public String index(Model model, RedirectAttributes redirectAttributes) {
		List<ProjetoEstatistica> projs;
		try {
			projs = service.listar();
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/";
		}
		model.addAttribute("projetos", projs);
		return "dataest/projeto/index";
	}
	
	@GetMapping("/cadastrar")
	public String formProjetoCad(@ModelAttribute("projeto") ProjetoEstatistica projeto, Model model, RedirectAttributes redirectAttributes) {
		try {
			List<ParticipanteEstatistica> participantes = serviceParticipante.listar();
			model.addAttribute("participantes", participantes);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", "Não foi possível encontrar pesquisadores");
			return "redirect:/projetos";
		}
		return "dataest/projeto/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("projeto") ProjetoEstatistica projeto, RedirectAttributes redirectAtrributes) {
		try {
			service.inserir(projeto);
			redirectAtrributes.addFlashAttribute("sucesso", SUCCESS_INSERT);
		} catch (Exception e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/projetos/cadastrar";
		}
		return "redirect:/projetos";
	}
	
	@GetMapping("/{id}/editar")
	public String formProjetoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			List<ParticipanteEstatistica> participantes = serviceParticipante.listar();
			model.addAttribute("participantes", participantes);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", "Não foi possível encontrar pesquisadores");
			return "redirect:/projetos";
		}
		if(id != null) {
			ProjetoEstatistica p;
			try {
				p = buscarProjetoPorId(id);
			} catch (DatabaseException | NenhumEncontradoException e) {
				redirectAttributes.addFlashAttribute("erro", e.getMessage());
				return "redirect:/projetos";
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("erro", ERROR_EDIT);
				return "redirect:/projetos";
			}
			
			model.addAttribute("projeto", p);
		}
		model.addAttribute("comparador", new Comparador());
		return "dataest/projeto/form";
	}
	
	@PutMapping
	public String edit(ProjetoEstatistica projeto, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(projeto);
			redirectAttributes.addFlashAttribute("sucesso", SUCCESS_EDIT);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/projetos";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			ProjetoEstatistica p = new ProjetoEstatistica();
			p.setCodigo(id);
			service.remover(p);
			redirectAttributes.addFlashAttribute("sucesso", SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/projetos";
	}
	
	@GetMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") ProjetoEstatistica filtro) {
		return "dataest/projeto/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") ProjetoEstatistica filtro, RedirectAttributes redirectAttributes) {
		if(filtro.getNome().trim().isEmpty())
			filtro.setNome(null);
		
		List<ProjetoEstatistica> projetos;
		try {
			projetos = service.consultar(filtro);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			projetos = null;
		}
		redirectAttributes.addFlashAttribute("projetos", projetos);
		return "redirect:/projetos/buscar";
	}
	
	@GetMapping("/{id}/detalhes")
	public String detalhes(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
		
		try {
			ProjetoEstatistica p = buscarProjetoPorId(id);
			model.addAttribute("projeto", p);
			model.addAttribute("pesquisadores", p.getParticipantes());
		} catch (DatabaseException | NenhumEncontradoException | BadAttributeException e1) {
			redirectAttributes.addFlashAttribute("erro", "Não foi possível encontrar o projeto com id = " + id);
			return "redirect:/projetos";
		}
		
		return "dataest/projeto/details";
	}
}