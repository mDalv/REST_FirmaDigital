package br.intelidata.mapfre.rest.domain.detalle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleRequest {
	private int page;
	private int size;
}
