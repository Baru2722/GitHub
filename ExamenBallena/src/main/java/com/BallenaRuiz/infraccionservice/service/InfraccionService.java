package com.BallenaRuiz.infraccionservice.service;

import org.springframework.data.domain.Pageable;

import com.BallenaRuiz.infraccionservice.entity.Infraccion;

import java.util.List;

public interface InfraccionService {
	//Metodos
	public List<Infraccion> findAll(Pageable page);
	public List<Infraccion> finByDni(String dni,Pageable page ); //Busqueda
	public Infraccion findById (int id);
	public Infraccion save (Infraccion infraccion);
	public Infraccion update (Infraccion infraccion);
	public void delete (int id);

}

