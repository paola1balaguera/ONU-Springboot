package com.Proyecto.ONU.Repository.Entities;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String nombreCompleto;
    private Date fechaNacimiento ;
    private String direccionVivienda;
    private String correoElectronico;
    private Long numero;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sede sedes;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Persona director;

}
