package br.com.duxus.service.integrante;

import br.com.duxus.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletaIntegranteService {

        @Autowired
        private IntegranteRepository integranteRepository;

        public void executar(long id) {
            integranteRepository.deleteById(id);
        }
}