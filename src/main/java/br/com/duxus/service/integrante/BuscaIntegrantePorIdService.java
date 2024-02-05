package br.com.duxus.service.integrante;

import br.com.duxus.domain.Integrante;
import br.com.duxus.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaIntegrantePorIdService {

        @Autowired
        private IntegranteRepository integranteRepository;

        public Integrante executar(long id) {
            return integranteRepository.findById(id).orElse(null);
        }
}