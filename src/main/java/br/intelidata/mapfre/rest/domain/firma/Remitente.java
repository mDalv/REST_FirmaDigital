package br.intelidata.mapfre.rest.domain.firma;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Remitente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;

	private String email;

	private byte[] logoCorretor;

	public Remitente() {
		nombre = "remitenteNombre";
		email = "remitenteEmail";
	}

}
