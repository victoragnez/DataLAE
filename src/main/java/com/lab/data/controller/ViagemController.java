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
import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.PraticaGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.service.interfaces.IServiceArea;
import framework.service.interfaces.IServiceAtividade;
import framework.service.interfaces.IServiceParticipante;
import framework.service.interfaces.IServiceProjeto;

@Controller
@RequestMapping("/viagens")
public class ViagemController {
	
	private static final String LIST_ERROR = "Falha ao tentar acessar banco de dados. Não foi possível listar as viagens.";
	private static final String INSERT_SUCCESS = "Viagem inserida com sucesso!";
	private static final String EDIT_SUCCESS = "Viagem editada com sucesso!";
	private static final String DELETE_SUCCESS = "Viagem deletada com sucesso!";
	
	
	private PraticaGeologia buscarViagemPorId(Integer id) throws DatabaseException, NenhumEncontradoException, BadAttributeException {
		PraticaGeologia v = new PraticaGeologia();
		v.setCodigo(id);
		List<PraticaGeologia> list = viagemService.consultar(v);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Viagem com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@Autowired
	private IServiceAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia, ParticipanteGeologia> viagemService;
	
	@Autowired
	private IServiceArea<AreaGeologia> localService;
	
	@Autowired
	private IServiceProjeto<ProjetoGeologia> projetoService;
	
	@Autowired
	private IServiceParticipante<ParticipanteGeologia> serviceParticipante;
	
	private class Comparador {
		@SuppressWarnings("unused") // usado pelo thymeleaf
		public boolean compare(List<ParticipanteGeologia> p1, ParticipanteGeologia p2) {
			if(p1 != null) {			
				for(ParticipanteGeologia p : p1) {
					if(p2 == null)
						System.out.println("> Erro");
					if(p.getCodigo().equals(p2.getCodigo()))
						return true;
				}
			}
			return false;
		}
	}
	
	@GetMapping
	public String index(Model model) {
		try {
			List<PraticaGeologia> viagens = viagemService.listar();
			model.addAttribute("viagens", viagens);
		} catch (DatabaseException e) {
			model.addAttribute("erro", LIST_ERROR);
		}
		return "datalae/viagem/index";
	}
	
	@GetMapping("/cadastrar")
	public String formViagemCad(Model model, @ModelAttribute("viagem") PraticaGeologia viagem, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoGeologia> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		try {
			List<AreaGeologia> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}		
		try {
			List<ParticipanteGeologia> participantes = serviceParticipante.listar();
			model.addAttribute("participantes", participantes);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", "Não foi possível encontrar pesquisadores");
			return "redirect:/viagens";
		}
		return "datalae/viagem/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("viagem") PraticaGeologia viagem, RedirectAttributes redirectAtrributes) {
		try {
			viagemService.inserir(viagem);
			redirectAtrributes.addFlashAttribute("sucesso", INSERT_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens";
	}
	
	@GetMapping("/{id}/editar")
	public String formProjetoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			List<ParticipanteGeologia> participantes = serviceParticipante.listar();
			model.addAttribute("participantes", participantes);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", "Não foi possível encontrar pesquisadores");
			return "redirect:/viagens";
		}		
		try {
			List<ProjetoGeologia> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		try {
			List<AreaGeologia> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		try {
			PraticaGeologia v = buscarViagemPorId(id);
			model.addAttribute("viagem", v);
			model.addAttribute("comparador", new Comparador());
			return "datalae/viagem/form";
		} catch (DatabaseException | NenhumEncontradoException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
	}
	
	@PutMapping
	public String edit(PraticaGeologia viagem, RedirectAttributes redirectAttributes) {
		try {
			viagemService.atualizar(viagem);
			redirectAttributes.addFlashAttribute("sucesso", EDIT_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			PraticaGeologia v = new PraticaGeologia();
			v.setCodigo(id);
			viagemService.remover(v);
			redirectAttributes.addFlashAttribute("sucesso", DELETE_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens";
	}
	
	@GetMapping("/buscar")
	public String filtros(Model model, @ModelAttribute("filtro") PraticaGeologia  filtro, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoGeologia> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		try {
			List<AreaGeologia> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		return "datalae/viagem/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") PraticaGeologia filtro, RedirectAttributes redirectAttributes) {		
		redirectAttributes.addFlashAttribute("filtro", filtro);
		try {
			List<PraticaGeologia> viagens = viagemService.consultar(filtro);
			redirectAttributes.addFlashAttribute("viagens", viagens);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens/buscar";
	}
	
	@GetMapping("/{id}/detalhes")
	public String detalhes(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
		
		try {
			PraticaGeologia p = buscarViagemPorId(id);
			model.addAttribute("viagem", p);
		} catch (DatabaseException | NenhumEncontradoException | BadAttributeException e1) {
			redirectAttributes.addFlashAttribute("erro", "Não foi possível encontrar viagem com id = " + id);
			return "redirect:/viagens";
		}
		
		return "datalae/viagem/details";
	}
}
