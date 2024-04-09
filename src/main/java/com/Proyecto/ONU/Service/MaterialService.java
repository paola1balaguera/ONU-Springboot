package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.MaterialDTO;

public interface MaterialService {

    public MaterialDTO save(MaterialDTO materialDTO);

    public MaterialDTO  update(Long id, MaterialDTO materialDTO);

    void deleteById(Long id);

    List<MaterialDTO> findAll();
}
