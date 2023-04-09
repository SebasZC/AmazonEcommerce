package com.Amazon.ecommerce.Repositorios;

import com.Amazon.ecommerce.Modelos.Comentario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComentarioRepositorio extends CrudRepository<Comentario, Integer> {
    List<Comentario> findAll();
}
