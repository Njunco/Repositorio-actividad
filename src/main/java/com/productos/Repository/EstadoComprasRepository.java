package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.estadocompras;



@Repository
public interface EstadoComprasRepository extends JpaRepository<estadocompras, Integer> {

}
