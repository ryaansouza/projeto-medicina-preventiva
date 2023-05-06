package edu.medicina.preventiva.gerenciador_veterinario.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsumoDTO {
    private int codigo;
    private String nome;
    private double valor;
    private String descricao;
}