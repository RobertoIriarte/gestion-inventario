package com.ventas.code.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Categoria")
public class Categoria {
  
  @Id  
  @Column  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoria_id;
  
  @Column
  private String nombre;
  
  @Column
  private String descripcion; 
  
  @Column(unique = true)
  private String sku; 

}
