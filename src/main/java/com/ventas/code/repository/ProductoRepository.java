package com.ventas.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas.code.model.Categoria;
import com.ventas.code.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
  
  Producto findBySku(String sku);
  
  List<Producto> findByCategoria(Categoria categoria);
}
