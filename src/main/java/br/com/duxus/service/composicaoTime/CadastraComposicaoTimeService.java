package br.com.duxus.service.composicaoTime;

import br.com.duxus.controller.dto.ComposicaoTimeDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.repository.ComposicaoTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraComposicaoTimeService {

    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;

    public ComposicaoTime executar(ComposicaoTimeDTO request) {
        return composicaoTimeRepository.save(getComposicaoTime(request));
    }

    private ComposicaoTime getComposicaoTime(ComposicaoTimeDTO request) {
        return ComposicaoTime
                .builder()
                .integrante(request.getIntegrante())
                .time(request.getTime())
                .build();
    }
}
