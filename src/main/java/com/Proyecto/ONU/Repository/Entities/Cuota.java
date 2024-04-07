package com.Proyecto.ONU.Repository.Entities;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(name = "valor", nullable = true)
    private Long valor;

    @Column(name = "fechaPago", nullable = true)
    private Date fechaPago;

    @ManyToOne(fetch = FetchType.EAGER)
    private TipoCuota tipoCuota;

    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;













/*     @ManyToOne(mappedBy = "cuota")
    private List<TipoCuota> tipoCuotas; */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    private Persona persona;



}
