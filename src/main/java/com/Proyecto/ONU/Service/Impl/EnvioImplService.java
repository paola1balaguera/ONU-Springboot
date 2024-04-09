package com.Proyecto.ONU.Service.Impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.EnvioConversion;
import com.Proyecto.ONU.Repository.EnvioRepository;
import com.Proyecto.ONU.Repository.Entities.Envio;
import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioDTO;
import com.Proyecto.ONU.Service.EnvioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnvioImplService implements EnvioService {
    @Autowired
    private EnvioRepository envioRepository;
    private EnvioConversion envioConversion;

@Override
@Transactional
public EnvioDTO save(EnvioDTO envioDTO) {
    Envio envio = envioConversion.convertirDTOAEnvio(envioDTO);
    envioRepository.save(envio);
    return envioConversion.convertirEnvioADto(envio);
}

public EnvioDTO update(Long id, EnvioDTO envioDTO){
    Optional<Envio> envioCurrentOptional = envioRepository.findById(id);
    if(envioCurrentOptional.isPresent()){
        Envio envioCurrent = envioConversion.convertirDTOAEnvio(envioDTO);
        
        envioCurrent.setId(id);
        envioCurrent.setFechaSalida(envioDTO.getFechaSalida());
        envioCurrent.setCodigo(envioDTO.getCodigo());
        envioCurrent.setRefugio(envioDTO.getRefugio());
        envioCurrent.setSedes(envioDTO.getSedes());
        envioCurrent.setVoluntarios(envioDTO.getVoluntarios());

       envioRepository.save(envioCurrent);
        
        return envioConversion.convertirEnvioADto(envioCurrent);
    }
    return null;
}

@Override
public void deleteById(Long id){
    envioRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<EnvioDTO> findAll(){
    List<Envio> envios = (List<Envio>) envioRepository.findAll();
    return envios.stream()
                 .map(enviito -> envioConversion.convertirEnvioADto(enviito))
                 .toList();
    }

@Override
@Transactional(readOnly = true)
public EnvioDTO findById(Long id){
    Optional<Envio> envioCurrentOptional = envioRepository.findById(id);

    return envioConversion.convertirEnvioADto(envioCurrentOptional.get());

}

@Override
@Transactional(readOnly = true)
public List<EnvioDTO> informeEnvioAyudaHumanitaria(){
    List<Envio> envios = (List<Envio>) envioRepository.informeEnvioAyudaHumanitaria();
    return envios.stream()
                    .map(enviito -> envioConversion.convertirEnvioADto(enviito))
                    .toList();
}


}
