package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.CiudadDTO;


public interface CiudadService {

    public CiudadDTO save(CiudadDTO ciudadDTO);

    public CiudadDTO update(Long id, CiudadDTO ciudadDTO );

    void deleteById(Long id);

    List<CiudadDTO> findAll();
}
