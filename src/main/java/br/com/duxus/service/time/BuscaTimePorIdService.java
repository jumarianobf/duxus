package br.com.duxus.service.time;

import br.com.duxus.domain.Time;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaTimePorIdService {

        @Autowired
        private TimeRepository timeRepository;

        public Time executar(long id) {
            return timeRepository.findById(id).orElse(null);
        }
}
