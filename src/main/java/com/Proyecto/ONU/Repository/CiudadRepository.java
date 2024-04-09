package com.Proyecto.ONU.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    
}
