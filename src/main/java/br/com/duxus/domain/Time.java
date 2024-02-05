package br.com.duxus.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "time")
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
    private LocalDate data;
	

//	@OneToMany(targetEntity=ComposicaoTime.class, mappedBy = "time", cascade = CascadeType.ALL)
//	private List<ComposicaoTime> composicaoTime;

//	public Time(List<Integrante> integrantes) {
//		this.integrantes = integrantes;
//	}

//	public Time(LocalDate data, List<ComposicaoTime> composicaoTime) {
//		this.data = data;
//		this.composicaoTime = composicaoTime;
//	}



	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Time)) return false;
		Time time = (Time) o;
		return id == time.id && Objects.equals(data, time.data);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(id, data);
	}
}
