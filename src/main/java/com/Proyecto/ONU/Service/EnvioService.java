package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioDTO;

public interface EnvioService {
    
    public EnvioDTO save(EnvioDTO envioDTO);

    public EnvioDTO update(BigInteger id,EnvioDTO envioDTO );

    void deleteById(BigInteger id);

    List<EnvioDTO> findAll();
}
