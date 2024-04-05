package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.SedeDTO;

public interface SedeService {


    public SedeDTO save(SedeDTO sedeDTO);

    public SedeDTO update(BigInteger id, SedeDTO sedeDTO);

    void deleteById(BigInteger id);

    List<SedeDTO> findAll();
}
