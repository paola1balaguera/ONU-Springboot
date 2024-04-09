package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioMaterialDTO;

public interface EnvioMaterialService {

    public EnvioMaterialDTO save(EnvioMaterialDTO envioMaterialDTO);

    public EnvioMaterialDTO update(Long id, EnvioMaterialDTO envioMaterialDTO);

    void deleteById(Long id);

    List<EnvioMaterialDTO> findAll();

    EnvioMaterialDTO findById(Long id);
}
