package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.util.List;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.FuncionarioDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Cargo;
import edu.medicina.preventiva.gerenciador_veterinario.models.Funcionario;

public interface FuncionarioService {
    
    Funcionario salvar(FuncionarioDTO funcionarioDTO);

    void alterar(Integer id, FuncionarioDTO funcionarioDTO);

    void deletar(int codigoFuncionario);

    List<FuncionarioDTO> consultarTodos();

    FuncionarioDTO consultarPorCodigo(Integer codigo);

    List<FuncionarioDTO> consultarPorCargo(Cargo cargo);
    
    List<FuncionarioDTO> consultarPorNome(String nome);

    FuncionarioDTO consultarPorCpf(String cpf);
    
}
