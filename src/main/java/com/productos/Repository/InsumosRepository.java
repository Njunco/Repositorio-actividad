package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Insumos;



@Repository
public interface InsumosRepository extends JpaRepository<Insumos, Integer> {

}
