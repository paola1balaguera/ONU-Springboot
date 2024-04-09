package com.Proyecto.ONU.Repository.Entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum tipoMaterial {
        alimentos,
        medicamentos
    }
    @Column(name = "tipo", nullable = false)
    private tipoMaterial tipo; 

    @Column(name = "nombre" , nullable = false)
    private String nombre;

}
