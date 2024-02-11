package br.com.duxus.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
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






//	public void addComposicao(ComposicaoTime composicao) {
//		this.composicaoTime.add(composicao);
//		composicao.setIntegrante(this);
//	}

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




}
