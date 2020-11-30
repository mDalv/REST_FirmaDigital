package br.intelidata.mapfre.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "visualizacion", schema = "bddespifd")
@Data
public class Visualizacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvisualizacion")
	private String idVisualizacion;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "fechacreacion")
	private String fechaCreacion;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "totalparticipantes")
	private int totalParticipantes;
	@Column(name = "estado")
	private String estado;
}
