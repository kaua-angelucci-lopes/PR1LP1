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
import com.luciene.projetoteste.ordemservico.entities.ServicoEntity;
import com.luciene.projetoteste.ordemservico.services.ServicoService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/servico")
public class ServicoController {
 private final ServicoService ServicoService;
    @GetMapping
    public ResponseEntity<List<ServicoEntity>> 
    listarTodos() {
        List<ServicoEntity> lista = 
        ServicoService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<ServicoEntity> 
    incluir(@RequestBody ServicoEntity Servico) {
        ServicoEntity novo = ServicoService.
        incluir(Servico);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoEntity> 
    editar(@PathVariable int id, 
    @RequestBody ServicoEntity Servico) {
        ServicoEntity atualizado = ServicoService.
        editar(id,Servico);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        ServicoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
