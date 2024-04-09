package com.Proyecto.ONU.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto.ONU.Repository.Entities.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Long>{

    String INFORME_ENVIO_AYUDA_HUMANITARIA = "SELECT v.id AS id_voluntario, v.tipo AS tipo_voluntario, v.disponibilidad AS disponibilidad, v.numero_trabajos, v.profesion,v.persona_id AS id_persona, r.direccion AS Destino, e.fecha_salida, e.codigo, refugio_id, COUNT(v.profesion) AS voluntarios_equipo, v.* FROM voluntario v JOIN envio_voluntario ev ON ev.voluntario_id = v.id JOIN envio e ON e.id = ev.envio_id JOIN refugio r ON r.id = e.refugio_id GROUP BY v.profesion,v.id, v.tipo, v.disponibilidad, v.numero_trabajos, v.profesion,v.persona_id, r.direccion, e.fecha_salida, e.codigo, refugio_id;";
    
    @Query(value = INFORME_ENVIO_AYUDA_HUMANITARIA, nativeQuery = true)
    List<Envio> informeEnvioAyudaHumanitaria();

}
