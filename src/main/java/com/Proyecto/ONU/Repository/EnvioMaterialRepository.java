package com.Proyecto.ONU.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.EnvioMaterial;

public interface EnvioMaterialRepository extends JpaRepository<EnvioMaterial,Long> {
    
}
