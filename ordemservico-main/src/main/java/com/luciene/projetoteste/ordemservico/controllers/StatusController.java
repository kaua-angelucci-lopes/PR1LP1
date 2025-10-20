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
import com.luciene.projetoteste.ordemservico.entities.StatusEntity;
import com.luciene.projetoteste.ordemservico.services.StatusService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/status")
public class StatusController {
 private final StatusService StatusService;
    @GetMapping
    public ResponseEntity<List<StatusEntity>> 
    listarTodos() {
        List<StatusEntity> lista = 
        StatusService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<StatusEntity> 
    incluir(@RequestBody StatusEntity Status) {
        StatusEntity novo = StatusService.
        incluir(Status);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusEntity> 
    editar(@PathVariable int id, 
    @RequestBody StatusEntity Status) {
        StatusEntity atualizado = StatusService.
        editar(id,Status);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        StatusService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
