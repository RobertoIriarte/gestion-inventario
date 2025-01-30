package com.ventas.code.model;

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
  
  @ManyToOne(cascade = CascadeType.ALL ) @JoinColumn(name="categoria_id")
  private Categoria categoria;
  
  @Column
  private double precio;
  
  @Column
  private String nombre;
  
  @Column
  private String marca;
  
  @Column(length = 2000)
  private String descripcion;
  
  @Column(columnDefinition = "TEXT")
  private String imagen;
  
  @Column
  private String ficha_tecnica;
  
  @Column(unique = true)
  private String sku;
  
  @Column
  private int stock;
  
}
