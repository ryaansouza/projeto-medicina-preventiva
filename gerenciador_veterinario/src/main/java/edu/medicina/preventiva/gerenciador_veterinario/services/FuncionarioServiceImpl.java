package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.FuncionarioDTO;
import edu.medicina.preventiva.gerenciador_veterinario.exceptions.RegraNegocioException;
import edu.medicina.preventiva.gerenciador_veterinario.models.Cargo;
import edu.medicina.preventiva.gerenciador_veterinario.models.Funcionario;
import edu.medicina.preventiva.gerenciador_veterinario.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public Funcionario salvar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
        funcionario.setCpfFuncionario(funcionarioDTO.getCpfFuncionario());
        funcionario.setSenhaFuncionario(funcionarioDTO.getSenhaFuncionario());
        funcionario.setEnderecoFuncionario(funcionarioDTO.getEnderecoFuncionario());
        funcionario.setCidadeFuncionario(funcionarioDTO.getCidadeFuncionario());
        funcionario.setTelefoneFuncionario(funcionarioDTO.getTelefoneFuncionario());
        funcionario.setEmailFuncionario(funcionarioDTO.getEmailFuncionario());
        funcionario.setCargo(funcionarioDTO.getCargo());

        return funcionarioRepository.save(funcionario);
    }

    @Override
    @Transactional
    public void alterar(Integer id, FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() ->
                                    new RegraNegocioException("Funcionario nao encontrado!"));

        funcionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
        funcionario.setCpfFuncionario(funcionarioDTO.getCpfFuncionario());
        funcionario.setSenhaFuncionario(funcionarioDTO.getSenhaFuncionario());
        funcionario.setEnderecoFuncionario(funcionarioDTO.getEnderecoFuncionario());
        funcionario.setCidadeFuncionario(funcionarioDTO.getCidadeFuncionario());
        funcionario.setTelefoneFuncionario(funcionarioDTO.getTelefoneFuncionario());
        funcionario.setEmailFuncionario(funcionarioDTO.getEmailFuncionario());
        funcionario.setCargo(funcionarioDTO.getCargo());
    }

    @Override
    @Transactional
    public void deletar(int codigoFuncionario) {
        funcionarioRepository.deleteById(codigoFuncionario);
    }

    //Estanciar FuncionarioDTO dentro do for?
    @Override
    public List<FuncionarioDTO> consultarTodos() {
        List<FuncionarioDTO> funcionariosDTOs= new ArrayList<FuncionarioDTO>();
        for (Funcionario funcionario : funcionarioRepository.findAll()) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            funcionarioDTO.setCodigoFuncionario(funcionario.getCodigoFuncionario());
            funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
            funcionarioDTO.setCpfFuncionario(funcionario.getCpfFuncionario());
            funcionarioDTO.setSenhaFuncionario(funcionario.getSenhaFuncionario());
            funcionarioDTO.setEnderecoFuncionario(funcionario.getEnderecoFuncionario());
            funcionarioDTO.setCidadeFuncionario(funcionario.getCidadeFuncionario());
            funcionarioDTO.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
            funcionarioDTO.setEmailFuncionario(funcionario.getEmailFuncionario());
            funcionarioDTO.setCargo(funcionario.getCargo());
            funcionariosDTOs.add(funcionarioDTO);
        }
        return funcionariosDTOs;
    }

    @Override
    public FuncionarioDTO consultarPorCodigo(Integer codigo) {
        Funcionario funcionario = funcionarioRepository.findById(codigo).orElseThrow(() ->
                                    new RegraNegocioException("Funcionario nao encontrado!"));
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setCodigoFuncionario(funcionario.getCodigoFuncionario());
        funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioDTO.setCpfFuncionario(funcionario.getCpfFuncionario());
        funcionarioDTO.setSenhaFuncionario(funcionario.getSenhaFuncionario());
        funcionarioDTO.setEnderecoFuncionario(funcionario.getEnderecoFuncionario());
        funcionarioDTO.setCidadeFuncionario(funcionario.getCidadeFuncionario());
        funcionarioDTO.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
        funcionarioDTO.setEmailFuncionario(funcionario.getEmailFuncionario());
        funcionarioDTO.setCargo(funcionario.getCargo());
        return funcionarioDTO;
    }

    @Override
    public List<FuncionarioDTO> consultarPorCargo(Cargo cargo) {

        List<FuncionarioDTO> funcionariosDTOs= new ArrayList<FuncionarioDTO>();
        System.out.println("CARGO: " + cargo.toString() + "\n\n\n\n");
        for (Funcionario funcionario : funcionarioRepository.findByCargo(cargo.toString())) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

            funcionarioDTO.setCodigoFuncionario(funcionario.getCodigoFuncionario());
            funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
            funcionarioDTO.setCpfFuncionario(funcionario.getCpfFuncionario());
            funcionarioDTO.setSenhaFuncionario(funcionario.getSenhaFuncionario());
            funcionarioDTO.setEnderecoFuncionario(funcionario.getEnderecoFuncionario());
            funcionarioDTO.setCidadeFuncionario(funcionario.getCidadeFuncionario());
            funcionarioDTO.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
            funcionarioDTO.setEmailFuncionario(funcionario.getEmailFuncionario());
            funcionarioDTO.setCargo(funcionario.getCargo());
            funcionariosDTOs.add(funcionarioDTO);
        }
        return funcionariosDTOs;
    }

    @Override
    public List<FuncionarioDTO> consultarPorNome(String nome) {
        List<FuncionarioDTO> funcionariosDTOs= new ArrayList<FuncionarioDTO>();
        for (Funcionario funcionario : funcionarioRepository.findByNomeFuncionarioContaining(nome)) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            funcionarioDTO.setCodigoFuncionario(funcionario.getCodigoFuncionario());
            funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
            funcionarioDTO.setCpfFuncionario(funcionario.getCpfFuncionario());
            funcionarioDTO.setSenhaFuncionario(funcionario.getSenhaFuncionario());
            funcionarioDTO.setEnderecoFuncionario(funcionario.getEnderecoFuncionario());
            funcionarioDTO.setCidadeFuncionario(funcionario.getCidadeFuncionario());
            funcionarioDTO.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
            funcionarioDTO.setEmailFuncionario(funcionario.getEmailFuncionario());
            funcionarioDTO.setCargo(funcionario.getCargo());
            funcionariosDTOs.add(funcionarioDTO);
        }
        return funcionariosDTOs;
    }

    @Override
    public FuncionarioDTO consultarPorCpf(String cpf) {
        Funcionario funcionario = funcionarioRepository.findByCpfFuncionario(cpf);
        
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setCodigoFuncionario(funcionario.getCodigoFuncionario());
        funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioDTO.setCpfFuncionario(funcionario.getCpfFuncionario());
        funcionarioDTO.setSenhaFuncionario(funcionario.getSenhaFuncionario());
        funcionarioDTO.setEnderecoFuncionario(funcionario.getEnderecoFuncionario());
        funcionarioDTO.setCidadeFuncionario(funcionario.getCidadeFuncionario());
        funcionarioDTO.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
        funcionarioDTO.setEmailFuncionario(funcionario.getEmailFuncionario());
        funcionarioDTO.setCargo(funcionario.getCargo());
        return funcionarioDTO;
    }
    
}
