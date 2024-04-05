package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Proyecto.ONU.Repository.Entities.Ciudad;
import com.Proyecto.ONU.Repository.EntitiesDTO.CiudadDTO;


@Configuration
public class CiudadConversion {
    @Autowired
    private ModelMapper dbm;

    public Ciudad convertirDTOACiudad(CiudadDTO ciudadDTO){
        return dbm.map(ciudadDTO,Ciudad.class);
    }

    public CiudadDTO convertirCiudadADto(Ciudad ciudad){
        CiudadDTO ciudadDTO = dbm.map(ciudad, CiudadDTO.class);

        ciudadDTO.setId(ciudad.getId());
        ciudadDTO.setNombre(ciudad.getNombre());
        ciudadDTO.setSede(ciudad.getSede());


        return ciudadDTO;
    } 
        
}
