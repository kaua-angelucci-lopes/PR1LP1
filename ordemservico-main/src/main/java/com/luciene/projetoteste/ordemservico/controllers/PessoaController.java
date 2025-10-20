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
import com.luciene.projetoteste.ordemservico.entities.PessoaEntity;
import com.luciene.projetoteste.ordemservico.services.PessoaService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/pessoa")
public class PessoaController {
 private final PessoaService PessoaService;
    @GetMapping
    public ResponseEntity<List<PessoaEntity>> 
    listarTodos() {
        List<PessoaEntity> lista = 
        PessoaService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<PessoaEntity> 
    incluir(@RequestBody PessoaEntity Pessoa) {
        PessoaEntity novo = PessoaService.
        incluir(Pessoa);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaEntity> 
    editar(@PathVariable int id, 
    @RequestBody PessoaEntity Pessoa) {
        PessoaEntity atualizado = PessoaService.
        editar(id,Pessoa);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        PessoaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
