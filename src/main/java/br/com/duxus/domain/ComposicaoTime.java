package br.com.duxus.domain;


import br.com.duxus.repository.ComposicaoTimeRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "composicao_time")
public class ComposicaoTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Time time;

	@ManyToOne(cascade = CascadeType.ALL)
	private Integrante integrante;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ComposicaoTime)) return false;
		ComposicaoTime that = (ComposicaoTime) o;
		return id == that.id && Objects.equals(time, that.time) && Objects.equals(integrante, that.integrante);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(id, time, integrante);
	}


//	public Long getIdIntegrante() {
//		ComposicaoTimeRepository composicaoTimeRepository = null;
//		Optional<Long> idIntegranteOptional = composicaoTimeRepository.findIdIntegranteByOrderByIdDesc();
//		if (idIntegranteOptional.isPresent()) {
//			Long idIntegrante = idIntegranteOptional.get();
//			return idIntegrante;
//		} else {
//			throw new RuntimeException("Nenhuma composição de time encontrada");
//		}
//	}
}
