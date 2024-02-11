package br.com.duxus.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class IntegranteDTO {
    @NotEmpty
    private String franquia;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String funcao;
}
