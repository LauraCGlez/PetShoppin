package com.springapplication.petshoppin.repositorios;

import java.util.List;

import com.springapplication.petshoppin.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springapplication.petshoppin.modelo.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{

	List<Compra> findByPropietario(Usuario propietario);
	
}
