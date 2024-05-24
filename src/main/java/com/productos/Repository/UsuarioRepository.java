package com.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productos.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

	public Usuario findByEmailAndPassword(String email, String password);
	

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    public Usuario findByEmail(String email); 
     
    public Usuario findByResetPasswordToken(String token);
}
	