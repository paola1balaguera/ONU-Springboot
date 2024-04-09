package com.Proyecto.ONU.Repository.Entities;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "envioMaterial")
public class EnvioMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "toneladas", nullable = true)
    private Long toneladas;

    @Column(name = "numeroMedicamentos", nullable = true)
    private Long numeroMedicamentos;

    @ManyToOne
    @JoinColumn(name = "envio_id")
    private Envio envio;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;


}
