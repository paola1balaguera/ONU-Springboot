package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ONU.Repository.Entities.Ciudad;
import com.Proyecto.ONU.Repository.EntitiesDTO.CiudadDTO;



@Component
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



        return ciudadDTO;
    } 
        
}
