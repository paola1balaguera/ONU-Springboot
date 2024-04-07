package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;
import java.sql.Date;

import com.Proyecto.ONU.Repository.Entities.Socio;
import com.Proyecto.ONU.Repository.Entities.TipoCuota;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CuotaDTO {


    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String cuentaBancaria;

    @NotEmpty(message = "no puede estar vacio")
    private Long valor;

    @NotEmpty(message = "no puede estar vacio")
    private Date fechaPago;

    @NotEmpty(message = "no puede estar vacio")
    private TipoCuota tipoCuota;

    @NotEmpty(message = "no puede estar vacio")
    private Socio socio;
}
