package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.VoluntarioDTO;

public interface VoluntarioService {

    public VoluntarioDTO save(VoluntarioDTO voluntarioDTO);

    public VoluntarioDTO update(BigInteger id, VoluntarioDTO voluntarioDTO);

    void deleteById(BigInteger id);

    List<VoluntarioDTO> findAll();
    
}
