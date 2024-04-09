package com.Proyecto.ONU.Repository.EntitiesDTO;


import java.util.List;

import com.Proyecto.ONU.Repository.Entities.Ciudad;
import com.Proyecto.ONU.Repository.Entities.Envio;
import lombok.Data;

@Data
public class SedeDTO {

    private Long id;

    private String direccion;

    private String director;

    private List<Envio> envios;

    private Ciudad ciudad;

}
