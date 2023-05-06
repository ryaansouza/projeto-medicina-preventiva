package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.time.LocalDate;
import java.util.List;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.MedicamentoDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Medicamento;

public interface MedicamentoService {
    
    Medicamento salvar(MedicamentoDTO medicamentoDTO);

    void alterar(Integer id, MedicamentoDTO medicamentoDTO);

    void deletar(int codigo);

    List<MedicamentoDTO> consultarTodos();

    MedicamentoDTO consultarPorCodigo(Integer codigo);

    List<MedicamentoDTO> consultarPorNome(String nome);

    List<MedicamentoDTO> consultarPorDataValidade(LocalDate dataValidade);
}
