package com.queueup.queueup.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.queueup.queueup.model.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, UUID>{
	
	@Query("from Mesa where status_=0")
	public List<Mesa> mesaDisp();
	
	@Query("from Mesa where status_=1")
	public List<Mesa> mesaOcupada();
	
	
	@Transactional
	@Modifying
	@Query("update Mesa set status_ = 1 where idMesa =:id")
	public void ocuparMesa(@Param("id") UUID id);
	
	@Transactional
	@Modifying
	@Query("update Mesa set status_ = 0 where idMesa =:id")
	public void desocuparMesa(@Param("id") UUID id); 
	
	
}
