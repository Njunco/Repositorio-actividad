package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Ventas;


@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {

}
