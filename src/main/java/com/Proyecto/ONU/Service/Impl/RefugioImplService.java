package com.Proyecto.ONU.Service.Impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.RefugioConversion;
import com.Proyecto.ONU.Repository.RefugioRepository;
import com.Proyecto.ONU.Repository.Entities.Refugio;
import com.Proyecto.ONU.Repository.EntitiesDTO.RefugioDTO;
import com.Proyecto.ONU.Service.RefugioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RefugioImplService implements RefugioService{
    @Autowired
    private RefugioRepository refugioRepository;
    private RefugioConversion refugioConversion;

@Override
@Transactional
public RefugioDTO save(RefugioDTO refugioDTO) {
    Refugio refugio = refugioConversion.convertirDTORefugio(refugioDTO);
    refugioRepository.save(refugio);
    return refugioConversion.convertirRefugioADto(refugio);
}

public RefugioDTO update(Long id, RefugioDTO refugioDTO){
    Optional<Refugio> refugioCurrentOptional = refugioRepository.findById(id);
    if(refugioCurrentOptional.isPresent()){
       Refugio refugioCurrent = refugioConversion.convertirDTORefugio(refugioDTO);
  
       refugioCurrent.setId(id);
       refugioCurrent.setNombre(refugioDTO.getNombre());
       refugioCurrent.setDireccion(refugioDTO.getDireccion());
       refugioCurrent.setCiudad(refugioDTO.getCiudad());

       refugioRepository.save(refugioCurrent);
        
        return refugioConversion.convertirRefugioADto(refugioCurrent);
    }
    return null;
}

@Override
public void deleteById(Long id){
    refugioRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<RefugioDTO> findAll(){
    List<Refugio> refugios = (List<Refugio>) refugioRepository.findAll();
    return refugios.stream()
                 .map(refugiito -> refugioConversion.convertirRefugioADto(refugiito))
                 .toList();
    }


}

