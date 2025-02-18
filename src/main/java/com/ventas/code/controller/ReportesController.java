package com.ventas.code.controller;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.code.model.CabFactura;
import com.ventas.code.model.Producto;
import com.ventas.code.service.CabFacturaService;
import com.ventas.code.service.ClienteService;
import com.ventas.code.service.ProductoService;

@RestController
@RequestMapping("/api/v1/reporte")
@RequiredArgsConstructor
public class ReportesController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CabFacturaService cabFacturaService;

    @GetMapping("/clientes")
    public Integer clientes() {
        return clienteService.listarClientes().size();

    }

    @GetMapping("/productos")
    public Integer listarProductosVentas() {
        return this.productoService.consultarProductosVentas().size();
    }

    @GetMapping("/ventas")
    public Integer ventas() {
        List<CabFactura> cabeceras = cabFacturaService.obtenerTodas();

        int count = cabeceras.stream().filter(cab ->  LocalDate.now().getMonthValue() == cab.getFechaCreacion().getMonthValue()).toList().size();
        
        return count;
    }

    @GetMapping("/ingresos")
    public Integer ingresos() {
        List<CabFactura> cabeceras = cabFacturaService.obtenerTodas();

        Integer count = cabeceras.stream()
                             .filter(cab ->  LocalDate.now().getMonthValue() == cab.getFechaCreacion().getMonthValue())
                             .mapToInt(cab -> (int) Double.parseDouble(cab.getTotal())).sum();
        
        return count;
    }
}
