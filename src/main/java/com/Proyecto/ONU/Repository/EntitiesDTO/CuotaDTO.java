package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;
import com.Proyecto.ONU.Repository.Entities.TipoCuota;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CuotaDTO {


    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;

    @NotEmpty(message = "no puede estar vacio")
    private Long valor;

    @NotEmpty(message = "no puede estar vacio")
    private boolean estado;

    @NotEmpty(message = "no puede estar vacio")
    private TipoCuota tipoCuota;
}
