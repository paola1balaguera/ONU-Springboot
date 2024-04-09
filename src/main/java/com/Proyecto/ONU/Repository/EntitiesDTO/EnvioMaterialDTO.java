package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import com.Proyecto.ONU.Repository.Entities.Envio;
import com.Proyecto.ONU.Repository.Entities.Material;

import lombok.Data;

@Data
public class EnvioMaterialDTO {
    
    private BigInteger id;

    private Long toneladas;

    private Long numeroMedicamentos;

    private Envio envio;

    private Material material;
}
