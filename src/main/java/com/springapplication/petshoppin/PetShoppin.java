package com.springapplication.petshoppin;

import java.util.Arrays;
import java.util.List;

import com.springapplication.petshoppin.modelo.Usuario;
import com.springapplication.petshoppin.servicios.ProductoServicio;
import com.springapplication.petshoppin.servicios.UsuarioServicio;
import com.springapplication.petshoppin.upload.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springapplication.petshoppin.modelo.Producto;

@SpringBootApplication
public class PetShoppin {

	public static void main(String[] args) {
		SpringApplication.run(PetShoppin.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoServicio productoServicio) {
		return args -> {

			Usuario usuario = new Usuario("Laura", "CGlez", "/home/lauracglez/Desktop/PetShoppin/src/main/resources/static/images/avatar.svg", "laura@gmail.com", "12345678");
			usuario = usuarioServicio.registrar(usuario);

			Usuario usuario2 = new Usuario("Luis", "BLores", "/home/lauracglez/Desktop/PetShoppin/src/main/resources/static/images/avatar.svg", "luis@gmail.com", "12345678");
			usuario2 = usuarioServicio.registrar(usuario2);


			List<Producto> listado = Arrays.asList(
					new Producto("Árbol", 30.0f, "static/images/arbol.jpg", usuario),
					new Producto("Arnés para perros", 20.0f, "/home/lauracglez/Desktop/PetShoppin/src/main/resources/static/images/arnes.jpg", usuario2),
					new Producto("Cama", 10.5f, "src/main/resources/static/images/cama.jpg", usuario2),
					new Producto("Comida", 5.0f, "/img/comida.jpg", usuario2),
					new Producto("Dispensador de bolsas", 10.0f, "src/main/resources/static/images/dispensador.jpg", usuario2),
					new Producto("Transportin", 50.0f, "static/images/transportin.jpg", usuario2));

			listado.forEach(productoServicio::insertar);

		};
	}

	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
