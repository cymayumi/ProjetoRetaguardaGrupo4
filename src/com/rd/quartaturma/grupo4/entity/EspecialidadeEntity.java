package com.rd.quartaturma.grupo4.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name="TB_ESP_MED")
@NamedQuery(name="Especialidade.findAll", query="SELECT t FROM EspecialidadeEntity t")
public class EspecialidadeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	@Column(name="ID_ESP_MED")
	private BigInteger idTipoEspecialidade;
	
	@Column(name="DS_ESP_MED")
	private String dsTipoEspecialidade;
	
	public EspecialidadeEntity() {
		
	}

	public BigInteger getIdTipoEspecialidade() {
		return idTipoEspecialidade;
	}

	public void setIdTipoEspecialidade(BigInteger idTipoEspecialidade) {
		this.idTipoEspecialidade = idTipoEspecialidade;
	}

	public String getDsTipoEspecialidade() {
		return dsTipoEspecialidade;
	}

	public void setDsTipoEspecialidade(String dsTipoEspecialidade) {
		this.dsTipoEspecialidade = dsTipoEspecialidade;
	}


	
}
