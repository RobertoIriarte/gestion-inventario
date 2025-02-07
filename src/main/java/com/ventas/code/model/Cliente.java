package com.ventas.code.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Cliente")
public class Cliente {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    @Column(name = "rut", length = 9)
    private String rut;

    @Column(name = "dv", length = 1)
    private String dv;

    @Column
    private String nombre;
    
    @Column
    private String correo;

    @Column(columnDefinition = "TINYINT")
    private Byte activo;

    @Column
    private LocalDate fechaCreacion;
    
}
