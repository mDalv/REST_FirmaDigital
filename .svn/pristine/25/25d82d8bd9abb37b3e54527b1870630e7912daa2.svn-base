package br.intelidata.mapfre.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.intelidata.mapfre.rest.domain.detalle.DetalleRequest;
import br.intelidata.mapfre.rest.domain.detalle.DetalleResponse;
import br.intelidata.mapfre.rest.domain.estado.EstadoDocumentoResponse;
import br.intelidata.mapfre.rest.domain.firma.FirmaRequest;
import br.intelidata.mapfre.rest.domain.firma.FirmaResponse;
import br.intelidata.mapfre.rest.domain.update.UpdateResponse;
import br.intelidata.mapfre.rest.entity.Proceso;
import br.intelidata.mapfre.rest.service.ApiRestService;

@RestController
//@CrossOrigin(origins = "http://localhost:4205")
@Validated
@CrossOrigin(origins = "*")
public class ApiRestController {

	private static final Logger LOGGER = LogManager.getLogger(ApiRestController.class);

	/**
	 * Servicio Api Rest
	 */
	@Autowired
	ApiRestService arp;

	/**
	 * Metodo que recibe datos para iniciar proceso de firma y entrega la respuesta
	 * considerando si la peticion es valida
	 * 
	 * @param request {@link FirmaRequest}
	 * @return {@link FirmaResponse}
	 */
	@PostMapping(path = "firma", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FirmaResponse firmaDocumento(@Valid @RequestBody FirmaRequest request) {
		LOGGER.info("/firma");
		return arp.insertData(request);
	}

	/**
	 * Metodo que recibe datos para paginacion y entrega un listado (tabla
	 * visualizacion)
	 * 
	 * @param request {@link DetalleRequest}
	 * @return {@link DetalleResponse}
	 */
	@PostMapping(path = "detalle", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DetalleResponse getDetalle(@RequestBody DetalleRequest request) {
		LOGGER.info("/detalle");
		return arp.getDetalle(request);
	}

	/**
	 * Metodo que entrega listado de procesos (tabla proceso)
	 * 
	 * @return {@link Proceso}
	 */
	@RequestMapping(path = "procesos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Proceso> getProcesos() {
		LOGGER.info("/procesos");
		return arp.getProcesos();
	}

	/**
	 * Metodo que entrega datos mediante id Visual Vault (tabla proceso)
	 * 
	 * @param id (id Visual Vault)
	 * @return {@link Proceso}
	 */
	@RequestMapping(path = "proceso/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Optional<Proceso> getProceso(@PathVariable String id) {
		LOGGER.info("/proceso/{}", id);
		return arp.getProceso(id);
	}

	/**
	 * Metodo que actualiza estado del proceso, mediante id Visual Vault (tabla
	 * proceso)
	 * 
	 * @param id     (id Visual Vault)
	 * @param estado (estado proceso)
	 * @return {@link UpdateResponse}
	 */
	@PutMapping(path = "update/{id}/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UpdateResponse updateProceso(@PathVariable String id, @PathVariable String estado) {
		LOGGER.info("/update/{}/{}", id, estado);
		return arp.updateEstado(id, estado);
	}

	/**
	 * Metodo que actualiza certificado del proceso, mediante id Visual Vault e id
	 * Certificado (tabla proceso)
	 * 
	 * @param id          (id Visual Vault)
	 * @param certificado (id Certificado)
	 * @return {@link UpdateResponse}
	 */
	@PutMapping(path = "updateCertificado/{id}/{certificado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UpdateResponse updateCertificado(@PathVariable String id, @PathVariable String certificado) {
		LOGGER.info("/update/{}/{}", id, certificado);
		return arp.updateCertificado(id, certificado);
	}

	/**
	 * Metodo que retorna el estado del proceso, mediante id Visual Vault y cpf
	 * (tabla proceso)
	 * 
	 * @param idDoc (id Visual Vault)
	 * @param cpf   (cpf cliente)
	 * @return {@link EstadoDocumentoResponse}
	 */
	@RequestMapping(path = "estado/{idDoc}/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EstadoDocumentoResponse getEstadoDocumento(@PathVariable String idDoc,
			@PathVariable String cpf) {
		LOGGER.info("/estado/{}/{}", idDoc, cpf);
		return arp.getEstadoDocumento(idDoc, cpf);
	}

	@GetMapping("hello")
	public String hello() {
		return "hello azure!";
	}
}
