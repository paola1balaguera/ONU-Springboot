package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import com.Proyecto.ONU.Repository.Entities.Cuota;
import com.Proyecto.ONU.Repository.Entities.Persona;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class SocioDTO {

    @NotEmpty(message = "no puede estar vacio")
    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String cuentaBancaria;

    @NotEmpty(message = "no puede estar vacio")
    private Persona persona;

    @NotEmpty(message = "no puede estar vacio")
    private Cuota cuota;
}
