package com.ventas.code.dto;

import java.time.LocalDate;

import com.ventas.code.model.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
  
  private Long producto_id;  
  private Long categoria_id;
  private String nombre;
  private Double precio;
  private Double stock;
  private Byte activo;
  private LocalDate fechaCreacion;

  public Producto obtenerProducto(ProductoDTO  productoDTO){
    Producto producto = new Producto();
    producto.setProducto_id(productoDTO.getProducto_id());
    producto.setNombre(productoDTO.getNombre());
    producto.setPrecio(productoDTO.getPrecio());
    producto.setStock(productoDTO.getStock());
    return producto;
  }
}
