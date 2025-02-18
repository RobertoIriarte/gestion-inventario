package com.ventas.code.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ventas.code.model.CabFactura;
import com.ventas.code.service.CabFacturaService;
import com.ventas.code.utils.ResponseMessage;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cab-factura")
public class CabFacturaController {

    private final CabFacturaService cabFacturaService;

    public CabFacturaController(CabFacturaService cabFacturaService) {
        this.cabFacturaService = cabFacturaService;
    }

    @GetMapping
    public ResponseEntity<List<CabFactura>> obtenerTodasCabeceras() {
        List<CabFactura> cabeceras = cabFacturaService.obtenerTodas();
        return new ResponseEntity<>(cabeceras, HttpStatus.OK);
    }

    @GetMapping("/factura/{id}")
    public ResponseEntity<CabFactura> obtenerFacturaPorId(@PathVariable("id") Integer id) {
        return cabFacturaService.obtenerPorId(id)
                .map(factura -> new ResponseEntity<>(factura, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CabFactura> guardarFactura(@RequestBody CabFactura cabFactura) {
        cabFactura.setFechaCreacion(LocalDate.now());
        CabFactura facturaGuardada = cabFacturaService.guardarCabFactura(cabFactura);
        return new ResponseEntity<>(facturaGuardada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFacturaPorId(@PathVariable("id") Integer id) {
        cabFacturaService.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/genera-factura")
    public ResponseEntity<ResponseMessage> generaFactura() {
        return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK.value(), this.cabFacturaService.generaFactura()));
    }

    @GetMapping("/{fecha}")
    public ResponseEntity<List<CabFactura>> obtenerFacturaPorFecha(@PathVariable("fecha") LocalDate fecha) {
        List<CabFactura> cabeceras = cabFacturaService.obtenerFacturasPorFecha(fecha);
        return new ResponseEntity<>(cabeceras, HttpStatus.OK);
    }

}
