package edu.medicina.preventiva.gerenciador_veterinario.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    
    @Id
    @GeneratedValue
    private int codigoFuncionario;

    @Column(length = 100, nullable = false)
    private String nomeFuncionario;

    @Column(length = 25, nullable = false)
    private String cpfFuncionario;

    @Column(length = 20, nullable = false)
    private String senhaFuncionario;
    
    @Column(length = 200)
    private String enderecoFuncionario;
    
    @Column(length = 50)
    private String cidadeFuncionario;
    
    @Column(length = 50)
    private String telefoneFuncionario;
    
    @Column(length = 100, nullable = false)
    private String emailFuncionario;
    
    @Column(length = 20, nullable = false)
    private String cargo;

}
