package com.Proyecto.ONU.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Cuota;

public interface CuotaRepository extends JpaRepository<Cuota, Long>{
    
}
