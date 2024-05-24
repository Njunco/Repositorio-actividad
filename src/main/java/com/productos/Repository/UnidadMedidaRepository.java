package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.modelo.UnidadesMedida;


@Repository
public interface UnidadMedidaRepository  extends JpaRepository<UnidadesMedida, Integer>{

}
