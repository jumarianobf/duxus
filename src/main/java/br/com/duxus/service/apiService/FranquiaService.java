package br.com.duxus.service.apiService;

import br.com.duxus.controller.dto.FranquiaDTO;
import br.com.duxus.controller.dto.FranquiasDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.repository.ComposicaoTimeRepository;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FranquiaService {

    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;
    @Autowired
    private ValidaDatas validaDatas;

    public FranquiaDTO getFranquiaoMaisComum(LocalDate dataInicial, LocalDate dataFinal) {
        List<ComposicaoTime> composicaoDeTimes = getComposicaoDeTimes(dataInicial, dataFinal);
        Map<String, Integer> franquiaMap = getFranquiaMap(composicaoDeTimes);

        String franquia = null;
        int contagem = 0;

        for (Map.Entry<String, Integer> entry : franquiaMap.entrySet()) {
            if (entry.getValue() > contagem) {
                franquia= entry.getKey();
                contagem = entry.getValue();
            }
        }
        return FranquiaDTO
                .builder()
                .franquia(franquia)
                .build();
    }

    public FranquiasDTO getContagemFranquia(LocalDate dataInicial, LocalDate dataFinal) {
        List<ComposicaoTime> composicaoDeTimes = getComposicaoDeTimes(dataInicial, dataFinal);
        Map<String, Integer> franquiaMap = getFranquiaMap(composicaoDeTimes);

        List<FranquiaDTO> franquias = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : franquiaMap.entrySet()) {
            FranquiaDTO franquia = FranquiaDTO
                    .builder()
                    .franquia(entry.getKey())
                    .contagem(entry.getValue())
                    .build();
            franquias.add(franquia);
        }
        return FranquiasDTO
                .builder()
                .franquias(franquias)
                .build();
    }


    private Map<String, Integer> getFranquiaMap(List<ComposicaoTime> composicaoDeTimes) {
        Map<String, Integer> franquiaMap = new HashMap<>();
        for (ComposicaoTime composicao : composicaoDeTimes) {
            String franquia = composicao.getIntegrante().getFranquia();
            franquiaMap.put(franquia, franquiaMap.getOrDefault(franquia, 0) + 1);
        }
        return franquiaMap;
    }


    private List<ComposicaoTime> getComposicaoDeTimes(LocalDate dataInicial, LocalDate dataFinal) {
        dataInicial = validaDatas.getDataInicial(dataInicial);
        dataFinal = validaDatas.getDataFinal(dataFinal);
        return composicaoTimeRepository.findByTimeDataBetween(dataInicial, dataFinal);
    }
}



