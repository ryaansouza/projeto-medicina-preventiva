package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.util.List;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.AnimalDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Animal;

public interface AnimalService {
    
    Animal salvar(AnimalDTO animalDTO);

    void alterar(Integer id, AnimalDTO animalDTO);

    void deletar(int codigoAnimal);

    List<AnimalDTO> consultarTodos();

    AnimalDTO consultarPorCodigo(Integer codigoAnimal);

    List<AnimalDTO> consultarPorNome(String nomeAnimal);

    List<AnimalDTO> consultarPorCpfDono(String cpfDonoAnimal);

}
