package com.productos.DaoImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.DaoFachada.CategoriaDao;
import com.productos.Repository.CategoriasRepository;
import com.productos.modelo.Categorias;



@Service
public class CategoriasImp implements CategoriaDao{

	@Autowired
	CategoriasRepository categoriasrepository;
	
	
	@Override
	public List<Categorias> findAll() {
		
		return categoriasrepository.findAll();
	}

	@Override
	public Categorias findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Categorias categorias) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Categorias categorias) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categorias> saveAll(List<Categorias> listcategorias) {
		
	return this.categoriasrepository.saveAll(listcategorias) ;
	}

}
