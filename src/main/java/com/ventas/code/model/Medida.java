package com.ventas.code.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Medida")
public class Medida {
  
  @Id  
  @Column  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long medida_id;
  
  @Column
  private String codigo;

  @Column
  private String nombre;

  @Column(columnDefinition = "TINYINT")
  private Byte activo;

}
