package br.com.duxus.service.composicaoTime;

import br.com.duxus.controller.dto.ComposicaoTimeDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.repository.ComposicaoTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizaComposicaoTimeService {

        @Autowired
        private ComposicaoTimeRepository composicaoTimeRepository;

        public ComposicaoTime executar(Long id, ComposicaoTimeDTO request) {
            var composicaoTime = composicaoTimeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Composicao de time não encontrado"));
            composicaoTime.setTime(request.getTime());
            composicaoTime.setIntegrante(request.getIntegrante());
            return composicaoTimeRepository.save(composicaoTime);
        }
}
