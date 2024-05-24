package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
