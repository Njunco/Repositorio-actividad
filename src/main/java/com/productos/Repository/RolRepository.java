package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
