package com.productos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.VentasProducto;


@Repository
public interface VentasProductoRepository extends JpaRepository<VentasProducto, Integer> {	
}
