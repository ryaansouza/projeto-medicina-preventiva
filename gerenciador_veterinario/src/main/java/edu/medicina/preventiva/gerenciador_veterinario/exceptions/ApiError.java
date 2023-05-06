package edu.medicina.preventiva.gerenciador_veterinario.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiError {
    
    private List<String> errors;

    public ApiError(String mensagemErro){
        errors = Arrays.asList(mensagemErro);
    }
}

