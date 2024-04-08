package com.Proyecto.ONU.Configuration;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ONU.Repository.Entities.Envio;
import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioDTO;

@Component
public class EnvioConversion {
    @Autowired
    private ModelMapper dbm;

    public Envio convertirDTOAEnvio(EnvioDTO envioDTO){
        return dbm.map(envioDTO,Envio.class);
    }

    public EnvioDTO convertirEnvioADto(Envio enviito){
        EnvioDTO envioDTO = dbm.map(enviito, EnvioDTO.class);

        envioDTO.setId(enviito.getId());
        envioDTO.setFechaSalida(enviito.getFechaSalida());
        envioDTO.setCodigo(enviito.getCodigo());
        envioDTO.setRefugio(enviito.getRefugio());
        envioDTO.setSedes(enviito.getSedes());
        envioDTO.setVoluntarios(enviito.getVoluntarios());

        
        return envioDTO;
    } 
}
