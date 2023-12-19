package com.BallenaRuiz.infraccionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BallenaRuiz.infraccionservice.entity.Infraccion;

import java.util.List;

@Repository
public interface InfraccionRepository extends JpaRepository<Infraccion, Integer>{
	List<Infraccion> findByDniContaining(String dni, org.springframework.data.domain.Pageable page); // Metodo para buscar por el mombre
	Infraccion findByDni(String dni);
}