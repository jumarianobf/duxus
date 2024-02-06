package br.com.duxus.controller.dto;

import br.com.duxus.domain.Integrante;
import br.com.duxus.domain.Time;
import lombok.Data;

@Data
public class ComposicaoTimeDTO {

    private Time time;

    private Integrante integrante;

    }

