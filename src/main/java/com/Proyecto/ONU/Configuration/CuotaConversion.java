package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Proyecto.ONU.Repository.Entities.Cuota;
import com.Proyecto.ONU.Repository.EntitiesDTO.CuotaDTO;

@Configuration
public class CuotaConversion {
    
    @Autowired
    private ModelMapper dbm;

    public Cuota convertirDTOACuota(CuotaDTO cuotaDTO){
        return dbm.map(cuotaDTO,Cuota.class);
    }

    public CuotaDTO convertirCuotaADto(Cuota cuota){
        CuotaDTO cuotaDTO = dbm.map(cuota, CuotaDTO.class);


        cuotaDTO.setId(cuota.getId());
        cuotaDTO.setNombre(cuota.getNombre());
        cuotaDTO.setValor(cuota.getValor());
        //cuotaDTO.setEstado(cuota.getEstado());
        cuotaDTO.setTipoCuota(cuota.getTipoCuota());

        return cuotaDTO;
    }


}
