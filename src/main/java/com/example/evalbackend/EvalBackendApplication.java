package com.example.evalbackend;

import com.example.evalbackend.domain.dao.ClienteDao;
import com.example.evalbackend.domain.dao.ProductoDao;
import com.example.evalbackend.domain.dao.VentaDao;
import com.example.evalbackend.domain.entities.Cliente;
import com.example.evalbackend.domain.entities.Producto;
import com.example.evalbackend.domain.entities.Venta;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@SpringBootApplication
public class EvalBackendApplication {

	@Autowired
	private VentaDao ventaDao;

	@Autowired
	private ClienteDao clienteDao;

	@Autowired
	private ProductoDao productoDao;

	public static void main(String[] args) {
		SpringApplication.run(EvalBackendApplication.class, args);
	}


}
