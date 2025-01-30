package com.ventas.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.code.model.Categoria;
import com.ventas.code.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {
  @Autowired
  private CategoriaRepository categoriaRepository;
  
  public List<Categoria> consultarCategorias(){
    return categoriaRepository.findAll();
  }
  
  public Categoria guardarCategoria(Categoria categoria){
    return categoriaRepository.save(categoria);
  }
  
  public Categoria encontrarCategoriaPorId(Long categoria_id){
    if(!categoriaRepository.findById(categoria_id).isEmpty()) {
      return categoriaRepository.findById(categoria_id).get();
    } else {
      return null;
    }
  }
  
  public Categoria encontrarCategoriaPorSku(String sku){
    return categoriaRepository.findBySku(sku);
  }
  
  public Categoria actualizarCategoria(Categoria categoria){
    if(!categoriaRepository.findById(categoria.getCategoria_id()).isEmpty()){
      Categoria categoriaActualizar = categoriaRepository.findById(categoria.getCategoria_id()).get();
      categoriaActualizar.setSku(categoria.getSku());
      categoriaActualizar.setNombre(categoria.getNombre());
      categoriaActualizar.setDescripcion(categoria.getDescripcion());
    return categoriaRepository.save(categoriaActualizar);
    } else {
      return null;
    }
  }
  
  public boolean eliminarCategoria(Long categoria_id){
    if(!categoriaRepository.findById(categoria_id).isEmpty()){
      categoriaRepository.deleteById(categoria_id);
      return true;
    } else{
      return false;
    }
  }
}
