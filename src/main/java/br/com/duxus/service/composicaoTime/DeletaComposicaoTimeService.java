package br.com.duxus.service.composicaoTime;

import br.com.duxus.repository.ComposicaoTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletaComposicaoTimeService {

        @Autowired
        private ComposicaoTimeRepository composicaoTimeRepository;

        public void executar(long id) {
            composicaoTimeRepository.deleteById(id);
        }
}
