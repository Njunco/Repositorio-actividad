package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Categorias;




@Repository
public interface CategoriasRepository extends JpaRepository <Categorias, Integer> {

}
