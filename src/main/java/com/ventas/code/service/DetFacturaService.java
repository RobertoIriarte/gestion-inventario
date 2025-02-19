package com.ventas.code.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ventas.code.dto.DetFacturaDTO;
import com.ventas.code.repository.CabFacturaRepository;
import com.ventas.code.repository.DetFacturaRepository;

import java.util.List;

@Service
public class DetFacturaService {

    private static  final Logger LOGGER = LoggerFactory.getLogger(DetFacturaService.class);
    private final DetFacturaRepository detFacturaRepository;

    private final CabFacturaRepository cabFacturaRepository;

    public DetFacturaService(DetFacturaRepository detFacturaRepository, CabFacturaRepository cabFacturaRepository) {
        this.detFacturaRepository = detFacturaRepository;
        this.cabFacturaRepository = cabFacturaRepository;
    }

    @Transactional
    public void insertarFacturas(List<DetFacturaDTO> detFacturaDTOs) {
        for (DetFacturaDTO detFacturaDTO : detFacturaDTOs) {
            this.detFacturaRepository.insertarFactura(  detFacturaDTO.getCodigoProducto(),
                                                        detFacturaDTO.getPrecio(),
                                                        detFacturaDTO.getCantidad(),
                                                        detFacturaDTO.getPkCabFactura()
                                                      );
        }
    }

}
