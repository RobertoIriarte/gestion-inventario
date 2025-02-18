package com.ventas.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ventas.code.model.Medida;
import com.ventas.code.service.MedidaService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medida")
public class MedidaController {

    @Autowired
    private MedidaService medidaService;

    @GetMapping
    public ResponseEntity<List<Medida>> obtenerTodasMedidas() {
        List<Medida> medidas = medidaService.obtenerTodas();
        return new ResponseEntity<>(medidas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medida> obtenerMedidaPorId(@PathVariable("id") Long id) {
        return medidaService.obtenerPorId(id)
                .map(medida -> new ResponseEntity<>(medida, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Medida> guardarFactura(@RequestBody Medida medida) {
        Medida medidaGuardada = medidaService.guardarMedida(medida);
        return new ResponseEntity<>(medidaGuardada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMedidaPorId(@PathVariable("id") Long id) {
        medidaService.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
