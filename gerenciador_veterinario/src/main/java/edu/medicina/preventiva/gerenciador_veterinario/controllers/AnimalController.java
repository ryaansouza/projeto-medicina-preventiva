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

import edu.medicina.preventiva.gerenciador_veterinario.dtos.AnimalDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Animal;
import edu.medicina.preventiva.gerenciador_veterinario.services.AnimalService;

@RestController
@RequestMapping("/medicinapreventiva/animal")
public class AnimalController {
    
    AnimalService animalService;

    AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal salvar(@RequestBody AnimalDTO animalDTO){
        return animalService.salvar(animalDTO);
    }

    @PutMapping("/editar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@PathVariable Integer codigo, @RequestBody AnimalDTO animalDTO){
        animalService.alterar(codigo, animalDTO);
    }

    @DeleteMapping("/deletar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Integer codigo){
        animalService.deletar(codigo);
    }

    @GetMapping("/consultar")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> consultar(){
        return animalService.consultarTodos();
    }

    @GetMapping("/consultar/codigo/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDTO consultarPorCodigo(@PathVariable Integer codigo){
        return animalService.consultarPorCodigo(codigo);
    }

    @GetMapping("consultar/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> consultarPorNome(@PathVariable String nome){
        return animalService.consultarPorNome(nome);
    }

    @GetMapping("consultar/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> consultarPorCpf(@PathVariable String cpf){
        return animalService.consultarPorCpfDono(cpf);
    }
}
