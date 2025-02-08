package com.ventas.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ventas.code.dto.DetFacturaDTO;
import com.ventas.code.dto.ProductoDTO;
import com.ventas.code.model.Producto;
import com.ventas.code.service.CategoriaService;
import com.ventas.code.service.ProductoService;
import com.ventas.code.utils.ResponseMessage;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/api/v1/producto")
public class ProductoController {
  
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/encontrarProductosPorCategoria/{id_categoria}")
    public List<Producto> encontrarProductosPorCategoria(@PathVariable Long id_categoria){
      return productoService.encontrarProductosPorCategoria(id_categoria);
    }
    
    @GetMapping
    public List<Producto> listarProducto() {
        return this.productoService.listarProducto();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Optional<Producto> producto = this.productoService.obtenerProductoPorId(id);
        return producto.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/verificar-cod-producto/{cod_producto}")
    public ResponseEntity<ResponseMessage> verificarSiExiteElCodProducto(@PathVariable String cod_producto) {
        String verificarSiExiteElCodProducto = this.productoService.verificarSiExiteElCodProducto(cod_producto);
        return ResponseEntity.ok(new ResponseMessage(200, verificarSiExiteElCodProducto));
    }
    @PostMapping("/disminuir-stock")
    public ResponseEntity<Integer> disminuirStock(@RequestBody List<DetFacturaDTO> detallesFacturaDTO) {
        this.productoService.disminuirStock(detallesFacturaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        producto.setFechaCreacion(LocalDate.now());
        Producto nuevoProducto = this.productoService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarProducto(@RequestBody Producto producto) {
            this.productoService.actualizarProducto(producto);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    
    
    @PostMapping("/guardarProducto")
    public Producto guardarProducto(@RequestBody ProductoDTO productoDTO) {
      Producto producto=new Producto();
      producto=productoDTO.obtenerProducto(productoDTO);
      producto.setCategoria(categoriaService.encontrarCategoriaPorId(productoDTO.getCategoria_id()));
      return productoService.guardarProducto(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (this.productoService.obtenerProductoPorId(id).isPresent()) {
            this.productoService.eliminarProducto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
