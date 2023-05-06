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

import edu.medicina.preventiva.gerenciador_veterinario.dtos.InsumoDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Insumo;
import edu.medicina.preventiva.gerenciador_veterinario.services.InsumoService;

@RestController
@RequestMapping("/medicinapreventiva/insumo")
public class InsumoController {

    InsumoService insumoService;

    InsumoController(InsumoService insumoService){
        this.insumoService = insumoService;
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Insumo salvar(@RequestBody InsumoDTO insumoDTO){
        return insumoService.salvar(insumoDTO);
    }

    @PutMapping("/editar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@PathVariable Integer codigo, @RequestBody InsumoDTO insumoDTO){
        insumoService.alterar(codigo, insumoDTO);
    }

    @DeleteMapping("/deletar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Integer codigo){
        insumoService.deletar(codigo);
    }

    @GetMapping("/consultar")
    @ResponseStatus(HttpStatus.OK)
    public List<InsumoDTO> consultar(){
        return insumoService.consultarTodos();
    }

    @GetMapping("/consultar/codigo/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public InsumoDTO consultarPorCodigo(@PathVariable Integer codigo){
        return insumoService.consultarPorCodigo(codigo);
    }

    @GetMapping("consultar/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<InsumoDTO> consultarPorNome(@PathVariable String nome){
        return insumoService.consultarPorNome(nome);
    }

}
