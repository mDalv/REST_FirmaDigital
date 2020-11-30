package br.intelidata.mapfre.rest.domain.firma;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Destinatario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;

	private String cpf_cnpj;

	private String email;

	private String tipoSignatario;

	public Destinatario() {
		cpf_cnpj = "destinatarioCpfCnpj";
		tipoSignatario = "1";
	}

}
