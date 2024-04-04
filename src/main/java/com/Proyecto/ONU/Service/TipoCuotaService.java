package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.TipoCuotaDTO;

public interface TipoCuotaService {
    
    public TipoCuotaDTO save(TipoCuotaDTO tipoCuotaDTO);

    public TipoCuotaDTO update(BigInteger id, TipoCuotaDTO tipoCuotaDTO);

    void deleteById(BigInteger id);

    List<TipoCuotaDTO> findAll();
}
