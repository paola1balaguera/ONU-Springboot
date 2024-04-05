package com.Proyecto.ONU.Repository.Entities;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cuota")
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "cuentaBancaria", nullable = true)
    private String cuentaBancaria;

    @Column(name = "valor", nullable = true)
    private Long valor;

    @Column(name = "fechaPago", nullable = true)
    private Date fechaPago;

    @OneToOne
    private TipoCuota tipoCuota;
}
