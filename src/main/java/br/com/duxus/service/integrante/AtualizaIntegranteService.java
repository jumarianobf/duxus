package br.com.duxus.service.integrante;

import br.com.duxus.controller.dto.IntegranteDTO;
import br.com.duxus.domain.Integrante;
import br.com.duxus.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizaIntegranteService {

        @Autowired
        private IntegranteRepository integranteRepository;

        public Integrante executar(Long id, IntegranteDTO request) {
            var integrante = integranteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Integrante não encontrado"));
            integrante.setNome(request.getNome());
            integrante.setFranquia(request.getFranquia());
            integrante.setFuncao(request.getFuncao());
            return integranteRepository.save(integrante);
        }
}
