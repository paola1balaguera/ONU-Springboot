package com.Proyecto.ONU.Repository.EntitiesDTO;



import com.Proyecto.ONU.Repository.Entities.Material;

import lombok.Data;

@Data
public class MaterialDTO {
    
    private Long id;

    private Material.tipoMaterial tipo; 

    private String nombre;
}
