package com.queueup.queueup.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queueup.queueup.model.Usuario;

@Service
public class LoginService {

	@Autowired
	private EntityManager em;
	
	public Usuario findLoginUsuario() {
		return(Usuario) this.em.createQuery("from Usuario " + "order by nome").setMaxResults(1).getSingleResult();
	}
}
