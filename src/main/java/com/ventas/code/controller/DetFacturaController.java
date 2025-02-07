package com.ventas.code.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ventas.code.dto.DetFacturaDTO;
import com.ventas.code.service.DetFacturaService;
import com.ventas.code.utils.ResponseMessage;

import java.util.List;

@RestController
@RequestMapping("/det-factura")
public class DetFacturaController {

    private final DetFacturaService detFacturaService;

    public DetFacturaController(DetFacturaService detFacturaService) {
        this.detFacturaService = detFacturaService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<ResponseMessage> guardarDetallesFactura(@RequestBody List<DetFacturaDTO> detallesFacturaDTO) {
        detFacturaService.insertarFacturas(detallesFacturaDTO);
        return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK.value(), "Detalles de factura guardados exitosamente"));
    }


}
