package com.Proyecto.ONU.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.ONU.Repository.Entities.Material;

public interface MaterialRepository extends JpaRepository<Material,BigInteger>{


}