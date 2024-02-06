package br.com.duxus.service.composicaoTime;

import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.repository.ComposicaoTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaComposicaoTimePorIdService {

        @Autowired
        private ComposicaoTimeRepository composicaoTimeRepository;

        public ComposicaoTime executar(long id) {
            return composicaoTimeRepository.findById(id).orElse(null);
        }
}