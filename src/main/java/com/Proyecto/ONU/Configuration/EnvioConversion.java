package com.Proyecto.ONU.Configuration;

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

    public EnvioDTO convertirEnvioADto(Envio envio){
        EnvioDTO envioDTO = dbm.map(envio, EnvioDTO.class);

        envioDTO.setId(envio.getId());
        envioDTO.setFechaSalida(envio.getFechaSalida());
        envioDTO.setCodigo(envio.getCodigo());
        envioDTO.setRefugio(envio.getRefugio());
        envioDTO.setSedes(envio.getSedes());
        envioDTO.setVoluntarios(envio.getVoluntarios());

        
        return envioDTO;
    } 
}
