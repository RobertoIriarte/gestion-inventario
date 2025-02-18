package com.ventas.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ventas.code.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    
    @Query(value = "SELECT * FROM proveedor where activo = 1", nativeQuery = true)
    public List<Proveedor> findAllActivo();

    @Query(value = "SELECT count(rut) as rut FROM proveedor where rut = :rut", nativeQuery = true)
    public String verificarSiExiteProveedor(@Param("rut") String rut);

}
