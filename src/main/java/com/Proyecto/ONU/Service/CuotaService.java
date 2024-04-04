package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.CuotaDTO;

public interface CuotaService {

    public CuotaDTO save(CuotaDTO cuotaDTO );

    public CuotaDTO  update(BigInteger id, CuotaDTO cuotaDTO );

    void deleteById(BigInteger id);

    List<CuotaDTO > findAll();
    
}
