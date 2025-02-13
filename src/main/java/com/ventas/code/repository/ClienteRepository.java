package com.ventas.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ventas.code.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT count(rut) as rut FROM cliente where rut = :rut", nativeQuery = true)
    public String verificarSiExiteCliente(@Param("rut") String rut);

}
