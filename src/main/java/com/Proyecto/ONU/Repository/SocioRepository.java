package com.Proyecto.ONU.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Proyecto.ONU.Repository.Entities.Cuota;
import com.Proyecto.ONU.Repository.Entities.Socio;

public interface SocioRepository extends JpaRepository<Socio, BigInteger> {
    List<Socio> findAllSocioByCuota(Cuota cuota);

}
