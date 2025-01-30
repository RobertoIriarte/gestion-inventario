package com.ventas.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.code.model.Categoria;
import com.ventas.code.model.Producto;
import com.ventas.code.repository.CategoriaRepository;
import com.ventas.code.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {
  @Autowired
  private ProductoRepository productoRepository;
  @Autowired
  CategoriaRepository categoriaRepository;
  // ACCIONES
  public List<Producto> consultarProductos(){
    return productoRepository.findAll();
  }
  
  public Producto guardarProducto(Producto producto) {
    return productoRepository.save(producto);
  }
  
  public Producto encontrarProductoPorID(Long producto_id) {
    if(!productoRepository.findById(producto_id).isEmpty()) {
      return productoRepository.findById(producto_id).get();
    } else {
      return null;
    }
  }
  
  public Producto actualizarProducto(Producto producto){
    if(!productoRepository.findById(producto.getProducto_id()).isEmpty()){
      return productoRepository.save(producto);
    } else {
      return null;
    }
  }
  
  public boolean eliminarProducto(Long producto_id){
    if(!productoRepository.findById(producto_id).isEmpty()){
      productoRepository.deleteById(producto_id);
      return true;
    } else{
      return false;
    }
  }

  public Producto encontrarProductoPorSku(String sku){
    return productoRepository.findBySku(sku);
  }
  
  public List<Producto> encontrarProductosPorCategoria(String sku_categoria){
    Categoria categoria=categoriaRepository.findBySku(sku_categoria);
    return productoRepository.findByCategoria(categoria);
  }

}
