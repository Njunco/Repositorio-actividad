package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Productos;



@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}
