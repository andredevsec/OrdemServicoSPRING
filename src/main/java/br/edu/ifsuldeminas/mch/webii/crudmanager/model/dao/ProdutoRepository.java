package br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
