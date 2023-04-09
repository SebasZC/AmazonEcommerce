package com.Amazon.ecommerce.Repositorios;

import com.Amazon.ecommerce.Modelos.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {
    List<Producto> findAll();
}
