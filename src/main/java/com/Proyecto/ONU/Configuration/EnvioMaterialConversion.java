package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ONU.Repository.Entities.EnvioMaterial;
import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioMaterialDTO;

@Component
public class EnvioMaterialConversion {
    @Autowired
    private ModelMapper dbm;

    public EnvioMaterial convertirDTOAEnvioMaterial(EnvioMaterialDTO envioMaterialDTO){
        return dbm.map(envioMaterialDTO,EnvioMaterial.class);
    }

    public EnvioMaterialDTO convertirEnvioMaterialADto(EnvioMaterial envioMaterial){
        EnvioMaterialDTO envioMaterialDTO = dbm.map(envioMaterial, EnvioMaterialDTO.class);

        envioMaterialDTO.setId(envioMaterial.getId());
        envioMaterialDTO.setToneladas(envioMaterial.getToneladas());
        envioMaterialDTO.setNumeroMedicamentos(envioMaterial.getNumeroMedicamentos());
        envioMaterialDTO.setEnvio(envioMaterial.getEnvio());
        envioMaterialDTO.setMaterial(envioMaterial.getMaterial());


        
        return envioMaterialDTO;
    } 
}
