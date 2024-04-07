package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CiudadDTO {

    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;


}
