package edu.medicina.preventiva.gerenciador_veterinario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.medicina.preventiva.gerenciador_veterinario.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

    List<Funcionario> findByNomeFuncionario(String nomeFuncionario);

    List<Funcionario> findByNomeFuncionarioContaining(String nomeFuncionario);

    List<Funcionario> findByCargo(String cargo);

    Funcionario findByCpfFuncionario(String cpfFuncionario);
}
