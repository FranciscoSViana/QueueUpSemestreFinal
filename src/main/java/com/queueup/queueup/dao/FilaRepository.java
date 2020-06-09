package com.queueup.queueup.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.queueup.queueup.model.Fila;

@Repository
public interface FilaRepository extends JpaRepository<Fila, UUID> {

	@Query("from Fila where status_=0")
	public List<Fila> mesaDisp();

	@Query("from Fila where status_=1")
	public List<Fila> mesaOcupada();

	@Transactional
	@Modifying
	@Query("update Fila set status_ = 1 where idFila =:id")
	public void ocuparMesa(@Param("id") UUID id);

	@Transactional
	@Modifying
	@Query("update Fila set status_ = 0 where idFila =:id")
	public void desocuparMesa(@Param("id") UUID id);

}
