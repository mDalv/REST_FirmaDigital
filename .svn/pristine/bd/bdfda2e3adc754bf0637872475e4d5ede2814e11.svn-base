package br.intelidata.mapfre.rest.service.imp;

import static br.intelidata.mapfre.rest.util.Constants.CPF_NO_ENCONTRADO;
import static br.intelidata.mapfre.rest.util.Constants.DOC_NO_ENCONTRADO;
import static br.intelidata.mapfre.rest.util.Constants.PROC_ENCONTRADO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.intelidata.mapfre.rest.domain.detalle.DetalleRequest;
import br.intelidata.mapfre.rest.domain.detalle.DetalleResponse;
import br.intelidata.mapfre.rest.domain.estado.EstadoDocumentoResponse;
import br.intelidata.mapfre.rest.domain.firma.FirmaRequest;
import br.intelidata.mapfre.rest.domain.firma.FirmaResponse;
import br.intelidata.mapfre.rest.domain.update.UpdateResponse;
import br.intelidata.mapfre.rest.entity.CargaEtl;
import br.intelidata.mapfre.rest.entity.Proceso;
import br.intelidata.mapfre.rest.entity.Visualizacion;
import br.intelidata.mapfre.rest.repository.CargaEtlRep;
import br.intelidata.mapfre.rest.repository.ProcesoRep;
import br.intelidata.mapfre.rest.repository.VisualizacionRep;
import br.intelidata.mapfre.rest.security.NotFoundException;
import br.intelidata.mapfre.rest.service.ApiRestService;

@Service
public class ApiRestServiceImp implements ApiRestService {

	/*
	 * @Value("${datafile.path}") String fileName;
	 */

	@Autowired
	CargaEtl carga;

	@Autowired
	CargaEtlRep cargaRep;

	@Autowired
	ProcesoRep procRep;

	@Autowired
	VisualizacionRep visualizacionRep;

	/**
	 * Metodo que inserta datos en tabla cargaetl
	 * 
	 * @param request {@link FirmaRequest}
	 * @return {@link FirmaResponse}
	 */
	@Override
	public FirmaResponse insertData(FirmaRequest request) {
		/* Datos extraidos Request Json */
		for (int i = 0; i < request.getDestinatario().size(); i++) { /* Iteracion por cantidad de destinatarios */
			/* Insercion de datos a objeto para cargar en BD (tabla cargaetl) */
			carga.setArchivoPdf(request.getDocumentoB64().getBytes()); // ArchivoPDF
			carga.setIdDoc(request.getDocumentoId().concat("_").concat(request.getDestinatario().get(i).getCpf_cnpj())); // IdDocumento
			carga.setDescDoc(request.getNombre()); // DescripcionDocumento
			carga.setProdId(request.getProducto()); // ProductoID
			carga.setFechaCreacion(request.getFechaCreacion()); // FechaCreacion
			/* Validacion cantidad de variables template */
			if (request.getVariablesTemplate() != null) {
				carga.setAsunto(request.getVariablesTemplate().get(i).getVar()); // Asunto
				carga.setMensaje(request.getVariablesTemplate().get(i).getValor()); // Mensaje
			} else {
				carga.setAsunto("sinAsunto"); // Asunto
				carga.setMensaje("sinMensaje"); // Mensaje
			}
			/* Validacion cantidad de destinatarios */
			if (request.getDestinatario() != null) {
				carga.setNomCli(request.getDestinatario().get(i).getNombre()); // NombreCliente
				carga.setRutCli(request.getDestinatario().get(i).getCpf_cnpj()); // RutCliente
				carga.setCorreoCli(request.getDestinatario().get(i).getEmail()); // CorreoCliente
				carga.setIdTipoCli(request.getDestinatario().get(i).getTipoSignatario()); // IdTipoCliente
			} else {
				carga.setNomCli("sinNomCli"); // NombreCliente
				carga.setRutCli("sinRutCli"); // RutCliente
				carga.setCorreoCli("sinCorreoCli"); // CorreoCliente
				carga.setIdTipoCli("sinIdTipoCli"); // IdTipoCliente
			}
			/* Validacion cantidad de remitentes */
			if (request.getRemitente() != null) {
				carga.setNomCorredor(request.getRemitente().get(0).getNombre()); // NombreCorredor
				carga.setCorreoCorredor(request.getRemitente().get(0).getEmail()); // CorreoCorredor
				carga.setLogoCorredor(request.getRemitente().get(0).getLogoCorretor()); // LogoCorredor
			} else {
				carga.setNomCorredor("sinNomCorredor"); // NombreCorredor
				carga.setCorreoCorredor("sinCorreoCorredor"); // CorreoCorredor
				carga.setLogoCorredor(new byte[0]); // LogoCorredor
			}

			/* Datos NOT Null */
			carga.setCodCarga("0"); // CodigoCarga
			carga.setIdProceso("0"); // IdProceso
			carga.setIdCli("0"); // IdCliente
			carga.setIdCom("0"); // IDComunicacion
			carga.setIdContacto("0"); // IdContacto
			carga.setIdProcFirma("0"); // IdProcesoFirma
			carga.setIdCorredor("0"); // IdCorredor
			carga.setIdVv("0"); // IdVV
			carga.setProcesadoId("0"); // ProcesadoID

			/* Insert a tabla cargaetl */
			cargaRep.save(carga);
		}
		return new FirmaResponse(request.getDocumentoId(), HttpStatus.OK);
	}

