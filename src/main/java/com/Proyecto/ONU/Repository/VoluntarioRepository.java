package com.Proyecto.ONU.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto.ONU.Repository.Entities.Voluntario;

public interface VoluntarioRepository extends JpaRepository<Voluntario, BigInteger> {

    //List<Voluntario> getVoluntarioByProfesionAndSede();

    String FIND_VOLUNTARIO_PROFESION_SEDE = "SELECT nombre_completo, profesion, nombre FROM voluntario JOIN persona ON id = voluntario.persona_id JOIN sede ON id = persona.sede_id ORDER BY sede_id AND profesion";

   // String INFORME_DE_VOLUNTARIOS = "";

    @Query(value = FIND_VOLUNTARIO_PROFESION_SEDE, nativeQuery = true)
    List<Voluntario> findVoluntarioByProfesionAndSede();

    //@Query(value = INFORME_DE_VOLUNTARIOS, nativeQuery = true)
    //List<Voluntario> InformeDeVoluntarios();

/* 
SELECT  */
}
