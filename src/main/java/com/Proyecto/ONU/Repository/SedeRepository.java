package com.Proyecto.ONU.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Sede;

public interface SedeRepository extends JpaRepository<Sede, Long> {
    
}
