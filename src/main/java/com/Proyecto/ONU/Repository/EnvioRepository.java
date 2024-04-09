package com.Proyecto.ONU.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Envio;

public interface EnvioRepository extends JpaRepository<Envio, BigInteger>{
    
   
}
