package edu.medicina.preventiva.gerenciador_veterinario.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicamentoDTO {
    
    private int codigoMed;
    private String nomeMed;
    private LocalDate validadeMinimaMed;
    private double valorMed;

}

