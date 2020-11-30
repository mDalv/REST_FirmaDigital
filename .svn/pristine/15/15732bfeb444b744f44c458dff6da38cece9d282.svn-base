package br.intelidata.mapfre.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "cargaetl", schema = "bddespifd")
@Data
@Component
public class CargaEtl implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idetl")
	private String idEtl;
	@Column(name = "codigocarga")
	private String codCarga;
	@Column(name = "idproceso")
	private String idProceso;
	@Column(name = "iddocumento")
	private String idDoc;
	@Column(name = "descripciondocumento")
	private String descDoc;
	@Column(name = "productoid")
	private String prodId;
	@Column(name = "fechacreacion")
	private String fechaCreacion;
	@Column(name = "idcomunicacion")
	private String IdCom;
	@Column(name = "asunto")
	private String asunto;
	@Column(name = "mensaje")
	private String mensaje;
	@Column(name = "idcliente")
	private String idCli;
	@Column(name = "idprocesofirma")
	private String idProcFirma;
	@Column(name = "nombrecliente")
	private String nomCli;
	@Column(name = "rutcliente")
	private String rutCli;
	@Column(name = "idcontacto")
	private String idContacto;
	@Column(name = "correocliente")
	private String correoCli;
	@Column(name = "idtipocliente")
	private String idTipoCli;
	@Column(name = "idcorredor")
	private String idCorredor;
	@Column(name = "idvv")
	private String idVv;
	@Column(name = "nombrecorredor")
	private String nomCorredor;
	@Lob
	@Column(name = "logocorredor")
	private byte[] logoCorredor;
	@Column(name = "correocorredor")
	private String correoCorredor;
	@Lob
	@Column(name = "archivopdf")
	private byte[] archivoPdf;
	@Column(name = "procesadoid")
	private String procesadoId;
}
