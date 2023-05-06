package edu.medicina.preventiva.gerenciador_veterinario.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insumo {

    @Id
    @GeneratedValue
    private int codigo;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private double valor;

    @Column(length = 200, nullable = false)
    private String descricao;

}
