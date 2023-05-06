package edu.medicina.preventiva.gerenciador_veterinario.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.FuncionarioDTO;
import edu.medicina.preventiva.gerenciador_veterinario.exceptions.RegraNegocioException;
import edu.medicina.preventiva.gerenciador_veterinario.models.Cargo;
import edu.medicina.preventiva.gerenciador_veterinario.models.Funcionario;
import edu.medicina.preventiva.gerenciador_veterinario.services.FuncionarioService;

@RestController
@RequestMapping("/medicinapreventiva/funcionario")
public class FuncionarioController {

    FuncionarioService funcionarioService;

    FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvar(@RequestBody FuncionarioDTO funcionarioDTO){
        return funcionarioService.salvar(funcionarioDTO);
    }

    @PutMapping("/editar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@PathVariable Integer codigo, @RequestBody FuncionarioDTO funcionarioDTO){
        funcionarioService.alterar(codigo, funcionarioDTO);
    }

    @DeleteMapping("/deletar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Integer codigo){
        funcionarioService.deletar(codigo);
    }

    @GetMapping("/consultar")
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioDTO> consultar(){
        return funcionarioService.consultarTodos();
    }

    @GetMapping("/consultar/codigo/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioDTO consultarPorCodigo(@PathVariable Integer codigo){
        return funcionarioService.consultarPorCodigo(codigo);
    }

    @GetMapping("consultar/cargo/{cargo}")
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioDTO> consultarPorCargo(@PathVariable String cargo){
        System.out.println("CARGO: " + cargo.equals(Cargo.GERENTE.toString()));
        if(cargo != null){
            if (cargo.equals(Cargo.GERENTE.toString())){
                return funcionarioService.consultarPorCargo(Cargo.GERENTE);
            }
            if (cargo.equals(Cargo.ATENDENTE.toString())){
                return funcionarioService.consultarPorCargo(Cargo.ATENDENTE);
            }
            if (cargo.equals(Cargo.MEDICO.toString())){
                return funcionarioService.consultarPorCargo(Cargo.MEDICO);
            }
        }
        new RegraNegocioException("Codigo Invalido");
        return null;
    }

    @GetMapping("consultar/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioDTO> consultarPorNome(@PathVariable String nome){
        return funcionarioService.consultarPorNome(nome);
    }

    @GetMapping("consultar/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioDTO consultarPorCpf(@PathVariable String cpf){
        return funcionarioService.consultarPorCpf(cpf);
    }
}
