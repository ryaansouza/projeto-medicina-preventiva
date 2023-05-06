package edu.medicina.preventiva.gerenciador_veterinario.models;

import java.time.LocalDate;

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
public class Medicamento {
    
    @Id
    @GeneratedValue
    private int codigoMed;

    @Column(length = 100, nullable = false)
    private String nomeMed;

    @Column(nullable = false)
    private LocalDate validadeMinimaMed;

    @Column(nullable = false)
    private double valorMed;

}
