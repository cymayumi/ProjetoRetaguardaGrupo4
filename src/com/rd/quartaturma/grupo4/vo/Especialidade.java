package com.rd.quartaturma.grupo4.vo;

import java.math.BigInteger;

public class Especialidade {

	private BigInteger idTipoEspecialidade;
	private String dsTipoEspecialidade;
	
	public Especialidade() {
		
	}

	public Especialidade(BigInteger idTipoEspecialidade, String dsTipoEspecialidade) {
		super();
		this.idTipoEspecialidade = idTipoEspecialidade;
		this.dsTipoEspecialidade = dsTipoEspecialidade;
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
