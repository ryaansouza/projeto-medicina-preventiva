package edu.medicina.preventiva.gerenciador_veterinario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.medicina.preventiva.gerenciador_veterinario.models.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Integer>{

    List<Insumo> findByNome(String nome);

    List<Insumo> findByNomeContaining(String nome);

}
