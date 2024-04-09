package com.Proyecto.ONU.Service.Impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.PersonaConversion;
import com.Proyecto.ONU.Repository.PersonaRepository;
import com.Proyecto.ONU.Repository.Entities.Persona;
import com.Proyecto.ONU.Repository.EntitiesDTO.PersonaDTO;
import com.Proyecto.ONU.Service.PersonaService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class PersonaImplService implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;
    private PersonaConversion personaConversion;

@Override
@Transactional
public PersonaDTO save(PersonaDTO personaDTO) {
    Persona persona = personaConversion.convertirDTOAPersona(personaDTO);
    personaRepository.save(persona);
    return personaConversion.convertirPersonaADto(persona);
}

public PersonaDTO update(Long id, PersonaDTO personaDTO){
    Optional<Persona> personaCurrentOptional = personaRepository.findById(id);
    if(personaCurrentOptional.isPresent()){
        Persona personaCurrent = personaConversion.convertirDTOAPersona(personaDTO);

        personaCurrent.setId(id);
        personaCurrent.setNombreCompleto(personaDTO.getNombreCompleto());
        personaCurrent.setFechaNacimiento(personaDTO.getFechaNacimiento());
        personaCurrent.setNumeroTelefono(personaDTO.getNumeroTelefono());
        personaCurrent.setCorreoElectronico(personaDTO.getCorreoElectronico());
        personaCurrent.setDireccionVivienda(personaDTO.getDireccionVivienda());
        personaCurrent.setSede(personaDTO.getSede());

        personaRepository.save(personaCurrent);
        return personaConversion.convertirPersonaADto(personaCurrent);
    }
    return null;
}

@Override
public void deleteById(Long id){
    personaRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<PersonaDTO> findAll(){
    List<Persona> personas = (List<Persona>) personaRepository.findAll();
    return personas.stream()
                   .map(personita -> personaConversion.convertirPersonaADto(personita))
                   .toList();
}

}
