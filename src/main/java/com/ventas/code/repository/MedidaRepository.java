package com.ventas.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ventas.code.model.Medida;

@Repository
public interface MedidaRepository extends JpaRepository<Medida,Long> {

  @Query(value = "SELECT * FROM medida where activo = 1", nativeQuery = true)
  public List<Medida> findAllActivo();
  
}
