package br.com.duxus.service.time;

import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletaTimeService {

        @Autowired
        private TimeRepository timeRepository;

        public void executar(long id) {
            timeRepository.deleteById(id);
        }
}
