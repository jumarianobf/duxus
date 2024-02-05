package br.com.duxus.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "integrante")
public class Integrante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column
	private String franquia;

	@NotNull
	@Column
	private String nome;

	@NotNull
	@Column
	private String funcao;

//	@OneToMany(targetEntity=ComposicaoTime.class, mappedBy = "integrante")
//	private List<ComposicaoTime> composicaoTime;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Integrante)) return false;
		Integrante that = (Integrante) o;
		return id == that.id && Objects.equals(franquia, that.franquia) && Objects.equals(nome, that.nome) && Objects.equals(funcao, that.funcao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, franquia, nome, funcao);
	}




//	public String integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal) {
//		List<Time> times = getTimes(dataInicial, dataFinal);
//		Map<String, Integer> contagem = new HashMap<>();
//		for (Time time : times) {
//			for (Integrante integrante : time.getIntegrantes()) {
//				contagem.put(String.valueOf(integrante), contagem.getOrDefault(integrante, 0) + 1);
//			}
//		}
//	}
}
