package br.edu.ifsuldeminas.mch.webii.crudmanager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.UserRepository;

@Component 
@Transactional

public class InitializeDataBase implements CommandLineRunner {
	
	@Autowired //injeção de dependencias, um objeto precisa implementar a interface
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
				
		}
}
