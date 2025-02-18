package com.ventas.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.code.model.Medida;
import com.ventas.code.model.Proveedor;
import com.ventas.code.repository.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return (List<Proveedor>) this.proveedorRepository.findAllActivo();
    }

    public Optional<Proveedor> obtenerProveedorPorId(Integer id) {
        return this.proveedorRepository.findById(id);
    }

    public Proveedor crearProveedor(Proveedor proveedor) {
        return this.proveedorRepository.save(proveedor);
    }

    public void actualizarProveedor(Proveedor proveedor) {
        this.proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Integer id) {
        //this.proveedorRepository.deleteById(id);
        if(!proveedorRepository.findById(id).isEmpty()) {
            Proveedor proveedor = proveedorRepository.findById(id).get();
            proveedor.setActivo(Byte.parseByte("0"));
            this.proveedorRepository.save(proveedor);
        }
    }

    public String verificarSiExiteProveedor(String rut) {
        return this.proveedorRepository.verificarSiExiteProveedor(rut);
    }

}
