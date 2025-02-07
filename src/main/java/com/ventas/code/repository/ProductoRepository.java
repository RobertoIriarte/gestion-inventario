package com.ventas.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ventas.code.model.Categoria;
import com.ventas.code.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

  @Query(value = "SELECT codigo as cod_producto FROM facturacion.producto where codigo = :cod_producto", nativeQuery = true)
  public String verificarSiExiteElCodProducto(@Param("cod_producto") String cod_producto);

  @Modifying
  @Query(value = "UPDATE facturacion.producto SET stock = stock - :cantidad WHERE codigo = :id_producto", nativeQuery = true)
  public Integer disminuirStock(@Param("id_producto") Long id_producto, @Param("cantidad") Integer cantidad);
  
  //public Producto findBySku(String sku);
  
  public List<Producto> findByCategoria(Categoria categoria);
}
