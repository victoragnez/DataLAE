package com.lab.ae.controller;

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

import com.lab.ae.model.AreaAE;
import com.lab.ae.model.PraticaAE;
import com.lab.ae.model.ProjetoAE;
import com.lab.data.exception.NenhumEncontradoException;

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.service.interfaces.IServiceArea;
import framework.service.interfaces.IServiceAtividade;
import framework.service.interfaces.IServiceProjeto;

@Controller
@RequestMapping("/experimentos")
public class ExperimentoController {
	
	private static final String LIST_ERROR = "Falha ao tentar acessar banco de dados. Não foi possível listar as viagens.";
	private static final String INSERT_SUCCESS = "Viagem inserida com sucesso!";
	private static final String EDIT_SUCCESS = "Viagem editada com sucesso!";
	private static final String DELETE_SUCCESS = "Viagem deletada com sucesso!";
	
	
	private PraticaAE buscarViagemPorId(Integer id) throws DatabaseException, NenhumEncontradoException, BadAttributeException {
		PraticaAE v = new PraticaAE();
		v.setCodigo(id);
		List<PraticaAE> list = experimentoService.consultar(v);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Experimento com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@Autowired
	private IServiceAtividade<AreaAE, ProjetoAE, PraticaAE> experimentoService;
	
	@Autowired
	private IServiceArea<AreaAE> localService;
	
	@Autowired
	private IServiceProjeto<ProjetoAE> projetoService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<PraticaAE> experimentos = experimentoService.listar();
			model.addAttribute("experimentos", experimentos);
		} catch (DatabaseException e) {
			model.addAttribute("erro", LIST_ERROR);
		}
		return "dataae/experimento/index";
	}
	
	@GetMapping("/cadastrar")
	public String formViagemCad(Model model, @ModelAttribute("experimento") PraticaAE experimento, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoAE> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		try {
			List<AreaAE> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		return "dataae/experimento/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("experimento") PraticaAE experimento, RedirectAttributes redirectAtrributes) {
		try {
			experimentoService.inserir(experimento);
			redirectAtrributes.addFlashAttribute("sucesso", INSERT_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/experimentos";
	}
	
	@GetMapping("/{id}/editar")
	public String formProjetoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoAE> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		try {
			List<AreaAE> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		try {
			PraticaAE experimento = buscarViagemPorId(id);
			model.addAttribute("experimento", experimento);
			return "dataae/experimento/form";
		} catch (DatabaseException | NenhumEncontradoException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
	}
	
	@PutMapping
	public String edit(PraticaAE experimento, RedirectAttributes redirectAttributes) {
		try {
			experimentoService.atualizar(experimento);
			redirectAttributes.addFlashAttribute("sucesso", EDIT_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/experimentos";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			PraticaAE experimento = new PraticaAE();
			experimento.setCodigo(id);
			experimentoService.remover(experimento);
			redirectAttributes.addFlashAttribute("sucesso", DELETE_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/experimentos";
	}
	
	@GetMapping("/buscar")
	public String filtros(Model model, @ModelAttribute("filtro") PraticaAE  filtro, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoAE> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		try {
			List<AreaAE> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		return "datalae/experimento/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") PraticaAE filtro, RedirectAttributes redirectAttributes) {		
		redirectAttributes.addFlashAttribute("filtro", filtro);
		try {
			List<PraticaAE> experimentos = experimentoService.consultar(filtro);
			redirectAttributes.addFlashAttribute("experimentos", experimentos);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens/buscar";
	}
}
