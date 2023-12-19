package com.BallenaRuiz.infraccionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BallenaRuiz.infraccionservice.converter.InfraccionConverter;
import com.BallenaRuiz.infraccionservice.dto.InfraccionDTO;
import com.BallenaRuiz.infraccionservice.entity.Infraccion;
import com.BallenaRuiz.infraccionservice.service.InfraccionService;
import com.BallenaRuiz.infraccionservice.utils.WrapperResponse;


@RestController
@RequestMapping("/api/infraccion")
public class InfraccionController {
	
	@Autowired
	private InfraccionService service;
	
	@Autowired 
	private InfraccionConverter converter;
	
	//Metodos 
	@GetMapping()
	public ResponseEntity<List<InfraccionDTO>> findAll( // el Metodo findAll va a devolver los DTO
			//Parametros
			@RequestParam (value = "dni",required = false, defaultValue ="") String dni,
			@RequestParam (value = "offset",required = false, defaultValue ="0") int pageDni,
			@RequestParam (value = "limit",required = false, defaultValue ="5") int pageSize
			){
		Pageable page= PageRequest.of(pageDni,pageSize);
		List<Infraccion> infraciones;
		if(dni==null) {
			infraciones=service.findAll(page);	
		}else {
			infraciones=service.finByDni(dni, page);
		}
		
		List<InfraccionDTO> infraccionesDTO=converter.fromEntity(infraciones); //convirte una lista de entidades a una lista de DTO
		return new WrapperResponse(true,"success",infraccionesDTO).createResponse(HttpStatus.OK); // Devuelve la lista
	}
	
	@GetMapping(value="/{id}") //Notaciòn
	public ResponseEntity<WrapperResponse<InfraccionDTO>> findById(@PathVariable("id")int id){
		Infraccion infraccion = service.findById(id);
		InfraccionDTO infraccionDTO=converter.fromEntity(infraccion); // se envia una entidad y lo convierte a un DTO
		return new WrapperResponse<InfraccionDTO>(true,"success",infraccionDTO).createResponse(HttpStatus.OK); //retorna un DTO
	}
	
	@PostMapping()
	public ResponseEntity<InfraccionDTO> create(@RequestBody InfraccionDTO infraccionesDTO){ //esperando un articulo DTO
		Infraccion registro=service.save(converter.fromDTO(infraccionesDTO)); // convertir de un DTO a una entidad
		InfraccionDTO registroDTO=converter.fromEntity(registro);
		return new WrapperResponse(true,"success",registroDTO).createResponse(HttpStatus.CREATED); //devolver el registro DTO
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<InfraccionDTO> update(@PathVariable("id")int id,@RequestBody InfraccionDTO infraccionDTO){
		Infraccion registro = service.update(converter.fromDTO(infraccionDTO));
		InfraccionDTO registroDTO=converter.fromEntity(registro); // se envia una entidad y lo convierte a un DTO
		return new WrapperResponse(true,"success",registro).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<InfraccionDTO> delete(@PathVariable("id")int id){
		service.delete(id);
		return new WrapperResponse(true,"success",null).createResponse(HttpStatus.OK);
	}
}
