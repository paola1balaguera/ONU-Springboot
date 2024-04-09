package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.SedeDTO;

public interface SedeService {


    public SedeDTO save(SedeDTO sedeDTO);

    public SedeDTO update(Long id, SedeDTO sedeDTO);

    void deleteById(Long id);

    List<SedeDTO> findAll();
}
