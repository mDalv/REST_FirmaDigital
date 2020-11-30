package br.intelidata.mapfre.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "estadoproceso", schema = "bddespifd")
@Data
public class EstadoProceso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idestadoproceso")
	private String idEstPro;
	@Column(name = "descripcion")
	private String descripcion;
}
