package br.com.duxus.service.composicaoTime;

import br.com.duxus.controller.dto.ComposicaoTimeDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.domain.Integrante;
import br.com.duxus.domain.Time;
import br.com.duxus.repository.ComposicaoTimeRepository;
import br.com.duxus.repository.IntegranteRepository;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraComposicaoTimeService {

    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    @Autowired
    private TimeRepository timeRepository;


    public ComposicaoTime executar(ComposicaoTimeDTO request) {
        Integrante integrante = integranteRepository.findById(request.getIdIntegrante()).orElseThrow(() -> new RuntimeException("Integrante não encontrado"));
        Time time = timeRepository.findById(request.getIdTime()).orElseThrow(() -> new RuntimeException("Time não encontrado"));
        return composicaoTimeRepository.save(getComposicaoTime(integrante, time));
    }


    private ComposicaoTime getComposicaoTime(Integrante integrante, Time time) {
        return ComposicaoTime
                .builder()
                .integrante(integrante)
                .time(time)
                .build();
    }
}
