package com.luciene.projetoteste.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luciene.projetoteste.ordemservico.entities.OrdemServicoEntity;
import com.luciene.projetoteste.ordemservico.repositories.OrdemServicoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdemServicoService {
    private final OrdemServicoRepository OrdemServicoRepository;
     public OrdemServicoEntity incluir(OrdemServicoEntity OrdemServico) {

        return OrdemServicoRepository.save(OrdemServico);
    }
    public OrdemServicoEntity editar(int id, OrdemServicoEntity OrdemServico) {
        // Verifique se a OrdemServico existe
        Optional<OrdemServicoEntity> OrdemServicoExistente = 
        OrdemServicoRepository.findById(id);
        
        if (OrdemServicoExistente.isPresent()) {
            // Atualiza a OrdemServico
            OrdemServicoEntity OrdemServicoAtualizada = OrdemServicoExistente.get();
            OrdemServicoAtualizada.setDescricao(OrdemServico.getDescricao());  // Atualiza os campos necessários
            //askdfkljsdajfkl
            //asdfsdaf
            /// colocar demais campos
            return OrdemServicoRepository.save(OrdemServicoAtualizada);  // Salva a OrdemServico atualizada
        } else {
            // Caso a OrdemServico não exista, retorna null
            return null;
        }
    }
    public List<OrdemServicoEntity> listarTodos() {
        return OrdemServicoRepository.findAll();
    }
    public void excluir(Integer id) {
        OrdemServicoRepository.deleteById(id);
}
}
