package edu.medicina.preventiva.gerenciador_veterinario.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuncionarioDTO {
    private int codigoFuncionario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String senhaFuncionario;
    private String enderecoFuncionario;
    private String cidadeFuncionario;
    private String telefoneFuncionario;
    private String emailFuncionario;
    private String cargo;
}
