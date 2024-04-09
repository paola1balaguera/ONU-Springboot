package com.Proyecto.ONU.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto.ONU.Repository.Entities.Voluntario;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {

    String LISTAR_VOLUNTARIO_PROFESION_SEDE = "SELECT v.id as id, v.disponibilidad, v.numero_trabajos, v.persona_id, v.tipo, p.id as personaId, s.id as sedeid, p.nombre_completo, v.profesion, s.direccion AS sede FROM voluntario v JOIN persona p ON p.id = v.persona_id JOIN sede s ON s.id = p.sede_id ORDER BY s.direccion ASC, v.profesion, p.nombre_completo;";


    @Query(value = LISTAR_VOLUNTARIO_PROFESION_SEDE, nativeQuery = true)
    List<Voluntario> listarVoluntarioProfesionSede();

    



}
