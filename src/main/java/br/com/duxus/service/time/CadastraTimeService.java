package br.com.duxus.service.time;

import br.com.duxus.controller.dto.TimeDTO;
import br.com.duxus.domain.Time;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraTimeService {

        @Autowired
        private TimeRepository timeRepository;

        public Time executar(TimeDTO request) {
            return timeRepository.save(getTime(request));
        }

    private Time getTime(TimeDTO request) {
        return Time
                .builder()
                .data(request.getData())
                .build();
    }
}

