package com.BallenaRuiz.infraccionservice.validator;

import com.BallenaRuiz.infraccionservice.entity.Infraccion;
import com.BallenaRuiz.infraccionservice.exceptions.ValidateServiceException;

public class InfraccionValidator {
	public static void save(Infraccion infraccion) {
        if (infraccion.getDni() == null || infraccion.getDni().isEmpty()) {
            throw new ValidateServiceException("El dni es requerido");
        }
        if (infraccion.getDni().length()>100) {
        	throw new ValidateServiceException("El dni es muy largo");
        }
        if (infraccion.getFecha().length()>100) {
        	throw new ValidateServiceException("La fecha es muy largo");
        }
        if (infraccion.getFalta().length()>100) {
        	throw new ValidateServiceException("La falta es muy largo");
        }
        if (infraccion.getInfraccion().length()>100) {
        	throw new ValidateServiceException("La infracción es muy largo");
        }
        if (infraccion.getDescripcion().length()>100) {
        	throw new ValidateServiceException("La descripción es muy largo");
        }
    }
}

