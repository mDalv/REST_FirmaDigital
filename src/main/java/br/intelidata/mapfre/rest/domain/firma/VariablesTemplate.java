package br.intelidata.mapfre.rest.domain.firma;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VariablesTemplate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String var;

	private String valor;

	public VariablesTemplate() {
		var = "templateVar";
		valor = "templateValor";
	}

	public VariablesTemplate(String var, String valor) {
		this.var = var;
		this.valor = valor;
	}

}
