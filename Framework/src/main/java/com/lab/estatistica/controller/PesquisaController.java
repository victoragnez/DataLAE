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

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.service.interfaces.IServiceArea;
import framework.service.interfaces.IServiceAtividade;
import framework.service.interfaces.IServiceProjeto;

@Controller
@RequestMapping("/pesquisas")
public class PesquisaController {
	
	private static final String LIST_ERROR = "Falha ao tentar acessar banco de dados. Não foi possível listar as viagens.";
	private static final String INSERT_SUCCESS = "Viagem inserida com sucesso!";
	private static final String EDIT_SUCCESS = "Viagem editada com sucesso!";
	private static final String DELETE_SUCCESS = "Viagem deletada com sucesso!";
	
	
	private PraticaEstatistica buscarViagemPorId(Integer id) throws DatabaseException, NenhumEncontradoException, BadAttributeException {
		PraticaEstatistica v = new PraticaEstatistica();
		v.setCodigo(id);
		List<PraticaEstatistica> list = pesquisaService.consultar(v);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Pesquisa com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@Autowired
	private IServiceAtividade<AreaEstatistica, ProjetoEstatistica, PraticaEstatistica> pesquisaService;
	
	@Autowired
	private IServiceArea<AreaEstatistica> localService;
	
	@Autowired
	private IServiceProjeto<ProjetoEstatistica> projetoService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<PraticaEstatistica> pesquisas = pesquisaService.listar();
			model.addAttribute("pesquisas", pesquisas);
		} catch (DatabaseException e) {
			model.addAttribute("erro", LIST_ERROR);
		}
		return "dataest/pesquisa/index";
	}
	
	@GetMapping("/cadastrar")
	public String formViagemCad(Model model, @ModelAttribute("pesquisa") PraticaEstatistica pesquisa, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoEstatistica> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisas";
		}
		try {
			List<AreaEstatistica> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisas";
		}
		return "dataest/pesquisa/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("pesquisa") PraticaEstatistica pesquisa, RedirectAttributes redirectAtrributes) {
		try {
			pesquisaService.inserir(pesquisa);
			redirectAtrributes.addFlashAttribute("sucesso", INSERT_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisas";
	}
	
	@GetMapping("/{id}/editar")
	public String formProjetoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoEstatistica> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisas";
		}
		try {
			List<AreaEstatistica> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisas";
		}
		try {
			PraticaEstatistica pesq = buscarViagemPorId(id);
			model.addAttribute("pesquisa", pesq);
			return "dataest/pesquisa/form";
		} catch (DatabaseException | NenhumEncontradoException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisas";
		}
	}
	
	@PutMapping
	public String edit(PraticaEstatistica pesquisa, RedirectAttributes redirectAttributes) {
		try {
			pesquisaService.atualizar(pesquisa);
			redirectAttributes.addFlashAttribute("sucesso", EDIT_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisas";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			PraticaEstatistica pesq = new PraticaEstatistica();
			pesq.setCodigo(id);
			pesquisaService.remover(pesq);
			redirectAttributes.addFlashAttribute("sucesso", DELETE_SUCCESS);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/pesquisas";
	}
	
	@GetMapping("/buscar")
	public String filtros(Model model, @ModelAttribute("filtro") PraticaEstatistica filtro, RedirectAttributes redirectAttributes) {
		try {
			List<ProjetoEstatistica> projetos = projetoService.listar();
			model.addAttribute("projetos", projetos);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisas";
		}
		try {
			List<AreaEstatistica> locais = localService.listar();
			model.addAttribute("locais", locais);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/pesquisas";
		}
		return "dataest/pesquisa/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") PraticaEstatistica filtro, RedirectAttributes redirectAttributes) {		
		redirectAttributes.addFlashAttribute("filtro", filtro);
		try {
			List<PraticaEstatistica> pesquisas = pesquisaService.consultar(filtro);
			redirectAttributes.addFlashAttribute("pesquisas", pesquisas);
		} catch (DatabaseException | BadAttributeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		
		return "redirect:/pesquisas/buscar";
	}
}
