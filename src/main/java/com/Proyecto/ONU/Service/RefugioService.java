package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.RefugioDTO;

public interface RefugioService {
    
    public RefugioDTO save(RefugioDTO refugioDTO);

    public RefugioDTO update(BigInteger id, RefugioDTO refugioDTO);

    void deleteById(BigInteger id);

    List<RefugioDTO> findAll();
}
