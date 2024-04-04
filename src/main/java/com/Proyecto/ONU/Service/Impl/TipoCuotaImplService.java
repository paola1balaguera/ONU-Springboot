package com.Proyecto.ONU.Service.Impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.TipoCuotaConversion;
import com.Proyecto.ONU.Repository.TipoCuotaRepository;
import com.Proyecto.ONU.Repository.Entities.TipoCuota;
import com.Proyecto.ONU.Repository.EntitiesDTO.TipoCuotaDTO;
import com.Proyecto.ONU.Service.TipoCuotaService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TipoCuotaImplService implements TipoCuotaService {
    @Autowired
    private TipoCuotaRepository tipoCuotaRepository;
    private TipoCuotaConversion tipoCuotaConversion;

@Override
@Transactional
public TipoCuotaDTO save(TipoCuotaDTO tipoCuotaDTO) {
    TipoCuota tipoCuota = tipoCuotaConversion.convertirDTOATipoCuota(tipoCuotaDTO);
    tipoCuotaRepository.save(tipoCuota);
    return tipoCuotaConversion.convertirTipoCuotaADto(tipoCuota);
}

public TipoCuotaDTO update(BigInteger id, TipoCuotaDTO tipoCuotaDTO){
    Optional<TipoCuota> tipoCuotaOptional = tipoCuotaRepository.findById(id);
    if(tipoCuotaOptional.isPresent()){

        TipoCuota tipoCuotaCurrent = tipoCuotaConversion.convertirDTOATipoCuota(tipoCuotaDTO);

        tipoCuotaCurrent.setId(id);
        tipoCuotaCurrent.setNombre(tipoCuotaDTO.getNombre());

        tipoCuotaRepository.save(tipoCuotaCurrent);

        return tipoCuotaConversion.convertirTipoCuotaADto(tipoCuotaCurrent);
    }
    return null;
}

@Override
public void deleteById(BigInteger id){
    tipoCuotaRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<TipoCuotaDTO> findAll(){
    List<TipoCuota> tipoCuotas = (List<TipoCuota>) tipoCuotaRepository.findAll();
    return tipoCuotas.stream()
                     .map(tipoCuota -> tipoCuotaConversion.convertirTipoCuotaADto(tipoCuota))
                     .collect(Collectors.toList());
}

}
