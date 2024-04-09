package com.Proyecto.ONU.Repository.EntitiesDTO;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TipoCuotaDTO {

    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;

    @NotNull(message = "no puede estar vacio")
    private Long valor;


}
