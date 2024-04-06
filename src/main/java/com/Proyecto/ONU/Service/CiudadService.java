package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.CiudadDTO;


public interface CiudadService {

    public CiudadDTO save(CiudadDTO ciudadDTO);

    public CiudadDTO update(BigInteger id, CiudadDTO ciudadDTO );

    void deleteById(BigInteger id);

    List<CiudadDTO> findAll();
}
