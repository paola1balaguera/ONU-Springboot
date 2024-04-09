package com.Proyecto.ONU.Service;


import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.UsuarioDTO;



public interface UsuarioService {

    public UsuarioDTO save(UsuarioDTO usuario);

    public UsuarioDTO update(Long id, UsuarioDTO usuario);

    void deleteById(Long id);

    List<UsuarioDTO> findAll();

}