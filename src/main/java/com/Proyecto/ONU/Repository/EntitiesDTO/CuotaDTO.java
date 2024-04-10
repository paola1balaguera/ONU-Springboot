package com.Proyecto.ONU.Repository.EntitiesDTO;


import java.sql.Date;

import com.Proyecto.ONU.Repository.Entities.Socio;
import com.Proyecto.ONU.Repository.Entities.TipoCuota;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CuotaDTO {


    private Long id;

    @Pattern(regexp = "\\d+", message = "El valor debe ser numérico")
    @NotEmpty(message = "no puede estar vacio")
    private Long valor;

    @NotEmpty(message = "no puede estar vacio")
    private Date fechaPago;

    @NotEmpty(message = "no puede estar vacio")
    private TipoCuota tipoCuota;

    @NotEmpty(message = "no puede estar vacio")
    private Socio socio;
}
