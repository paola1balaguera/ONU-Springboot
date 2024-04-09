package com.Proyecto.ONU.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
