package br.com.duxus.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TimeDTO {
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate data;
}
