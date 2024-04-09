package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioMaterialDTO;

public interface EnvioMaterialService {

    public EnvioMaterialDTO save(EnvioMaterialDTO envioMaterialDTO);

    public EnvioMaterialDTO update(BigInteger id, EnvioMaterialDTO envioMaterialDTO);

    void deleteById(BigInteger id);

    List<EnvioMaterialDTO> findAll();

    EnvioMaterialDTO findById(BigInteger id);
}
