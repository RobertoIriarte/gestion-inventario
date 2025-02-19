package com.ventas.code.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DetFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_producto")
    private Long codigoProducto;

    @Column(name = "precio", columnDefinition = "DECIMAL(10,2)")
    private String precio;

    @Column
    private Integer cantidad;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pk_cab_factura")
    private CabFactura pkCabFactura;
}
