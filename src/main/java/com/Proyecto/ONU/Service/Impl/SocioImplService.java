package com.Proyecto.ONU.Service.Impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.SocioConversion;
import com.Proyecto.ONU.Repository.CuotaRepository;
import com.Proyecto.ONU.Repository.SocioRepository;
import com.Proyecto.ONU.Repository.Entities.Cuota;
import com.Proyecto.ONU.Repository.Entities.Socio;
import com.Proyecto.ONU.Repository.EntitiesDTO.SocioDTO;
import com.Proyecto.ONU.Service.SocioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SocioImplService implements SocioService {
    @Autowired
    private SocioRepository socioRepository;
    private SocioConversion socioConversion;
    private CuotaRepository cuotaRepository;

@Override
@Transactional
public SocioDTO save(SocioDTO socioDTO) {
    Socio socio = socioConversion.convertirDTOASocio(socioDTO);
    socioRepository.save(socio);
    return socioConversion.convertirSocioADto(socio);
}

public SocioDTO update(BigInteger id, SocioDTO socioDTO){
    Optional<Socio> socioCurrentOptional = socioRepository.findById(id);
    if(socioCurrentOptional.isPresent()){
        Socio socioCurrent = socioConversion.convertirDTOASocio(socioDTO);
        socioCurrent.setId(id);
        socioCurrent.setPersona(socioDTO.getPersona());
        socioCurrent.setCuota(socioDTO.getCuota());
        socioCurrent.setSede(socioDTO.getSede());

        socioRepository.save(socioCurrent);
        
        return socioConversion.convertirSocioADto(socioCurrent);
    }
    return null;
}

@Override
public void deleteById(BigInteger id){
    socioRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<SocioDTO> findAll(){
    List<Socio> socios = (List<Socio>) socioRepository.findAll();
    return socios.stream()
                 .map(sociito -> socioConversion.convertirSocioADto(sociito))
                 .toList();
    }

@Override
@Transactional(readOnly = true)
public List<SocioDTO> findAllSocioByTipoCuota(BigInteger cuotaid){
    Optional<Cuota> cuota = cuotaRepository.findById(cuotaid);
    List<Socio> socios = (List<Socio>) socioRepository.findAllSocioByCuota(cuota.get());
    return socios.stream().map(socio -> socioConversion.convertirSocioADto(socio)).toList();
    


} 




}
