package com.luciene.projetoteste.ordemservico.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="tbordensservico")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdemServicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String descricao;
    @CreationTimestamp
    private LocalDateTime dataAbertura;
    @OneToOne
    @JoinColumn(name="idstatus")
    StatusEntity status;
    @ManyToOne
    ArrayList<ServicoEntity> servicos;
    Timestamp dataFechamento;
    float valorTotal;
}
