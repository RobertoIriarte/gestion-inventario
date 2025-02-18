package com.ventas.code.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ventas.code.model.CabFactura;

public interface CabFacturaRepository extends JpaRepository<CabFactura, Integer> {

    @Query(value = "SELECT COALESCE(MAX(num_factura), 0) + 1 as num_factura FROM cab_factura", nativeQuery = true)
    public Integer generaFactura();

    @Query(value = "SELECT * FROM cab_factura where fechaCreacion <= fecha", nativeQuery = true)
    public List<CabFactura> obtenerFacturasPorFecha(LocalDate fecha);
}
