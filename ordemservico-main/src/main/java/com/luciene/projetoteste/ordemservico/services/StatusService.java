package com.luciene.projetoteste.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luciene.projetoteste.ordemservico.entities.StatusEntity;
import com.luciene.projetoteste.ordemservico.repositories.StatusRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository StatusRepository;
     public StatusEntity incluir(StatusEntity Status) {

        return StatusRepository.save(Status);
    }
    public StatusEntity editar(int id, StatusEntity Status) {
        // Verifique se a Status existe
        Optional<StatusEntity> StatusExistente = 
        StatusRepository.findById(id);
        
        if (StatusExistente.isPresent()) {
            // Atualiza a Status
            StatusEntity StatusAtualizada = StatusExistente.get();
            StatusAtualizada.setDescricao(Status.getDescricao());  // Atualiza os campos necessários
            return StatusRepository.save(StatusAtualizada);  // Salva a Status atualizada
        } else {
            // Caso a Status não exista, retorna null
            return null;
        }
    }
    public List<StatusEntity> listarTodos() {
        return StatusRepository.findAll();
    }
    public void excluir(Integer id) {
        StatusRepository.deleteById(id);
}
}
