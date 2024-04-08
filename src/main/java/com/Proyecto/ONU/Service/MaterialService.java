package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.MaterialDTO;

public interface MaterialService {

    public MaterialDTO save(MaterialDTO materialDTO);

    public MaterialDTO  update(BigInteger id, MaterialDTO materialDTO);

    void deleteById(BigInteger id);

    List<MaterialDTO> findAll();
}
