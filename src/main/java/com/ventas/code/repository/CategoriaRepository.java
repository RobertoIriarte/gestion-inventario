package com.ventas.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ventas.code.model.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
  
  //Categoria findBySku(String sku);
  
  @Query("SELECT c FROM Categoria c WHERE c.categoria_id=?1")
  List<Categoria> findByCategoria(Long idCategotia);
}
