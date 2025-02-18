package com.ventas.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.code.model.Medida;
import com.ventas.code.model.Producto;
import com.ventas.code.repository.MedidaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    public Medida guardarMedida(Medida medida) {
        return this.medidaRepository.save(medida);
    }

    public List<Medida> obtenerTodas( ) {
        Iterable<Medida> medidas = this.medidaRepository.findAllActivo();
        List<Medida> listaMedidas = new ArrayList<>();
        medidas.forEach(listaMedidas::add);
        return listaMedidas;
    }

    public Optional<Medida> obtenerPorId(Long id) {
        return this.medidaRepository.findById(id);
    }

    public void eliminarPorId(Long id) {
        //this.medidaRepository.deleteById(id);
        if(!medidaRepository.findById(id).isEmpty()) {
            Medida medida = medidaRepository.findById(id).get();
            medida.setActivo(Byte.parseByte("0"));
            this.medidaRepository.save(medida);
        }
    }
}
