package com.luciene.projetoteste.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciene.projetoteste.ordemservico.entities.ServicoEntity;
@Repository
public interface ServicoRepository 
extends JpaRepository<ServicoEntity,Integer>
{

}
