package edu.medicina.preventiva.gerenciador_veterinario.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    private int codigoCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String enderecoCliente;
    private String cidadeCliente;
    private String telefoneCliente;
    private String emailCliente;
}
