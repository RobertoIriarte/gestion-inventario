package com.ventas.code.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Producto")
public class Producto {
  
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long producto_id;
  
  @ManyToOne(cascade = CascadeType.ALL ) 
  @JoinColumn(name="categoria_id")
  private Categoria categoria;
  
  @Column(length = 15, unique = true)
  private String codigo;

  @Column
  private String nombre;

  @Column
  private Double precio;

  @Column
  private Double stock;

  @Column(columnDefinition = "TINYINT")
  private Byte activo;

  @Column
  private LocalDate fechaCreacion;
  
}
