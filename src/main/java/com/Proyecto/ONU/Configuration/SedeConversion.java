package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Proyecto.ONU.Repository.Entities.Sede;
import com.Proyecto.ONU.Repository.EntitiesDTO.SedeDTO;


@Configuration
public class SedeConversion {
    @Autowired
    private ModelMapper dbm;

    public Sede convertirDTOASede(SedeDTO sedeDTO){
        return dbm.map(sedeDTO,Sede.class);
    }
    
    public SedeDTO convertirSedeADto(Sede sede){
        SedeDTO sedeDTO = dbm.map(sede, SedeDTO.class);

        sedeDTO.setId(sede.getId());
        sedeDTO.setDireccion(sede.getDireccion());
        sedeDTO.setDirector(sede.getDirector());
        //sedeDTO.setCiudad(sede.getCiudades());
        sedeDTO.setEnvios(sede.getEnvios());

        


        return sedeDTO;
    }
}
