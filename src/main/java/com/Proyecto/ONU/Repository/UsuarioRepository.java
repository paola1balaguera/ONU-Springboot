package com.Proyecto.ONU.Repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger>{
    Optional<Usuario> findByEmail(String email);
}
