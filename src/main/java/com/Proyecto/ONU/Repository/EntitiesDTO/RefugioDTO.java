package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import com.Proyecto.ONU.Repository.Entities.Ciudad;

import lombok.Data;

@Data
public class RefugioDTO {
    private BigInteger id;

    private String nombre;

    private String direccion;

    private Ciudad ciudad;
}
