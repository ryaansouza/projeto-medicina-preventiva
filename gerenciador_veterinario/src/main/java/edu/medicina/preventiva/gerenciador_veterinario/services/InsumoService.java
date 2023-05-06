package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.util.List;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.InsumoDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Insumo;

public interface InsumoService {

    Insumo salvar(InsumoDTO insumoDTO);

    void alterar(Integer id, InsumoDTO insumoDTO);

    void deletar(int codigo);

    List<InsumoDTO> consultarTodos();

    InsumoDTO consultarPorCodigo(Integer codigo);

    List<InsumoDTO> consultarPorNome(String nome);
}
