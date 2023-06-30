package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Cliente;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.OrdemServico;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Produto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ClienteRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.OrdemServicoRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ProdutoRepository;

@Controller
public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoRepository ordemservicoRepository; 
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Autowired
	private ProdutoRepository produtoRepository; 
	
	
	@GetMapping("/ordens")
	public String ordensservicos(Model model) {
		
		List<OrdemServico> ordens = ordemservicoRepository.findAll();
		model.addAttribute("ordens", ordens);
		
		
		return "ordens";
	}
	
	@GetMapping("/ordens/form")
	public String ordemservicoForm(@ModelAttribute("ordens") OrdemServico ordemservico, Model model) {
		
		List<Cliente> clientes = clienteRepository.findAll();
	    model.addAttribute("clientes", clientes);

	    List<Produto> produtos = produtoRepository.findAll();
	    model.addAttribute("produtos", produtos);

		
		return "ordens_form";
		
	}
	
	@PostMapping("/ordens/new")
	public String ordemservicoNew(@ModelAttribute("ordens") OrdemServico ordens) {
		
		ordemservicoRepository.save(ordens);
		
		
		return "redirect:/ordens";
	}
	
	@GetMapping("/ordens/update/{id}")
	public String ordemservicoUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<OrdemServico> optOrdemServico =  ordemservicoRepository.findById(id);
		
		if (!optOrdemServico.isPresent()) {
			// Gerar erro
		}
		
		OrdemServico ordens = optOrdemServico.get();
		 	
			
		
		model.addAttribute("ordens", ordens);
		
		List<Cliente> clientes = clienteRepository.findAll();
	    model.addAttribute("clientes", clientes);

	    List<Produto> produtos = produtoRepository.findAll();
	    model.addAttribute("produtos", produtos);

		
		return "ordens_form";
	}
	
	@GetMapping("/ordens/delete/{id}")
	public String ordemservicoDelete(@PathVariable("id") Integer id) {
		Optional<OrdemServico> optOrdemServico =  ordemservicoRepository.findById(id);
		
		if (!optOrdemServico.isPresent()) {
			// Gerar erro
		}
		
		OrdemServico ordens = optOrdemServico.get();
		
		ordemservicoRepository.delete(ordens);
		
		return "redirect:/ordens";
	}

}
