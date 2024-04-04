package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.Proyecto.ONU.Repository.Entities.Socio;
import com.Proyecto.ONU.Repository.EntitiesDTO.SocioDTO;

@Configuration
public class SocioConversion {

    @Autowired
    private ModelMapper dbm;

    public Socio convertirDTOASocio(SocioDTO socioDTO){
        return dbm.map(socioDTO,Socio.class);
    }
    
    public SocioDTO convertirSocioADto(Socio socio){
        SocioDTO socioDTO = dbm.map(socio, SocioDTO.class);

        socioDTO.setId(socio.getId());
        socioDTO.setCuentaBancaria(socio.getCuentaBancaria());
        socioDTO.setPersona(socio.getPersona());
        socioDTO.setCuota(socio.getCuota());

        return socioDTO;
    }
}
