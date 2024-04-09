package com.Proyecto.ONU.Repository.Entities;


import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private Long id;

    @Column(name = "direccion" , nullable = false)
    private String direccion;

    private String director;

    @ManyToMany
    @JoinTable(
        name = "envio_sede",
        joinColumns = @JoinColumn(name = "sede_id"),
        inverseJoinColumns = @JoinColumn(name = "envio_id"))
    private List<Envio> envios;


    @ManyToOne(fetch = FetchType.EAGER)
    private Ciudad ciudad;

}
