package com.Proyecto.ONU.Repository.EntitiesDTO;



import com.Proyecto.ONU.Repository.Entities.Persona;
import com.Proyecto.ONU.Repository.Entities.Voluntario;

import lombok.Data;

@Data
public class VoluntarioDTO {
    private Long id;

    private Voluntario.tipoVoluntario tipo; 

    private Boolean disponibilidad;

    private Long numeroTrabajos;

    private String profesion;

    private Persona persona;

}
