package br.com.duxus.repository;

import br.com.duxus.domain.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegranteRepository extends JpaRepository<Integrante, Long> {
}

