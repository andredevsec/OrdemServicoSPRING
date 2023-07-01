package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Cliente;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@GetMapping("/clientes")
	public String clientes(Model model) {
		
		List<Cliente> cliente = clienteRepository.findAll();
		model.addAttribute("clientes", cliente);
		
		
		return "clientes";
	}
	
	@GetMapping("/clientes/form")
	public String clienteForm(@ModelAttribute("cliente") Cliente cliente) {
		
		
		return "cliente_form";
		
	}
	
	
	@PostMapping("/clientes/new")
	public String clienteNew(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult br) {
		
		if(br.hasErrors()) {
            return "cliente_form";
        }
		
		clienteRepository.save(cliente);
		
		
		return "redirect:/clientes";
	}
	
	@GetMapping("/clientes/update/{id}")
	public String clienteUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Cliente> optCliente =  clienteRepository.findById(id);
		
		if (!optCliente.isPresent()) {
			// Gerar erro
		}
		
		Cliente cliente = optCliente.get();
		
		model.addAttribute("cliente", cliente);
		
		return "cliente_form";
	}
	
	@GetMapping("/clientes/delete/{id}")
	public String clienteDelete(@PathVariable("id") Integer id) {
		Optional<Cliente> optCliente =  clienteRepository.findById(id);
		
		if (!optCliente.isPresent()) {
			// Gerar erro
		}
		
		Cliente cliente = optCliente.get();
		
		clienteRepository.delete(cliente);
		
		return "redirect:/clientes";
	}

}
