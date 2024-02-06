package br.com.duxus.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

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
	
	@ManyToOne
	private Time time;

	@ManyToOne
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



}
