package edu.medicina.preventiva.gerenciador_veterinario.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.MedicamentoDTO;
import edu.medicina.preventiva.gerenciador_veterinario.models.Medicamento;
import edu.medicina.preventiva.gerenciador_veterinario.services.MedicamentoService;

@RestController
@RequestMapping("/medicinapreventiva/medicamento")
public class MedicamentoController {
    
    MedicamentoService medicamentoService;

    MedicamentoController(MedicamentoService medicamentoService){
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Medicamento salvar(@RequestBody MedicamentoDTO medicamentoDTO){
        return medicamentoService.salvar(medicamentoDTO);
    }

    @PutMapping("/editar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@PathVariable Integer codigo, @RequestBody MedicamentoDTO medicamentoDTO){
        medicamentoService.alterar(codigo, medicamentoDTO);
    }

    @DeleteMapping("/deletar/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Integer codigo){
        medicamentoService.deletar(codigo);
    }

    @GetMapping("/consultar")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicamentoDTO> consultar(){
        return medicamentoService.consultarTodos();
    }

    @GetMapping("/consultar/codigo/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public MedicamentoDTO consultarPorCodigo(@PathVariable Integer codigo){
        return medicamentoService.consultarPorCodigo(codigo);
    }

    @GetMapping("consultar/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicamentoDTO> consultarPorNome(@PathVariable String nome){
        return medicamentoService.consultarPorNome(nome);
    }

    @GetMapping("consultar/datavalidade")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicamentoDTO> consultarPorDataValidade(@RequestParam LocalDate dataValidade){
        return medicamentoService.consultarPorDataValidade(dataValidade);
    }
}
