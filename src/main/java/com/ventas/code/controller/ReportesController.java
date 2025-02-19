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

import com.ventas.code.dto.ReporteAnualDTO;
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

    @GetMapping("/anual")
    public ReporteAnualDTO reporteAnual() {
        ReporteAnualDTO anual = new ReporteAnualDTO();
        List<CabFactura> cabeceras = cabFacturaService.obtenerTodas();
        System.out.println(LocalDate.now().getMonthValue());

        for(int i=1; i<13; i++){
            switch (i) {
                case 1:
                    anual.setEnero(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==1).toList().size());
                    break;
                case 2:
                    anual.setFebrero(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==2).toList().size());
                    break;
                case 3:
                    anual.setMarzo(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==3).toList().size());
                    break;
                case 4:
                    anual.setAbril(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==4).toList().size());
                    break;
                case 5:
                    anual.setMayo(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==5).toList().size());
                    break;
                case 6:
                    anual.setJunio(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==6).toList().size());
                    break;
                case 7:
                    anual.setJulio(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==7).toList().size());
                    break;
                case 8:
                    anual.setAgosto(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==8).toList().size());
                    break;
                case 9:
                    anual.setSeptiembre(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==9).toList().size());
                    break;
                case 10:
                    anual.setOctubre(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==10).toList().size());
                    break;
                case 11:
                    anual.setNoviembre(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==11).toList().size());
                    break;
                case 12:
                    anual.setDiciembre(cabeceras.stream().filter(cab -> cab.getFechaCreacion().getMonthValue()==12).toList().size());
                    break;
                default:
                    break;
            }
        }

        Integer count = cabeceras.stream()
                             .filter(cab ->  LocalDate.now().getMonthValue() == cab.getFechaCreacion().getMonthValue())
                             .mapToInt(cab -> (int) Double.parseDouble(cab.getTotal())).sum();
        
        return anual;
    }
}
