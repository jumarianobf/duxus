package br.com.duxus.service.composicaoTime;

import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.repository.ComposicaoTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarComposicaoTimeService {

        @Autowired
        private ComposicaoTimeRepository composicaoTimeRepository;

        public Page<ComposicaoTime> executar(Pageable composicaoTimePaginado) {
            return composicaoTimeRepository
                    .findAll(composicaoTimePaginado);
        }
}
