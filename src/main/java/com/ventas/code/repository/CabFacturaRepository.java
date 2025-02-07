package com.ventas.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ventas.code.model.CabFactura;

public interface CabFacturaRepository extends JpaRepository<CabFactura, Integer> {

    @Query(value = "SELECT COALESCE(MAX(num_factura), 0) + 1 as num_factura FROM facturacion.cab_factura", nativeQuery = true)
    public Integer generaFactura();
}
