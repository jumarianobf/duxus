package br.com.duxus.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TimeDTO {


    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;
}
