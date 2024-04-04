package com.Proyecto.ONU.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.TipoCuota;

public interface TipoCuotaRepository extends JpaRepository<TipoCuota, BigInteger> {
    
}
