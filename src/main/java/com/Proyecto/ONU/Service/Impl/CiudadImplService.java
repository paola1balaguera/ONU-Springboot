package com.Proyecto.ONU.Service.Impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.CiudadConversion;
import com.Proyecto.ONU.Exceptions.NombreInvalidoException;
import com.Proyecto.ONU.Exceptions.NotFoundElementsException;
import com.Proyecto.ONU.Repository.CiudadRepository;
import com.Proyecto.ONU.Repository.Entities.Ciudad;
import com.Proyecto.ONU.Repository.EntitiesDTO.CiudadDTO;
import com.Proyecto.ONU.Service.CiudadService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CiudadImplService implements CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;
    private CiudadConversion ciudadConversion;

    @Override
    @Transactional
    public CiudadDTO save(CiudadDTO ciudadDTO) {
        String nombreCiudad = ciudadDTO.getNombre();
        if (!nombreCiudad.matches("[a-zA-Z]+")) {
            throw new NombreInvalidoException("El nombre de la ciudad solo debe contener letras");
        }
    
        Ciudad ciudad = ciudadConversion.convertirDTOACiudad(ciudadDTO);
        ciudadRepository.save(ciudad);
        return ciudadConversion.convertirCiudadADto(ciudad);
    }

public CiudadDTO update(Long id, CiudadDTO ciudadDTO){
    Optional<Ciudad> ciudadCurrentOptional = ciudadRepository.findById(id);
    if(ciudadCurrentOptional.isPresent()){
        Ciudad ciudadCurrent = ciudadConversion.convertirDTOACiudad(ciudadDTO);

        ciudadCurrent.setId(id);
        ciudadCurrent.setNombre(ciudadDTO.getNombre());

        ciudadRepository.save(ciudadCurrent);
        return ciudadConversion.convertirCiudadADto(ciudadCurrent);
    }
    return null;
}

@Override
public void deleteById(Long id){
    ciudadRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<CiudadDTO> findAll() {
    List<Ciudad> ciudades = (List<Ciudad>) ciudadRepository.findAll();
    if (ciudades.isEmpty()) {
        throw new NotFoundElementsException("No se encontraron ciudades");
    }
    return ciudades.stream()
                   .map(ciudad -> ciudadConversion.convertirCiudadADto(ciudad))
                   .toList();
}

}
