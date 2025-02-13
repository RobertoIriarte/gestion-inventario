package com.ventas.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.code.model.Proveedor;
import com.ventas.code.repository.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return (List<Proveedor>) this.proveedorRepository.findAll();
    }

    public Optional<Proveedor> obtenerProveedorPorId(Integer id) {
        return this.proveedorRepository.findById(id);
    }

    public Proveedor crearProveedor(Proveedor cliente) {
        return this.proveedorRepository.save(cliente);
    }

    public void actualizarProveedor(Proveedor cliente) {
        this.proveedorRepository.save(cliente);
    }

    public void eliminarProveedor(Integer id) {
        this.proveedorRepository.deleteById(id);
    }

    public String verificarSiExiteProveedor(String rut) {
        return this.proveedorRepository.verificarSiExiteProveedor(rut);
    }

}
