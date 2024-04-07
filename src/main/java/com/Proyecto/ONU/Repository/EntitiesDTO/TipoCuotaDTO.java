package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TipoCuotaDTO {

    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;

    @NotNull(message = "no puede estar vacio")
    private Long valor;


}
