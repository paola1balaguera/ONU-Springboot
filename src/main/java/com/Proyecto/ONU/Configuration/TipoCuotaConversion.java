package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.Proyecto.ONU.Repository.Entities.TipoCuota;
import com.Proyecto.ONU.Repository.EntitiesDTO.TipoCuotaDTO;

@Configuration
public class TipoCuotaConversion {
    @Autowired
    private ModelMapper dbm;

    public TipoCuota convertirDTOATipoCuota(TipoCuotaDTO tipoCuotaDTO){
        return dbm.map(tipoCuotaDTO,TipoCuota.class);
    }
    
    public TipoCuotaDTO convertirTipoCuotaADto(TipoCuota tipoCuota){
        TipoCuotaDTO tipoCuotaDTO = dbm.map(tipoCuota, TipoCuotaDTO.class);

        tipoCuotaDTO.setId(tipoCuota.getId());
        tipoCuotaDTO.setNombre(tipoCuota.getNombre());

        return tipoCuotaDTO;
    }
}
