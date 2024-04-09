package com.Proyecto.ONU.Repository.EntitiesDTO;



import com.Proyecto.ONU.Repository.Entities.Ciudad;

import lombok.Data;

@Data
public class RefugioDTO {
    private Long id;

    private String nombre;

    private String direccion;

    private Ciudad ciudad;
}
