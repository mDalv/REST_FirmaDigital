package br.intelidata.mapfre.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.intelidata.mapfre.rest.entity.Visualizacion;

@Repository
public interface VisualizacionRep extends JpaRepository<Visualizacion, Integer> {
	@Query(value = "SELECT v FROM Visualizacion v")
	Page<Visualizacion> detalle(Pageable pageable);
}
