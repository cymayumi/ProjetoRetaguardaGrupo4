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
@Table(name="TB_TIPO_EXAME")
@NamedQuery(name="Exame.findAll", query="SELECT t FROM ExameEntity t")
public class ExameEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	@Column(name="ID_TIPO_EXAME")
	private BigInteger idTipoExame;
	
	@Column(name="DS_TIPO_EXAME")
	private String dsTipoExame;
	
	public ExameEntity() {
		
	}

	public BigInteger getIdTipoExame() {
		return idTipoExame;
	}

	public void setIdTipoExame(BigInteger idTipoExame) {
		this.idTipoExame = idTipoExame;
	}

	public String getDsTipoExame() {
		return dsTipoExame;
	}

	public void setDsTipoExame(String dsTipoExame) {
		this.dsTipoExame = dsTipoExame;
	}
	
}
