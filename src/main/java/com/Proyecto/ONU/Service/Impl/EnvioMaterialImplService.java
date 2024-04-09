package com.Proyecto.ONU.Service.Impl;

import com.Proyecto.ONU.Service.EnvioMaterialService;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Proyecto.ONU.Configuration.EnvioMaterialConversion;
import com.Proyecto.ONU.Repository.EnvioMaterialRepository;
import com.Proyecto.ONU.Repository.Entities.EnvioMaterial;
import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioMaterialDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnvioMaterialImplService implements EnvioMaterialService{
    @Autowired
    private EnvioMaterialRepository envioMaterialRepository;
    private EnvioMaterialConversion envioMaterialConversion;

@Override
@Transactional
public EnvioMaterialDTO save(EnvioMaterialDTO envioMaterialDTO) {
    EnvioMaterial envioMaterial = envioMaterialConversion.convertirDTOAEnvioMaterial(envioMaterialDTO);
    envioMaterialRepository.save(envioMaterial);
    return envioMaterialConversion.convertirEnvioMaterialADto(envioMaterial);
}

public EnvioMaterialDTO update(BigInteger id, EnvioMaterialDTO envioMaterialDTO){
    Optional<EnvioMaterial> envioMaterialCurrentOptional = envioMaterialRepository.findById(id);
    if(envioMaterialCurrentOptional.isPresent()){
        EnvioMaterial envioMaterialCurrent = envioMaterialConversion.convertirDTOAEnvioMaterial(envioMaterialDTO);
        
        envioMaterialCurrent.setId(envioMaterialDTO.getId());
        envioMaterialCurrent.setEnvio(envioMaterialDTO.getEnvio());
        envioMaterialCurrent.setMaterial(envioMaterialDTO.getMaterial());
        envioMaterialCurrent.setNumeroMedicamentos(envioMaterialDTO.getNumeroMedicamentos());
        envioMaterialCurrent.setToneladas(envioMaterialDTO.getToneladas());

       envioMaterialRepository.save(envioMaterialCurrent);
        
        return envioMaterialConversion.convertirEnvioMaterialADto(envioMaterialCurrent);
    }
    return null;
}

@Override
public void deleteById(BigInteger id){
    envioMaterialRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<EnvioMaterialDTO> findAll(){
    List<EnvioMaterial> envioMateriales = (List<EnvioMaterial>) envioMaterialRepository.findAll();
    return envioMateriales.stream()
                 .map(enviito -> envioMaterialConversion.convertirEnvioMaterialADto(enviito))
                 .toList();
    }

@Override
@Transactional(readOnly = true)
public EnvioMaterialDTO findById(BigInteger id){
    Optional<EnvioMaterial> envioMaterialCurrentOptional = envioMaterialRepository.findById(id);

    return envioMaterialConversion.convertirEnvioMaterialADto(envioMaterialCurrentOptional.get());

}
}
