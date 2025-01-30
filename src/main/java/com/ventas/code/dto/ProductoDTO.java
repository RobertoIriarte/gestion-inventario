package com.ventas.code.dto;

import com.ventas.code.model.Categoria;
import com.ventas.code.model.Producto;

public class ProductoDTO {
  private Long producto_id;
  private Long categoria_id;
  private String nombre;
  private double precio;
  private String marca;
  private String descripcion;
  private String imagen;
  private String ficha_tecnica;
  private String sku;
  private int stock;

  public Producto obtenerProducto(ProductoDTO  productoDTO){
    Producto producto = new Producto();
    producto.setProducto_id(productoDTO.getProducto_id());
    producto.setNombre(productoDTO.getNombre());
    producto.setMarca(productoDTO.getMarca());
    producto.setDescripcion(productoDTO.getDescripcion());
    producto.setImagen(productoDTO.getImagen());
    producto.setFicha_tecnica(productoDTO.getFicha_tecnica());
    producto.setSku(productoDTO.getSku());
    producto.setStock(productoDTO.getStock());
    producto.setPrecio(productoDTO.getPrecio());
    return producto;
  }

  public Long getProducto_id() {
    return producto_id;
  }
  public void setProducto_id(Long producto_id) {
    this.producto_id = producto_id;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public Long getCategoria_id() {
    return categoria_id;
  }

  public void setCategoria_id(Long categoria_id) {
    this.categoria_id = categoria_id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public String getFicha_tecnica() {
    return ficha_tecnica;
  }

  public void setFicha_tecnica(String ficha_tecnica) {
    this.ficha_tecnica = ficha_tecnica;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
}
