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
import com.lab.estatistica.model.AreaEstatistica;
import com.lab.estatistica.model.PraticaEstatistica;
import com.lab.estatistica.model.ProjetoEstatistica;

import framework.dao.interfaces.DatabaseException;
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
	
	
	private PraticaEstatistica buscarViagemPorId(Integer id) throws DatabaseException, NenhumEncontradoException {
		PraticaEstatistica v = new PraticaEstatistica();
		v.setCodigo(id);
		List<PraticaEstatistica> list = experimentoService.consultar(v);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Viagem com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@Autowired
	private IServiceAtividade<AreaEstatistica, ProjetoEstatistica, PraticaEstatistica> experimentoService;
	
	@Autowired
	private IServiceArea<AreaEstatistica> localService;
	
	@Autowired
	private IServiceProjeto<ProjetoEstatistica> projetoService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<PraticaEstatistica> experimentos = experimentoService.listar();
			model.addAttribute("experimentos", experimentos);
		} catch (DatabaseException e) {
			model.addAttribute("erro", LIST_ERROR);
		}
		return "dataest/experimento/index";
	}
	
	@GetMapping("/cadastrar")
	public String formViagemCad(Model model, @ModelAttribute("experimento") PraticaEstatistica experimento, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoEstatistica> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		try {
			List<AreaEstatistica> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		return "dataest/experimento/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("experimento") PraticaEstatistica viagem, RedirectAttributes redirectAtrributes) {
		try {
			experimentoService.inserir(viagem);
			redirectAtrributes.addFlashAttribute("sucesso", INSERT_SUCCESS);
		} catch (DatabaseException e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/experimentos";
	}
	
	@GetMapping("/{id}/editar")
	public String formProjetoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoEstatistica> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		try {
			List<AreaEstatistica> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		try {
			PraticaEstatistica exp = buscarViagemPorId(id);
			model.addAttribute("experimento", exp);
			return "dataest/experimento/form";
		} catch (DatabaseException | NenhumEncontradoException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
	}
	
	@PutMapping
	public String edit(PraticaEstatistica experimento, RedirectAttributes redirectAttributes) {
		try {
			experimentoService.atualizar(experimento);
			redirectAttributes.addFlashAttribute("sucesso", EDIT_SUCCESS);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/experimentos";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			PraticaEstatistica exp = new PraticaEstatistica();
			exp.setCodigo(id);
			experimentoService.remover(exp);
			redirectAttributes.addFlashAttribute("sucesso", DELETE_SUCCESS);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/experimentos";
	}
	
	@GetMapping("/buscar")
	public String filtros(Model model, @ModelAttribute("filtro") PraticaEstatistica filtro, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoEstatistica> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		try {
			List<AreaEstatistica> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/experimentos";
		}
		return "dataest/experimento/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") PraticaEstatistica filtro, RedirectAttributes redirectAttributes) {		
		/*
		if(filtro.getInicio().trim().isEmpty())
			filtro.setInicio(null);
		if(filtro.getFim().trim().isEmpty())
			filtro.setFim(null);
		
		List<Viagem> viagens = viagemService.buscar(filtro);
		redirectAttributes.addFlashAttribute("viagens", viagens);
		*/
		return "redirect:/experimentos/buscar";
	}
}
