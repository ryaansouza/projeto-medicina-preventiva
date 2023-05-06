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
public class Cliente {
    @Id
    @GeneratedValue
    private int codigoCliente;

    @Column(length = 100, nullable = false)
    private String nomeCliente;

    @Column(length = 25, nullable = false)
    private String cpfCliente;

    @Column(length = 200)
    private String enderecoCliente;

    @Column(length = 50)
    private String cidadeCliente;

    @Column(length = 50)
    private String telefoneCliente;

    @Column(length = 100, nullable = false)
    private String emailCliente;
}
