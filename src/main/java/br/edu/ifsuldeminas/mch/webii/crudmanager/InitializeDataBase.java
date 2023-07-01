package br.edu.ifsuldeminas.mch.webii.crudmanager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Cliente;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Produto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.OrdemServico;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.UserRepository;

@Component 
@Transactional

public class InitializeDataBase implements CommandLineRunner {
	
	@Autowired //injeção de dependencias, um objeto precisa implementar a interface
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setName("John Doe");
		cliente.setEmail("johndoe@example.com");
		cliente.setPhone("1234567890");	
		
		Produto produto = new Produto();
		produto.setId(1);
		produto.setName("Produto A");
		produto.setMarca("Marca X");
		produto.setValor(10.5);
		
		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setId(1);
		ordemServico.setCliente(cliente);
		ordemServico.setProduto(produto);		
		ordemServico.setServico("Serviço de exemplo");
				
		}
}
