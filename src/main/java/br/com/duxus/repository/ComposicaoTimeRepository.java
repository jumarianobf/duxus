package br.com.duxus.repository;

import br.com.duxus.domain.ComposicaoTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface ComposicaoTimeRepository extends JpaRepository<ComposicaoTime, Long> {

    List<ComposicaoTime> findByTimeId(long id);
    List<ComposicaoTime> findByTimeData(LocalDate data);

    List<ComposicaoTime> findByTimeDataBetween(LocalDate dataInicial, LocalDate dataFinal);
}
