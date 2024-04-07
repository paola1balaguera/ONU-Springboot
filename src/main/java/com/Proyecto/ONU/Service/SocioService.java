package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.SocioDTO;

public interface SocioService {

    public SocioDTO save(SocioDTO socioDTO);

    public SocioDTO update(BigInteger id, SocioDTO persona);

    void deleteById(BigInteger id);

    List<SocioDTO> findAll();

    List<SocioDTO> findAllSocioByTipoCuota(BigInteger cuotaid);
}
