package com.Proyecto.ONU.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.Proyecto.ONU.Repository.Entities.Persona;
import com.Proyecto.ONU.Repository.EntitiesDTO.PersonaDTO;

@Configuration
public class PersonaConversion {
    
    @Autowired
    private ModelMapper dbm;

    public Persona convertirDTOAPersona(PersonaDTO personaDTO){
        return dbm.map(personaDTO,Persona.class);
    }

    public PersonaDTO convertirPersonaADto(Persona persona){
        PersonaDTO personaDTO = dbm.map(persona, PersonaDTO.class);

        personaDTO.setId(persona.getId());
        personaDTO.setNombreCompleto(persona.getNombreCompleto());
        personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
        personaDTO.setDireccionVivienda(persona.getDireccionVivienda());
        personaDTO.setCorreoElectronico(persona.getCorreoElectronico());
        personaDTO.setNumero(persona.getNumero());
        personaDTO.setSede(persona.getSede());

        return personaDTO;
    }
}
