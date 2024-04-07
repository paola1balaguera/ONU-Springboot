package com.Proyecto.ONU.Repository.EntitiesDTO;

import java.math.BigInteger;
import java.util.List;

import com.Proyecto.ONU.Repository.Entities.Ciudad;
import com.Proyecto.ONU.Repository.Entities.Envio;
import lombok.Data;

@Data
public class SedeDTO {

    private BigInteger id;

    private String direccion;

    private String director;

    private List<Envio> envios;

    private Ciudad ciudad;

}
