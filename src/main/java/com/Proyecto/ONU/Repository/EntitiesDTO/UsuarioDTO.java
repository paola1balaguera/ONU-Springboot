package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.Entities.Role;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {

    private BigInteger id;
    @NotNull(message = "no puede estar vacio")
    private Long cedula;
    private String email;
    private List<Role> roles;
    
}
