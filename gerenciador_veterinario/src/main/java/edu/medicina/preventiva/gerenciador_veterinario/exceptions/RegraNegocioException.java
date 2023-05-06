package edu.medicina.preventiva.gerenciador_veterinario.exceptions;

public class RegraNegocioException extends RuntimeException {
    public RegraNegocioException(String mensagemErro) {
        super(mensagemErro);
    }
}
