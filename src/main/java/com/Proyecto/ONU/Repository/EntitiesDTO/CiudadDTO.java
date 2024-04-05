package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import com.Proyecto.ONU.Repository.Entities.Sede;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CiudadDTO {

    @NotEmpty(message = "no puede estar vacio")
    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;

    @NotEmpty(message = "no puede estar vacio")
    private Sede sede;


}
