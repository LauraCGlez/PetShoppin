package com.springapplication.petshoppin.repositorios;

import java.util.List;

import com.springapplication.petshoppin.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springapplication.petshoppin.modelo.Compra;
import com.springapplication.petshoppin.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	List<Producto> findByPropietario(Usuario propietario);
	
	List<Producto> findByCompra(Compra compra);
	
	List<Producto> findByCompraIsNull();
	
	List<Producto> findByNombreContainsIgnoreCaseAndCompraIsNull(String nombre);
	
	List<Producto> findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario propietario);
	
}
