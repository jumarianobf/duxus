package br.com.duxus.service.time;

import br.com.duxus.controller.dto.TimeDTO;
import br.com.duxus.domain.Time;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizaTimeService {

        @Autowired
        private TimeRepository timeRepository;

        public Time executar(Long id, TimeDTO request) {
            var time = timeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Time não encontrado"));
            time.setData(request.getData());
            return timeRepository.save(time);
        }
}
