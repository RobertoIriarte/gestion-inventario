package com.ventas.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.code.model.Cliente;
import com.ventas.code.model.Producto;
import com.ventas.code.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return this.clienteRepository.findById(id);
    }

    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public void actualizarCliente(Cliente cliente) {

        this.clienteRepository.save(cliente);
    }

    public void eliminarCliente(Integer id) {
        //this.clienteRepository.deleteById(id);
        if(!clienteRepository.findById(id).isEmpty()) {
            Cliente cliente = clienteRepository.findById(id).get();
            cliente.setActivo(Byte.parseByte("0"));
            this.clienteRepository.save(cliente);
        }
    }

    public String verificarSiExiteCliente(String rut) {
        return this.clienteRepository.verificarSiExiteCliente(rut);
    }

}
