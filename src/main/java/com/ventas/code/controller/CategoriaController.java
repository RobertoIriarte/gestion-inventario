package com.ventas.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ventas.code.model.Categoria;
import com.ventas.code.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/categoria")
public class CategoriaController {
  
  @Autowired
  private CategoriaService categoriaService;
  
  @PostMapping("/guardarCategoria")
  public Categoria guardarCategoria(@RequestBody Categoria categoria) {
    categoria.setActivo(Byte.parseByte("1"));
    return categoriaService.guardarCategoria(categoria);
  }
  
  @GetMapping("/obtenerCategorias")
  public List<Categoria> obtenerCategorias() {
    return categoriaService.consultarCategorias();
  }
  
  @GetMapping("/encontrarCategoriaPorId/{categoria_id}")
  public Categoria encontrarCategoriaPoriD(@PathVariable Long categoria_id){
    return categoriaService.encontrarCategoriaPorId(categoria_id);
  }
  
  @PutMapping("/actualizarCategoria")
  public Categoria actualizarCategoria(@RequestBody Categoria categoria){
    categoria.setActivo(Byte.parseByte("1"));
    return categoriaService.actualizarCategoria(categoria);
  }

  @DeleteMapping("/eliminarCategoria/{categoria_id}")
  public boolean eliminarCategoria(@PathVariable Long categoria_id){
    return categoriaService.eliminarCategoria(categoria_id);
  }
}
