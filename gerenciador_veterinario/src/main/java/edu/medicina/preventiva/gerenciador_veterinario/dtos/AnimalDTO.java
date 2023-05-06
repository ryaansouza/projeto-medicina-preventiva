package edu.medicina.preventiva.gerenciador_veterinario.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalDTO {

    private int codigoAnimal;
    private String nomeAnimal;
    private String racaAnimal;
    private int idadeAnimal;
    private double pesoAnimal;
    private String porteAnimal;
    private String sexoAnimal;
    private String cpfDonoAnimal;
    private String infoAdicionaisAnimais;
}
