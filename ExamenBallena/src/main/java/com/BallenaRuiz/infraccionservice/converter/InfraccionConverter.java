package com.BallenaRuiz.infraccionservice.converter;

import org.springframework.stereotype.Component;

import com.BallenaRuiz.infraccionservice.dto.InfraccionDTO;
import com.BallenaRuiz.infraccionservice.entity.Infraccion;


@Component
public class InfraccionConverter extends AbstractConverter<Infraccion,InfraccionDTO>{

	//Convertir a un DTo
	@Override
	public InfraccionDTO fromEntity(Infraccion entity) {
		if(entity==null) return null;
		return InfraccionDTO.builder() //construirlo
				.id(entity.getId())
				.dni(entity.getDni())
				.fecha(entity.getFecha())
				.falta(entity.getFalta())
				.infraccion(entity.getInfraccion())
				.descripcion(entity.getDescripcion())
				.build();
	}

	@Override
	public Infraccion fromDTO(InfraccionDTO dto) {
		if(dto==null) return null;
		return Infraccion.builder() //construirlo
				.id(dto.getId())
				.dni(dto.getDni())
				.dni(dto.getDni())
				.fecha(dto.getFecha())
				.falta(dto.getFalta())
				.infraccion(dto.getInfraccion())
				.descripcion(dto.getDescripcion())
				.build();
	}

}
