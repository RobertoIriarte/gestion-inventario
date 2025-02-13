package com.ventas.code.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ventas.code.model.Proveedor;
import com.ventas.code.service.ProveedorService;
import com.ventas.code.utils.ResponseMessage;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> listarClientes() {
        return this.proveedorService.listarProveedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Integer id) {
        Optional<Proveedor> proveedor = this.proveedorService.obtenerProveedorPorId(id);
        return proveedor.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/verificar-proveedor/{rut}")
    public ResponseEntity<ResponseMessage> verificarSiExiteProveedor(@PathVariable String rut) {
        String verificarSiExiteCliente = this.proveedorService.verificarSiExiteProveedor(rut);
        return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK.value(), verificarSiExiteCliente));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {
        proveedor.setFechaCreacion(LocalDate.now());
        Proveedor nuevoProveedor = this.proveedorService.crearProveedor(proveedor);
        return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarProveedor(@RequestBody Proveedor proveedor) {
        this.proveedorService.actualizarProveedor(proveedor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer id) {
        if (this.proveedorService.obtenerProveedorPorId(id).isPresent()) {
            this.proveedorService.eliminarProveedor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
