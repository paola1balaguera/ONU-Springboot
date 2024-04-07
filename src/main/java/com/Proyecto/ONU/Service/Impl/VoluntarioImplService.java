package com.Proyecto.ONU.Service.Impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.VoluntarioConversion;
import com.Proyecto.ONU.Repository.VoluntarioRepository;
import com.Proyecto.ONU.Repository.Entities.Voluntario;
import com.Proyecto.ONU.Repository.EntitiesDTO.VoluntarioDTO;
import com.Proyecto.ONU.Service.VoluntarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoluntarioImplService implements VoluntarioService {
    
    @Autowired
    private VoluntarioRepository voluntarioRepository;
    private VoluntarioConversion voluntarioConversion;

@Override
@Transactional
public VoluntarioDTO save(VoluntarioDTO voluntarioDTO) {
    Voluntario voluntario = voluntarioConversion.convertirDTOAVoluntario(voluntarioDTO);
    voluntarioRepository.save(voluntario);
    return voluntarioConversion.convertirVoluntarioADto(voluntario);
}

public VoluntarioDTO update(BigInteger id, VoluntarioDTO voluntarioDTO){
    Optional<Voluntario> voluntarioOptional = voluntarioRepository.findById(id);
    if(voluntarioOptional.isPresent()){

        Voluntario voluntarioCurrent = voluntarioConversion.convertirDTOAVoluntario(voluntarioDTO);

        voluntarioCurrent.setId(id);
        voluntarioCurrent.setTipo(voluntarioDTO.getTipo());
        voluntarioCurrent.setDisponibilidad(voluntarioDTO.getDisponibilidad());
        voluntarioCurrent.setDisponibilidad(voluntarioDTO.getDisponibilidad());
        voluntarioCurrent.setNumeroTrabajos(voluntarioDTO.getNumeroTrabajos());
        voluntarioCurrent.setProfesion(voluntarioDTO.getProfesion());
        voluntarioCurrent.setPersona(voluntarioDTO.getPersona());

       voluntarioRepository.save(voluntarioCurrent);

        return voluntarioConversion.convertirVoluntarioADto(voluntarioCurrent);
    }
    return null;
}

@Override
public void deleteById(BigInteger id){
    voluntarioRepository.deleteById(id);
}


@Override
@Transactional(readOnly = true)
public List<VoluntarioDTO> findAll(){
    List<Voluntario> voluntarios = (List<Voluntario>) voluntarioRepository.findAll();
    return voluntarios.stream()
                 .map(voluntariito -> voluntarioConversion.convertirVoluntarioADto(voluntariito))
                 .toList();
    }

}