	/**
	 * Metodo que obtiene el listado completo de procesos
	 * 
	 * @return {@link Proceso}
	 */
	@Override
	public List<Proceso> getProcesos() {
		return procRep.findAll();
	}

	/**
	 * Metodo que obtiene los detalles del proceso
	 * 
	 * @param id (id Visual Vault)
	 * @return {@link Proceso}
	 */
	@Override
	public Optional<Proceso> getProceso(String id) {
		return procRep.findByIdDoc(id);
	}

	/**
	 * Metodo que actualiza el estado del proceso
	 * 
	 * @param id     (id Visual Vault)
	 * @param estado (estado proceso)
	 * 
	 * @return {@link UpdateResponse}
	 */
	@Override
	public UpdateResponse updateEstado(String id, String estado) {
		/* Update estado a tabla proceso */
		Optional<Proceso> procOptional = procRep.findByIdDoc(id);
		if (!procOptional.isPresent()) {
			return new UpdateResponse(id, HttpStatus.NO_CONTENT);
		}
		procRep.updateEstado(id, estado);
		return new UpdateResponse(id, HttpStatus.OK);
	}

	/**
	 * Metodo que actualiza id Certificado
	 * 
	 * @param id          (id Visual Vault)
	 * @param certificado (id certificado)
	 * 
	 * @return {@link UpdateResponse}
	 */
	@Override
	public UpdateResponse updateCertificado(String id, String certificado) {
		/* Update id Certificado a tabla proceso */
		Optional<Proceso> procOptional = procRep.findByIdDoc(id);
		if (!procOptional.isPresent()) {
			return new UpdateResponse(id, HttpStatus.NO_CONTENT);
		}
		procRep.updateCertificado(id, certificado);
		return new UpdateResponse(id, HttpStatus.OK);
	}

	/**
	 * Metodo que obtiene el detalle con el estado del documento
	 * 
	 * @param id  (id Visual Vault)
	 * @param cpf (cpf cliente)
	 * @return {@link EstadoDocumentoResponse}
	 */
	@Override
	public EstadoDocumentoResponse getEstadoDocumento(String id, String cpf) {
		/* Validacion registro existe en tabla proceso */
		Optional<Proceso> procOptIdDoc = procRep.findByIdDoc(id);
		if (!procOptIdDoc.isPresent()) {
			return new EstadoDocumentoResponse("0", DOC_NO_ENCONTRADO);
		}

		if (!procOptIdDoc.get().getCpf().equals(cpf)) {
			return new EstadoDocumentoResponse("0", CPF_NO_ENCONTRADO);
		}
		return new EstadoDocumentoResponse("1", PROC_ENCONTRADO);
	}

	/**
	 * Metodo que obtiene el detalle de paginacion
	 * 
	 * @param request {@link DetalleRequest}
	 * @return {@link DetalleResponse}
	 */

	@Override
	public DetalleResponse getDetalle(DetalleRequest request) {
		/* Obtencion de datos tabla visualizacion */
		Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
		Page<Visualizacion> contenido;
		contenido = visualizacionRep.detalle(pageable);
		List<Visualizacion> listVisualizacion = contenido.getContent();
		Long cantidad = contenido.getTotalElements();
		if (listVisualizacion.isEmpty()) {
			throw new NotFoundException("No se encontraron registros");
		}
		return new DetalleResponse(cantidad, listVisualizacion);
	}
}
