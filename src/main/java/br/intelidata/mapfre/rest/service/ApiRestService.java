package br.intelidata.mapfre.rest.service;

import java.util.List;
import java.util.Optional;

import br.intelidata.mapfre.rest.domain.detalle.DetalleRequest;
import br.intelidata.mapfre.rest.domain.detalle.DetalleResponse;
import br.intelidata.mapfre.rest.domain.estado.EstadoDocumentoResponse;
import br.intelidata.mapfre.rest.domain.firma.FirmaRequest;
import br.intelidata.mapfre.rest.domain.firma.FirmaResponse;
import br.intelidata.mapfre.rest.domain.update.UpdateResponse;
import br.intelidata.mapfre.rest.entity.Proceso;

public interface ApiRestService {

	FirmaResponse insertData(FirmaRequest request);

	UpdateResponse updateEstado(String id, String estado);

	UpdateResponse updateCertificado(String id, String certificado);

	DetalleResponse getDetalle(DetalleRequest requOest);

	EstadoDocumentoResponse getEstadoDocumento(String idDoc, String cpf);

	List<Proceso> getProcesos();

	Optional<Proceso> getProceso(String id);
}
