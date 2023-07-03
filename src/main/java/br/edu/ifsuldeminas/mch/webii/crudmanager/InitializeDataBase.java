package br.edu.ifsuldeminas.mch.webii.crudmanager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Cliente;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Produto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.OrdemServico;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ClienteRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.OrdemServicoRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ProdutoRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.UserRepository;

@Component 
@Transactional

public class InitializeDataBase implements CommandLineRunner {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Autowired 
	private OrdemServicoRepository ordemRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente();		
		cliente.setName("John Doe");
		cliente.setEmail("johndoe@example.com");
		cliente.setPhone("1234567890");	
		clienteRepository.save(cliente);
		
		Produto produto = new Produto();		
		produto.setName("Produto A");
		produto.setMarca("Marca X");
		produto.setValor(10.5);
		produtoRepository.save(produto);	
		
		OrdemServico ordemServico = new OrdemServico();		
		ordemServico.setCliente(cliente);
		ordemServico.setProduto(produto);		
		ordemServico.setServico("Serviço de exemplo");
		ordemRepository.save(ordemServico);
		
		}
}
