package com.Proyecto.ONU.Repository.Entities;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voluntario")
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    public enum tipoVoluntario{
        sanitario,
        administrativo
    }

    @Column(name = "tipoVoluntario", nullable = false)
    private tipoVoluntario tipo; 

    @Column(name = "disponibilidad" , nullable = false)
    private Boolean disponibilidad;

    @Column(name = "numeroTrabajos" , nullable = false)
    private Long numeroTrabajos;

    @Column(name = "profesion" , nullable = false)
    private String profesion;


    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    @ManyToMany
    @JoinTable(
        name = "envio_voluntario",
        joinColumns = @JoinColumn(name = "voluntario_id"),
        inverseJoinColumns = @JoinColumn(name = "envio_id"))
    private List<Envio> envio_voluntario; 

}
