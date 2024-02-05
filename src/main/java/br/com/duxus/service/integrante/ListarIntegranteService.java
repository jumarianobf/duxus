package br.com.duxus.service.integrante;

import br.com.duxus.domain.Integrante;
import br.com.duxus.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarIntegranteService {

        @Autowired
        private IntegranteRepository integranteRepository;

        public Page<Integrante> executar(Pageable integrantePaginado) {
            return integranteRepository
                    .findAll(integrantePaginado);
        }
}