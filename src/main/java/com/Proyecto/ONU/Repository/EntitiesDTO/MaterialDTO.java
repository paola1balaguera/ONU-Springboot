package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import com.Proyecto.ONU.Repository.Entities.Material;

import lombok.Data;

@Data
public class MaterialDTO {
    
    private BigInteger id;

    private Material.tipoMaterial tipo; 

    private String nombre;
}
