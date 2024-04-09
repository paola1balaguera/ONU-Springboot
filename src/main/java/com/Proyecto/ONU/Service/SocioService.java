package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.SocioDTO;

public interface SocioService {

    public SocioDTO save(SocioDTO socioDTO);

    public SocioDTO update(Long id, SocioDTO persona);

    void deleteById(Long id);

    List<SocioDTO> findAll();

    List<SocioDTO> findAllSocioByTipoCuota(Long ipoCuotaid);
    
    List<SocioDTO> InformeCuotaPorSocio();
}
