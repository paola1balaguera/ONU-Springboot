package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;
import java.sql.Date;
import com.Proyecto.ONU.Repository.Entities.Sede;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaDTO {

    @NotEmpty(message = "no puede estar vacio")
    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombreCompleto;

    @NotEmpty(message = "no puede estar vacio")
    private Date fechaNacimiento ;

    @NotEmpty(message = "no puede estar vacio")
    private String direccionVivienda;

    @NotEmpty(message = "no puede estar vacio")
    private String correoElectronico;

    @NotEmpty(message = "no puede estar vacio")
    private Long numero;

    @NotEmpty(message = "no puede estar vacio")
    private Sede sede;

    @NotNull(message = "no puede estar vacio")
    private Boolean esSocio;
}

