package com.ventas.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.code.dto.DetFacturaDTO;
import com.ventas.code.model.Categoria;
import com.ventas.code.model.Producto;
import com.ventas.code.repository.CategoriaRepository;
import com.ventas.code.repository.ProductoRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
  @Autowired
  private ProductoRepository productoRepository;
  
  public List<Producto> consultarProductosVentas(){
    return productoRepository.findAllActivoVentas();
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
  
  public List<Producto> encontrarProductosPorCategoria(Long id_categoria){
    return productoRepository.findByCategoria(id_categoria);
  }

  public List<Producto> listarProductosBodega() {
      return (List<Producto>) this.productoRepository.findAllActivoBodega();
  }

  public Optional<Producto> obtenerProductoPorId(Long id) {
      return this.productoRepository.findById(id);
  }

  public Producto crearProducto(Producto producto) {
      return this.productoRepository.save(producto);
  }

  public void actualizarProducto(Producto producto) {
      this.productoRepository.save(producto);
  }

  public void eliminarProducto(Long id) {
      if(!productoRepository.findById(id).isEmpty()) {
        Producto producto = productoRepository.findById(id).get();
        producto.setActivo(Byte.parseByte("0"));
        this.productoRepository.save(producto);
      }
  }

  public String verificarSiExiteElCodProducto(String cod_producto) {
      return this.productoRepository.verificarSiExiteElCodProducto(cod_producto);
  }
  @Transactional
  public void disminuirStock(List<DetFacturaDTO> detFacturaDTOs) {
      for (DetFacturaDTO detFacturaDTO : detFacturaDTOs) {
          System.out.println("detFacturaDTO::::" +detFacturaDTO.getCodigoProducto() + " " + detFacturaDTO.getCantidad());
          this.productoRepository.disminuirStock(  detFacturaDTO.getCodigoProducto(),
                  detFacturaDTO.getCantidad()
          );
      }
  }

}
