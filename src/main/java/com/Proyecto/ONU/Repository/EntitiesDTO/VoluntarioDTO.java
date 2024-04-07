package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import com.Proyecto.ONU.Repository.Entities.Persona;
import com.Proyecto.ONU.Repository.Entities.Voluntario;

import lombok.Data;

@Data
public class VoluntarioDTO {
    private BigInteger id;

    private Voluntario.tipoVoluntario tipo; 

    private Boolean disponibilidad;

    private Long numeroTrabajos;

    private String profesion;

    private Persona persona;

}
