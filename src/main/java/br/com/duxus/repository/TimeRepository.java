package br.com.duxus.repository;

import br.com.duxus.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimeRepository extends JpaRepository<Time, Long> {
    List<Time> findByData(LocalDate data);
}
