package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.PersonaDTO;

public interface PersonaService {
    
    public PersonaDTO save(PersonaDTO personaDTO);

    public PersonaDTO update(BigInteger id, PersonaDTO personaDTO);

    void deleteById(BigInteger id);

    List<PersonaDTO> findAll();
    
}
