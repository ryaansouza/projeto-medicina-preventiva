package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.ClienteDTO;
import edu.medicina.preventiva.gerenciador_veterinario.exceptions.RegraNegocioException;
import edu.medicina.preventiva.gerenciador_veterinario.models.Cliente;
import edu.medicina.preventiva.gerenciador_veterinario.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente salvar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(clienteDTO.getNomeCliente());
        cliente.setCpfCliente(clienteDTO.getCpfCliente());
        cliente.setEnderecoCliente(clienteDTO.getEnderecoCliente());
        cliente.setCidadeCliente(clienteDTO.getCidadeCliente());
        cliente.setTelefoneCliente(clienteDTO.getTelefoneCliente());
        cliente.setEmailCliente(clienteDTO.getEmailCliente());

        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void alterar(Integer id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() ->
                                    new RegraNegocioException("Cliente nao encontrado!"));

            cliente.setNomeCliente(clienteDTO.getNomeCliente());
            cliente.setCpfCliente(clienteDTO.getCpfCliente());
            cliente.setEnderecoCliente(clienteDTO.getEnderecoCliente());
            cliente.setCidadeCliente(clienteDTO.getCidadeCliente());
            cliente.setTelefoneCliente(clienteDTO.getTelefoneCliente());
            cliente.setEmailCliente(clienteDTO.getEmailCliente());
    }

    @Override
    @Transactional
    public void deletar(int codigoCliente) {
        clienteRepository.deleteById(codigoCliente);
    }

    @Override
    public List<ClienteDTO> consultarTodos() {
        List<ClienteDTO> clienteDTOs= new ArrayList<ClienteDTO>();
        for (Cliente cliente : clienteRepository.findAll()) {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setCodigoCliente(cliente.getCodigoCliente());
            clienteDTO.setNomeCliente(cliente.getNomeCliente());
            clienteDTO.setCpfCliente(cliente.getCpfCliente());
            clienteDTO.setEnderecoCliente(cliente.getEnderecoCliente());
            clienteDTO.setCidadeCliente(cliente.getCidadeCliente());
            clienteDTO.setTelefoneCliente(cliente.getTelefoneCliente());
            clienteDTO.setEmailCliente(cliente.getEmailCliente());
            clienteDTOs.add(clienteDTO);
        }
        return clienteDTOs;
    }

    @Override
    public ClienteDTO consultarPorCodigo(Integer codigo) {
        Cliente cliente = clienteRepository.findById(codigo).orElseThrow(() ->
                                    new RegraNegocioException("Cliente nao encontrado!"));
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCodigoCliente(cliente.getCodigoCliente());
        clienteDTO.setNomeCliente(cliente.getNomeCliente());
        clienteDTO.setCpfCliente(cliente.getCpfCliente());
        clienteDTO.setEnderecoCliente(cliente.getEnderecoCliente());
        clienteDTO.setCidadeCliente(cliente.getCidadeCliente());
        clienteDTO.setTelefoneCliente(cliente.getTelefoneCliente());
        clienteDTO.setEmailCliente(cliente.getEmailCliente());
        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> consultarPorNome(String nome) {
        List<ClienteDTO> clienteDTOs= new ArrayList<ClienteDTO>();
        for (Cliente cliente : clienteRepository.findByNomeClienteContaining(nome)) {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setCodigoCliente(cliente.getCodigoCliente());
            clienteDTO.setNomeCliente(cliente.getNomeCliente());
            clienteDTO.setCpfCliente(cliente.getCpfCliente());
            clienteDTO.setEnderecoCliente(cliente.getEnderecoCliente());
            clienteDTO.setCidadeCliente(cliente.getCidadeCliente());
            clienteDTO.setTelefoneCliente(cliente.getTelefoneCliente());
            clienteDTO.setEmailCliente(cliente.getEmailCliente());
            clienteDTOs.add(clienteDTO);
        }
        return clienteDTOs;
    }

    @Override
    public ClienteDTO consultarPorCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpfCliente(cpf);
        
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCodigoCliente(cliente.getCodigoCliente());
        clienteDTO.setNomeCliente(cliente.getNomeCliente());
        clienteDTO.setCpfCliente(cliente.getCpfCliente());
        clienteDTO.setEnderecoCliente(cliente.getEnderecoCliente());
        clienteDTO.setCidadeCliente(cliente.getCidadeCliente());
        clienteDTO.setTelefoneCliente(cliente.getTelefoneCliente());
        clienteDTO.setEmailCliente(cliente.getEmailCliente());
        return clienteDTO;
    }
    
}
