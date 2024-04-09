package com.Proyecto.ONU.Repository.EntitiesDTO;


import java.sql.Date;
import com.Proyecto.ONU.Repository.Entities.Sede;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaDTO {

    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombreCompleto;

    @NotNull(message = "no puede estar vacio")
    private Date fechaNacimiento ;

    @NotEmpty(message = "no puede estar vacio")
    private String direccionVivienda;

    @NotEmpty(message = "no puede estar vacio")
    private String correoElectronico;

    @NotNull(message = "no puede estar vacio")
    private Long numeroTelefono;

    private Sede sede;

}

