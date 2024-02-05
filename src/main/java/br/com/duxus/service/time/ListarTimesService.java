package br.com.duxus.service.time;

import br.com.duxus.domain.Time;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarTimesService {

        @Autowired
        private TimeRepository timeRepository;

        public Page<Time> executar(Pageable timePaginado) {
            return timeRepository
                    .findAll(timePaginado);
        }
}