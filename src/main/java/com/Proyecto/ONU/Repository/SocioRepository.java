package com.Proyecto.ONU.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Socio;
import com.Proyecto.ONU.Repository.Entities.TipoCuota;

public interface SocioRepository extends JpaRepository<Socio, BigInteger> {
    List<Socio> findAllSocioByTipoCuota(TipoCuota tipoCuota);

}
