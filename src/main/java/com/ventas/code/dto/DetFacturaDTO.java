package com.ventas.code.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetFacturaDTO {

    private Long codigoProducto;
    private String precio;
    private Integer cantidad;
    private Integer pkCabFactura;

}
