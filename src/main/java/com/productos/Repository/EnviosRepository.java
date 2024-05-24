package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Envios;


@Repository
public interface EnviosRepository extends JpaRepository<Envios,Integer> {

}
