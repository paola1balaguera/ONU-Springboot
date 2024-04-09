package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.RefugioDTO;

public interface RefugioService {
    
    public RefugioDTO save(RefugioDTO refugioDTO);

    public RefugioDTO update(Long id, RefugioDTO refugioDTO);

    void deleteById(Long id);

    List<RefugioDTO> findAll();
}
