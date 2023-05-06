package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.util.List;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.ClienteDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Cliente;

public interface ClienteService {

    Cliente salvar(ClienteDTO clienteDTO);

    void alterar(Integer id, ClienteDTO clienteDTO);

    void deletar(int codigoCliente);

    List<ClienteDTO> consultarTodos();

    ClienteDTO consultarPorCodigo(Integer codigoCliente);

    List<ClienteDTO> consultarPorNome(String nomeCliente);

    ClienteDTO consultarPorCpf(String cpfCliente);

}