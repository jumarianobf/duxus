package br.com.duxus.service.apiService;

import br.com.duxus.controller.dto.IntegranteMaisUsadoDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.domain.Integrante;
import br.com.duxus.repository.ComposicaoTimeRepository;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class IntegrantesMaisUsadoService {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;

    @Autowired
    private ValidaDatas validaDatas;

    public IntegranteMaisUsadoDTO executar(LocalDate dataInicial, LocalDate dataFinal) {

        dataInicial = validaDatas.getDataInicial(dataInicial);
        dataFinal = validaDatas.getDataFinal(dataFinal);

        List<ComposicaoTime> composicaoTimes = composicaoTimeRepository.findByTimeDataBetween(dataInicial, dataFinal);
        Map<Integrante, Integer> contagemIntegrantes = new HashMap<>();
        for (ComposicaoTime composicao : composicaoTimes) {
            Integrante integrante = composicao.getIntegrante();
            contagemIntegrantes.put(integrante, contagemIntegrantes.getOrDefault(integrante, 0) + 1);
        }

        Integrante integranteMaisUsado = null;
        int contagem = 0;

        for (Map.Entry<Integrante, Integer> entry : contagemIntegrantes.entrySet()) {
            if (entry.getValue() > contagem) {
                integranteMaisUsado = entry.getKey();
                contagem = entry.getValue();
            }
        }
        IntegranteMaisUsadoDTO integranteDto = new IntegranteMaisUsadoDTO();
        if (integranteMaisUsado != null) {
            integranteDto.setIntegrante(integranteMaisUsado.getNome());
        }
        return integranteDto;
    }

}



