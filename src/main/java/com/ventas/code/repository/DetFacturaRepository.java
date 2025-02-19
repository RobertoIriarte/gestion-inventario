package com.ventas.code.repository;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ventas.code.model.DetFactura;

public interface DetFacturaRepository extends JpaRepository<DetFactura, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO det_factura (codigo_producto, precio, cantidad, pk_cab_factura) VALUES (?1, ?2, ?3,?4)", nativeQuery = true)
    void insertarFactura(Long codigoProducto, String precio, Integer cantidad, Integer pkCabFactura);
}
