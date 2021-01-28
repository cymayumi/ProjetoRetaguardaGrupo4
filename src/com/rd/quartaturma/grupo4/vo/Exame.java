package com.rd.quartaturma.grupo4.vo;

import java.math.BigInteger;

public class Exame {

	private BigInteger idTipoExame;
	private String dsTipoExame;
	
	public Exame() {
		
	}
	
	public Exame(BigInteger idTipoExame, String dsTipoExame) {
		this.idTipoExame = idTipoExame;
		this.dsTipoExame = dsTipoExame;
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
