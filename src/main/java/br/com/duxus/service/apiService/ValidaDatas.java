package br.com.duxus.service.apiService;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class ValidaDatas {

    public LocalDate getDataInicial(LocalDate dataInicial) {
        if(dataInicial == null){
            return LocalDate.of(2024, 01, 01);
        }
        return dataInicial;
    }

    public LocalDate getDataFinal(LocalDate dataFinal) {
        if(dataFinal == null){
            return LocalDate.now();
        }
        return dataFinal;
    }
}



