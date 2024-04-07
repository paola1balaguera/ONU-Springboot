package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import com.Proyecto.ONU.Repository.Entities.Refugio;
import com.Proyecto.ONU.Repository.Entities.Sede;
import com.Proyecto.ONU.Repository.Entities.Voluntario;

import lombok.Data;

@Data
public class EnvioDTO {
    private BigInteger id;

    private Date fechaSalida; 

    private String codigo;

    private Refugio refugio;

    private List<Sede> sedes;

    private List<Voluntario> voluntarios;
}
