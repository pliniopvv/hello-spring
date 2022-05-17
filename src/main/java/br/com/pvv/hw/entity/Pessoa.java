package br.com.pvv.hw.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PESSOA")
@Data
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
}
