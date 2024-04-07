package com.Proyecto.ONU.Service;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.EntitiesDTO.UsuarioDTO;



public interface UsuarioService {

    public UsuarioDTO save(UsuarioDTO usuario);

    public UsuarioDTO update(BigInteger id, UsuarioDTO usuario);

    void deleteById(BigInteger id);

    List<UsuarioDTO> findAll();

}