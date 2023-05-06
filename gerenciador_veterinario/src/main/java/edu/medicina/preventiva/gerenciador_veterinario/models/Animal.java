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
public class Animal {
    
    @Id
    @GeneratedValue
    private int codigoAnimal;

    @Column(length = 100, nullable = false)
    private String nomeAnimal;

    @Column(length = 100)
    private String racaAnimal;

    @Column(nullable = false)
    private int idadeAnimal;

    @Column()
    private double pesoAnimal;

    @Column(length = 20)
    private String porteAnimal;

    @Column(length = 10, nullable = false)
    private String sexoAnimal;

    @Column(length = 30, nullable = false)
    private String cpfDonoAnimal;

    @Column(length = 300)
    private String infoAdicionaisAnimais;
}