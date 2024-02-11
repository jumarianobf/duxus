package br.com.duxus.service.apiService;

import br.com.duxus.controller.dto.IntegranteNaDataDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.repository.ComposicaoTimeRepository;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeDaDataService {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;


    public IntegranteNaDataDTO executar(LocalDate data) {
        List<ComposicaoTime> composicaoTimes = composicaoTimeRepository.findByTimeData(data);
        List<String> integrantesNomes = new ArrayList<>();
        for (ComposicaoTime composicao : composicaoTimes) {
            integrantesNomes.add(composicao.getIntegrante().getNome());
        }
        return IntegranteNaDataDTO
                .builder()
                .integrantes(integrantesNomes)
                .build();
    }
}
