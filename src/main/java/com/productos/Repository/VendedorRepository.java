package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Vendedor;




@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{

}
