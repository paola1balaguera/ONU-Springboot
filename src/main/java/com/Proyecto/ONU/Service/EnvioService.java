package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioDTO;

public interface EnvioService {
    
    public EnvioDTO save(EnvioDTO envioDTO);

    public EnvioDTO update(Long id,EnvioDTO envioDTO );

    void deleteById(Long id);

    List<EnvioDTO> findAll();

    EnvioDTO findById(Long id);

    List<EnvioDTO> informeEnvioAyudaHumanitaria();

    
}
