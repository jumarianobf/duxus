package br.com.duxus.service.apiService;

import br.com.duxus.controller.dto.IntegranteNaDataDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.domain.Time;
import br.com.duxus.repository.ComposicaoTimeRepository;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TimeMaisComumService {

    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;
    @Autowired
    private ValidaDatas validaDatas;
    @Autowired
    private TimeDaDataService timeDaDataService;


    public IntegranteNaDataDTO executar(LocalDate dataInicial, LocalDate dataFinal) {

        dataInicial = validaDatas.getDataInicial(dataInicial);
        dataFinal = validaDatas.getDataFinal(dataFinal);

        List<ComposicaoTime> composicaoTimes = composicaoTimeRepository.findByTimeDataBetween(dataInicial, dataFinal);

        Map<Time, Integer> contagemTimes = new HashMap<>();
        for (ComposicaoTime composicao : composicaoTimes) {
            Time time = composicao.getTime();
            contagemTimes.put(time, contagemTimes.getOrDefault(time, 0) + 1);
        }

        Time timeMaisUsado = null;
        int contagem = 0;

        for (Map.Entry<Time, Integer> entry : contagemTimes.entrySet()) {
            if (entry.getValue() > contagem) {
                timeMaisUsado = entry.getKey();
                contagem = entry.getValue();
            }
        }
        return timeDaDataService.executar(timeMaisUsado.getData());
    }

}



