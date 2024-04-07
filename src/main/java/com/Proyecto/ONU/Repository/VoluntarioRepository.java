package com.Proyecto.ONU.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Voluntario;

public interface VoluntarioRepository extends JpaRepository<Voluntario, BigInteger> {
    
}
