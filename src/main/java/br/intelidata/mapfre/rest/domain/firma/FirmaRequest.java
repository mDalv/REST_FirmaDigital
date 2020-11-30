package br.intelidata.mapfre.rest.domain.firma;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FirmaRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String documentoB64;

	private String documentoId;

	private String nombre;

	private String producto;

	private String fechaCreacion;
	private List<VariablesTemplate> variablesTemplate;
	private List<Destinatario> destinatario;
	private List<Remitente> remitente;

	public FirmaRequest() {
		documentoId = "1";
		producto = "FR499";
	}

}
