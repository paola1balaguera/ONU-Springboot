package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.Entities.Ciudad;
import com.Proyecto.ONU.Repository.Entities.Envio;
import com.Proyecto.ONU.Repository.Entities.Persona;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SedeDTO {
    @NotEmpty(message = "no puede estar vacio")
    private BigInteger id;

    @NotEmpty(message = "no puede estar vacio")
    private String direccion;

    @NotEmpty(message = "no puede estar vacio")
    private Persona director;

    @NotEmpty(message = "no puede estar vacio")
    private Ciudad ciudad;

    @NotEmpty(message = "no puede estar vacio")
    private List<Envio> envios;
}
