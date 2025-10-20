package com.luciene.projetoteste.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luciene.projetoteste.ordemservico.entities.PessoaEntity;
import com.luciene.projetoteste.ordemservico.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository PessoaRepository;
     public PessoaEntity incluir(PessoaEntity Pessoa) {

        return PessoaRepository.save(Pessoa);
    }
    public PessoaEntity editar(int id, PessoaEntity Pessoa) {
        // Verifique se a Pessoa existe
        Optional<PessoaEntity> PessoaExistente = 
        PessoaRepository.findById(id);
        
        if (PessoaExistente.isPresent()) {
            // Atualiza a Pessoa
            PessoaEntity PessoaAtualizada = PessoaExistente.get();
            PessoaAtualizada.setNome(Pessoa.getNome());  // Atualiza os campos necessários
            PessoaAtualizada.setEmail(Pessoa.getEmail());
            PessoaAtualizada.setTelefone(Pessoa.getTelefone());
            return PessoaRepository.save(PessoaAtualizada);  // Salva a Pessoa atualizada
        } else {
            // Caso a Pessoa não exista, retorna null
            return null;
        }
    }
    public List<PessoaEntity> listarTodos() {
        return PessoaRepository.findAll();
    }
    public void excluir(Integer id) {
        PessoaRepository.deleteById(id);
}
}
