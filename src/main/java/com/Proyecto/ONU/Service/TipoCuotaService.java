package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.TipoCuotaDTO;

public interface TipoCuotaService {
    
    public TipoCuotaDTO save(TipoCuotaDTO tipoCuotaDTO);

    public TipoCuotaDTO update(Long id, TipoCuotaDTO tipoCuotaDTO);

    void deleteById(Long id);

    List<TipoCuotaDTO> findAll();
}
