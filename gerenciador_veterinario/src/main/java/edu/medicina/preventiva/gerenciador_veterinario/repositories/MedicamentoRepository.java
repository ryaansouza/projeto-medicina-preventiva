package edu.medicina.preventiva.gerenciador_veterinario.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.medicina.preventiva.gerenciador_veterinario.models.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
    
    List<Medicamento> findByNomeMed(String nomeMed);

    List<Medicamento> findByNomeMedContaining(String nomeMed);

    List<Medicamento> findByValidadeMinimaMed(LocalDate validadeMinimaMed);
}
