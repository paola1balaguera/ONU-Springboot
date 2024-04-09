package com.Proyecto.ONU.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto.ONU.Repository.Entities.Socio;
import com.Proyecto.ONU.Repository.Entities.TipoCuota;

public interface SocioRepository extends JpaRepository<Socio, Long> {
    List<Socio> findAllSocioByTipoCuota(TipoCuota tipoCuota);

    String INFORME_CUOTA_SOCIO = "SELECT s.id, p.nombre_completo, p.fecha_nacimiento, p.direccion_vivienda, p.correo_electronico, p.numero_telefono, s.cuenta_bancaria, c.fecha_pago, tc.nombre AS tipo_cuota, s.persona_id, s.tipo_cuota_id FROM persona p JOIN socio s ON p.id = s.persona_id JOIN tipo_cuota tc ON s.tipo_cuota_id = tc.id JOIN cuota c ON s.id = c.socio_id";

    @Query(value = INFORME_CUOTA_SOCIO, nativeQuery = true)
    List<Socio> InformeCuotaPorSocio();

}
