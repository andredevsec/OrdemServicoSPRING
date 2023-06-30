package br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.OrdemServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer>{

}
