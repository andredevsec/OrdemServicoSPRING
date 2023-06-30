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

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Produto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository; 
	
	@GetMapping("/produtos")
	public String produtos(Model model) {
		
		List<Produto> produto = produtoRepository.findAll();
		model.addAttribute("produtos", produto);
		
		
		return "produtos";
	}
	
	@GetMapping("/produtos/form")
	public String produtoForm(@ModelAttribute("produto") Produto produto) {
		
		
		return "produtos_form";
		
	}
	
	@PostMapping("/produtos/new")
	public String produtoNew(@ModelAttribute("produto") Produto produto) {
		
		produtoRepository.save(produto);
		
		
		return "redirect:/produtos";
	}
	
	@GetMapping("/produtos/update/{id}")
	public String produtoUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Produto> optProduto =  produtoRepository.findById(id);
		
		if (!optProduto.isPresent()) {
			// Gerar erro
		}
		
		Produto produto = optProduto.get();
		
		model.addAttribute("produto", produto);
		
		return "produtos_form";
	}
	
	@GetMapping("/produtos/delete/{id}")
	public String produtoUpdate(@PathVariable("id") Integer id) {
		Optional<Produto> optProduto =  produtoRepository.findById(id);
		
		if (!optProduto.isPresent()) {
			// Gerar erro
		}
		
		Produto produto = optProduto.get();
		
		produtoRepository.delete(produto);
		
		return "redirect:/produtos";
	}

}
