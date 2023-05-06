package edu.medicina.preventiva.gerenciador_veterinario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.medicina.preventiva.gerenciador_veterinario.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    
    List<Animal> findByNomeAnimal(String nomeAnimal);

    List<Animal> findByNomeAnimalContaining(String nomeAnimal);

    List<Animal> findByCpfDonoAnimal(String cpfDonoAnimal);

}
