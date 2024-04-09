package com.Proyecto.ONU.Repository.EntitiesDTO;



import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CiudadDTO {

    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;


}
