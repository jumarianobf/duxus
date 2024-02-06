package br.com.duxus.service.integrante;

import br.com.duxus.controller.dto.IntegranteDTO;
import br.com.duxus.domain.Integrante;
import br.com.duxus.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraIntegranteService {

    @Autowired
    private IntegranteRepository integranteRepository;

    public Integrante executar(IntegranteDTO request) {
        return integranteRepository.save(getIntegrante(request));
    }

    private Integrante getIntegrante(IntegranteDTO request) {
        return Integrante
                .builder()
                .nome(request.getNome())
                .franquia(request.getFranquia())
                .funcao(request.getFuncao())
                .build();
    }
}



