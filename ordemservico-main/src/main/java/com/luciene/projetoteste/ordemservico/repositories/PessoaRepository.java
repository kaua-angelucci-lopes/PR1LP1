package com.luciene.projetoteste.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciene.projetoteste.ordemservico.entities.PessoaEntity;
@Repository
public interface PessoaRepository 
extends JpaRepository<PessoaEntity,Integer>
{

}
