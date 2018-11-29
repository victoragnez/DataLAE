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
import com.lab.data.exception.NenhumEncontradoException;

import framework.dao.interfaces.DatabaseException;
import framework.service.interfaces.IServiceArea;

@Controller
@RequestMapping("/maquinas")
public class MaquinaController {
	
	private static final String SUCCESS_INSERT = "Local inserido com sucesso!";
	private static final String ERROR_EDIT = "Não foi possível editar projeto!";
	private static final String SUCCESS_EDIT = "Local editado com sucesso!";
	private static final String SUCCESS_DELETE = "Local deletado com sucesso!";
	
	@Autowired
	private IServiceArea<AreaAE> service;
	
	private AreaAE buscarAreaPorId(Integer id) throws DatabaseException, NenhumEncontradoException {
		AreaAE maquina = new AreaAE();
		maquina.setCodigo(id);
		List<AreaAE> list = service.consultar(maquina);
		if(list.size() != 1)
			throw new NenhumEncontradoException("Máquina com codigo igual a '" + id + "' não existe!");
		return list.get(0);
	}
	
	@GetMapping
	public String index(Model model, RedirectAttributes redirectAttributes) {
		List<AreaAE> maquinas;
		try {
			maquinas = service.listar();
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/";
		}
		model.addAttribute("maquinas", maquinas);
		return "dataae/maquinas/index";
	}
	
	@GetMapping("/cadastrar")
	public String formLocalCad(@ModelAttribute("maquina") AreaAE maquina) {
		return "dataae/maquina/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute("maquina") AreaAE maquina, RedirectAttributes redirectAtrributes) {
		try {
			service.inserir(maquina);
			redirectAtrributes.addFlashAttribute("sucesso", SUCCESS_INSERT);
		} catch (Exception e) {
			redirectAtrributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/maquinas/cadastrar";
		}
		return "redirect:/maquinas";
	}
	
	@GetMapping("/{id}/editar")
	public String formLocalEdit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		if(id == null) {
			redirectAttributes.addFlashAttribute("erro", ERROR_EDIT);
			return "redirect:/maquinas";
		}
		try {
			AreaAE m = buscarAreaPorId(id);
			model.addAttribute("maquina", m);
			return "dataae/maquina/form";
		} catch (DatabaseException | NenhumEncontradoException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/maquinas";
		}
	}
	
	@PutMapping
	public String edit(AreaAE maquina, RedirectAttributes redirectAttributes) {
		try {
			service.atualizar(maquina);
			redirectAttributes.addFlashAttribute("sucesso", SUCCESS_EDIT);
			return "redirect:/maquinas";
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			if(maquina == null)
				return "redirect:/maquinas"; 
			return "redirect:/maquinas/" + maquina.getCodigo() + "/editar";
		}
	}
	
	@GetMapping("/{id}/apagar")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		AreaAE maquina = new AreaAE();
		maquina.setCodigo(id);
		
		try {
			service.remover(maquina);
			redirectAttributes.addFlashAttribute("sucesso", SUCCESS_DELETE);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/maquinas";
	}
	
	@GetMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") AreaAE filtro) {
		return "dataae/maquina/search"; 
	}
	
	@PostMapping("/buscar")
	public String filtros(@ModelAttribute("filtro") AreaAE filtro, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filtro", filtro);
		if(filtro != null && filtro.getNome().trim().isEmpty())
			filtro.setNome(null);
		try {
			List<AreaAE> maquinas = service.consultar(filtro);
			redirectAttributes.addFlashAttribute("maquinas", maquinas);
		} catch (DatabaseException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
		}
		return "redirect:/maquinas/buscar";
	}
}
