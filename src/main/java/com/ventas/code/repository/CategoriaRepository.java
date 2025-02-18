package com.ventas.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ventas.code.model.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
  
  
  @Query(value = "SELECT * FROM categoria where activo = 1", nativeQuery = true)
  public List<Categoria> findAllActivo();
  
  @Query("SELECT c FROM Categoria c WHERE c.categoria_id=?1")
  List<Categoria> findByCategoria(Long idCategotia);
}
