package com.luciene.projetoteste.ordemservico.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luciene.projetoteste.ordemservico.entities.OrdemServicoEntity;
import com.luciene.projetoteste.ordemservico.repositories.OrdemServicoRepository;
import com.luciene.projetoteste.ordemservico.services.OrdemServicoService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/ordemservico")
public class OrdemServicoController {
 private final OrdemServicoService OrdemServicoService;
    @GetMapping
    public ResponseEntity<List<OrdemServicoEntity>> 
    listarTodos() {
        List<OrdemServicoEntity> lista = 
        OrdemServicoService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<OrdemServicoEntity> 
    incluir(@RequestBody OrdemServicoEntity OrdemServico) {
        OrdemServicoEntity novo = OrdemServicoService.
        incluir(OrdemServico);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServicoEntity> 
    editar(@PathVariable int id, 
    @RequestBody OrdemServicoEntity OrdemServico) {
        OrdemServicoEntity atualizado = OrdemServicoService.
        editar(id,OrdemServico);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        OrdemServicoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
