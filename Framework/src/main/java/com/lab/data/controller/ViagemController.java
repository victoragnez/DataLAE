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
import com.lab.data.model.AtividadeGeologia;
import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.ProjetoGeologia;
import com.lab.data.model.old.Local;
import com.lab.data.model.old.Projeto;
import com.lab.data.model.old.Viagem;
import com.lab.data.service.old.LocalService;
import com.lab.data.service.old.ProjetoService;
import com.lab.data.service.old.ViagemService;

import framework.dao.interfaces.DatabaseException;
import framework.model.Atividade;
import framework.service.interfaces.IServiceArea;
import framework.service.interfaces.IServiceAtividade;
import framework.service.interfaces.IServiceProjeto;

@Controller
@RequestMapping("/viagens")
public class ViagemController {
	
	private static final String LIST_ERROR = "Falha ao tentar acessar banco de dados. Não foi possível listar os pesquisadores.";
	private static final String INSERT_SUCCESS = "Viagem inserida com sucesso!";
	
	
	private AtividadeGeologia buscarViagemPorId(Integer id) throws DatabaseException, NenhumEncontradoException {
		AtividadeGeologia v = new AtividadeGeologia();
		v.setCodigo(id);
		List<AtividadeGeologia> list = viagemService.consultar(v);
		if(list == null || list.size() != 1)
			throw new NenhumEncontradoException("Viagem com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	
	
	@Autowired
	private IServiceAtividade<AtividadeGeologia> viagemService;
	
	@Autowired
	private IServiceArea<AreaGeologia> localService;
	
	@Autowired
	private IServiceProjeto<ProjetoGeologia> projetoService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<AtividadeGeologia> viagens = viagemService.listar();
			model.addAttribute("viagens", viagens);
		} catch (DatabaseException e) {
			model.addAttribute("erro", LIST_ERROR);
		}
		return "viagem/index";
	}
	
	@GetMapping("/cadastrar")
	public String formViagemCad(Model model, @ModelAttribute("viagem") AtividadeGeologia viagem, RedirectAttributes redirectAttributes) {
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
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
		return "viagem/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("viagem") AtividadeGeologia viagem, RedirectAttributes redirectAtrributes) {
		try {
			viagemService.inserir(viagem);
			redirectAtrributes.addFlashAttribute("sucesso", INSERT_SUCCESS);
		} catch (DatabaseException e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/viagens";
	}
	
	@GetMapping("/{id}/editar")
	public String formProjetoEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		
		
		/*
		if(id != null) {
			Viagem v = viagemService.buscarPorId(id);
			if(v == null) {
				redirectAttributes.addFlashAttribute("erro", "Falha ao tentar editar Viagem: Viagem não existe!");
				return "redirect:/viagens";
			}
			model.addAttribute("viagem", v);
			List<ProjetoGeologia> projetos;
			try {
				projetos = projetoService.listar();
			} catch (DatabaseException e) {
				redirectAttributes.addFlashAttribute("erro", e.getMessage());
				return "redirect:/viagens";
			}
			List<Local> locais = localService.listar();
			model.addAttribute("projetos", projetos);
			model.addAttribute("locais", locais);
		}
		*/
		return "viagem/form";
	}
	
	@PutMapping
	public String edit(Viagem viagem, RedirectAttributes redirectAttributes) {
		/*
		try {
			viagemService.atualizar(viagem);
			redirectAttributes.addFlashAttribute("sucesso", "Viagem editada com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		*/
		return "redirect:/viagens";
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		/*
		try {
			viagemService.removerPorId(id);
			redirectAttributes.addFlashAttribute("sucesso", "Viagem deletada com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		*/
		return "redirect:/viagens";
	}
	
	@GetMapping("/buscar")
	public String filtros(Model model, @ModelAttribute("filtro") Viagem  filtro, RedirectAttributes redirectAttributes) {
		/*
		List<ProjetoGeologia> projetos;
		try {
			projetos = projetoService.listar();
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/viagens";
		}
<<<<<<< HEAD
		List<Local> locais = localService.listar();
		model.addAttribute("projetos", projetos);
		model.addAttribute("locais", locais);
		*/

		return "viagem/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") Viagem filtro, RedirectAttributes redirectAttributes) {
		/*
		if(filtro.getInicio().trim().isEmpty())
			filtro.setInicio(null);
		if(filtro.getFim().trim().isEmpty())
			filtro.setFim(null);
		
		List<Viagem> viagens = viagemService.buscar(filtro);
		redirectAttributes.addFlashAttribute("viagens", viagens);
		*/
		return "redirect:/viagens/buscar";
	}
}
