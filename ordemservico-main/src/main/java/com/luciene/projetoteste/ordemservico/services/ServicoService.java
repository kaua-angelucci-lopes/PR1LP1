package com.luciene.projetoteste.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luciene.projetoteste.ordemservico.entities.ServicoEntity;
import com.luciene.projetoteste.ordemservico.repositories.ServicoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoService {
    private final ServicoRepository ServicoRepository;
     public ServicoEntity incluir(ServicoEntity Servico) {

        return ServicoRepository.save(Servico);
    }
    public ServicoEntity editar(int id, ServicoEntity Servico) {
        // Verifique se a Servico existe
        Optional<ServicoEntity> ServicoExistente = 
        ServicoRepository.findById(id);
        
        if (ServicoExistente.isPresent()) {
            // Atualiza a Servico
            ServicoEntity ServicoAtualizada = ServicoExistente.get();
            ServicoAtualizada.setDescricao(Servico.getDescricao());  // Atualiza os campos necessários
            ServicoAtualizada.setValor(Servico.getValor());
            return ServicoRepository.save(ServicoAtualizada);  // Salva a Servico atualizada
        } else {
            // Caso a Servico não exista, retorna null
            return null;
        }
    }
    public List<ServicoEntity> listarTodos() {
        return ServicoRepository.findAll();
    }
    public void excluir(Integer id) {
        ServicoRepository.deleteById(id);
}
}
