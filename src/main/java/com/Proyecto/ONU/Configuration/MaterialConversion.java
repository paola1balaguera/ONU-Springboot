package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Proyecto.ONU.Repository.Entities.Material;
import com.Proyecto.ONU.Repository.EntitiesDTO.MaterialDTO;

@Configuration
public class MaterialConversion {
    @Autowired
    private ModelMapper dbm;

    public Material convertirDTOAMaterial(MaterialDTO materialDTO){
        return dbm.map(materialDTO,Material.class);
    }
    
    public MaterialDTO convertirMaterialADto(Material material){
        MaterialDTO materialDTO = dbm.map(material, MaterialDTO.class);

        materialDTO.setId(material.getId());
        materialDTO.setNombre(material.getNombre());
        materialDTO.setTipo(material.getTipo());

        return materialDTO;
    }
}
