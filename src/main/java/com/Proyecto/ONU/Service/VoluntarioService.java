package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.VoluntarioDTO;

public interface VoluntarioService {

    public VoluntarioDTO save(VoluntarioDTO voluntarioDTO);

    public VoluntarioDTO update(Long id, VoluntarioDTO voluntarioDTO);

    void deleteById(Long id);

    List<VoluntarioDTO> findAll();

    List<VoluntarioDTO> listarVoluntarioProfesionSede();
    
}
