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
  
  @Column
  private Long categoria_id;
  
  @Column
  private String codigo;

  @Column
  private String nombre;

  @Column
  private Double precio;

  @Column
  private Double stock;

  @Column
  private Double stockCritico;

  @Column
  private LocalDate fechaCreacion;

  @Column
  private LocalDate fechaElaboracion;

  @Column
  private LocalDate fechaVencimiento;

  @Column(columnDefinition = "TINYINT")
  private Byte activo;
  
}
