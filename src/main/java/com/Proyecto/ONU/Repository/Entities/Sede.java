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
@Table(name = "sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "direccion" , nullable = false)
    private String direccion;


    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona director;

    @OneToOne
    @JoinColumn(name = "ciudad_id", referencedColumnName = "id")
    private Ciudad ciudad;


    @ManyToMany
    @JoinTable(
        name = "envio_sede",
        joinColumns = @JoinColumn(name = "sede_id"),
        inverseJoinColumns = @JoinColumn(name = "envio_id"))
    private List<Envio> envios;

}
