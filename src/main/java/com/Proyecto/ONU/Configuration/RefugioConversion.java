package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ONU.Repository.Entities.Refugio;
import com.Proyecto.ONU.Repository.EntitiesDTO.RefugioDTO;

@Component
public class RefugioConversion {
    @Autowired
    private ModelMapper dbm;

    public Refugio convertirDTORefugio(RefugioDTO refugioDTO){
        return dbm.map(refugioDTO,Refugio.class);
    }

    public RefugioDTO convertirRefugioADto(Refugio refugio){
        RefugioDTO refugioDTO = dbm.map(refugio, RefugioDTO.class);

        refugioDTO.setId(refugio.getId());
        refugioDTO.setNombre(refugio.getNombre());
        refugioDTO.setDireccion(refugio.getDireccion());
        refugioDTO.setCiudad(refugio.getCiudad());

        
        return refugioDTO;
    } 
}
