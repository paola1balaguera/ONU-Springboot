package com.Proyecto.ONU.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Refugio;

public interface RefugioRepository extends JpaRepository<Refugio,BigInteger> {
    
}
