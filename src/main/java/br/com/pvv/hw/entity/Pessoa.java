package br.com.pvv.hw.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PESSOA")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
//id;nome;cidade;estado;cep;aniv;emprego
	@Id
	@Column
	private long id;
	@Column
	private String nome;
	@Column
	private String cidade;
	@Column
	private String estado;
	@Column
	private String cep;
	@Column
	private String aniv;
	@Column
	private String emprego;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getAniv() {
		return this.aniv;
	}

	public void setAniv(String aniv) {
		this.aniv = aniv;
	}

	public String getEmprego() {
		return this.emprego;
	}

	public void setEmprego(String emprego) {
		this.emprego = emprego;
	}

	
}
