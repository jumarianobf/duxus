package br.com.duxus.repository;

import br.com.duxus.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimeRepository extends JpaRepository<Time, Long> {

    Optional<Time> findByData(LocalDate data);
    List<Time> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);
}
