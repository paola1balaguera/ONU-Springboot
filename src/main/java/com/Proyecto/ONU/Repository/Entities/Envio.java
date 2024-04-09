package com.Proyecto.ONU.Repository.Entities;


import java.sql.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "envio")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fechaSalida")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaSalida; 

    @Column(name="codigo", unique = true)
    private String codigo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Refugio refugio;

    @ManyToMany(mappedBy = "envios")
    private List<Sede> sedes;

    @ManyToMany(mappedBy = "envio_voluntario")
    private List<Voluntario> voluntarios;
}
