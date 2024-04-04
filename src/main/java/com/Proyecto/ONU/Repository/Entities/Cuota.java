package com.Proyecto.ONU.Repository.Entities;

import java.math.BigInteger;

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

    @Column(name = "nombre", nullable = true)
    private String nombre;

    @Column(name = "valor", nullable = true)
    private Long valor;

    @Column(name = "estado", nullable = true)
    private boolean estado;

    @OneToOne
    private TipoCuota tipoCuota;
}
