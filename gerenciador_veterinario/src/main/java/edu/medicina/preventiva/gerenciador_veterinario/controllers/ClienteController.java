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

import edu.medicina.preventiva.gerenciador_veterinario.dtos.ClienteDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Cliente;
import edu.medicina.preventiva.gerenciador_veterinario.services.ClienteService;

@RestController
@RequestMapping("/medicinapreventiva/cliente")
public class ClienteController {
    
    ClienteService clienteService;

    ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody ClienteDTO clinteDTO){
        return clienteService.salvar(clinteDTO);
    }

    @PutMapping("/editar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@PathVariable Integer codigo, @RequestBody ClienteDTO clinteDTO){
        clienteService.alterar(codigo, clinteDTO);
    }

    @DeleteMapping("/deletar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Integer codigo){
        clienteService.deletar(codigo);
    }

    @GetMapping("/consultar")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> consultar(){
        return clienteService.consultarTodos();
    }

    @GetMapping("/consultar/codigo/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDTO consultarPorCodigo(@PathVariable Integer codigo){
        return clienteService.consultarPorCodigo(codigo);
    }

    @GetMapping("consultar/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> consultarPorNome(@PathVariable String nome){
        return clienteService.consultarPorNome(nome);
    }

    @GetMapping("consultar/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDTO consultarPorCpf(@PathVariable String cpf){
        return clienteService.consultarPorCpf(cpf);
    }

}
