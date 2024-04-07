package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import com.Proyecto.ONU.Repository.Entities.Persona;
import com.Proyecto.ONU.Repository.Entities.TipoCuota;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SocioDTO {

    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String cuentaBancaria;
    
    private TipoCuota tipoCuota;

  
    private Persona persona;
}
