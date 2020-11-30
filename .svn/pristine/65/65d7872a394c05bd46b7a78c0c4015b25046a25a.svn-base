package br.intelidata.mapfre.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.intelidata.mapfre.rest.entity.Proceso;

@Repository
public interface ProcesoRep extends JpaRepository<Proceso, String> {
	@Transactional
	@Modifying
	@Query("UPDATE Proceso p SET p.estado.idEstPro = :estado WHERE p.idDoc = :id")
	void updateEstado(@Param("id") String id, @Param("estado") String status);

	@Transactional
	@Modifying
	@Query("UPDATE Proceso p SET p.idCertificado = :certificado WHERE p.idDoc = :id")
	void updateCertificado(@Param("id") String id, @Param("certificado") String certificado);

	@Query("FROM Proceso WHERE idDoc = ?1")
	Optional<Proceso> findByIdDoc(String idDoc);
}