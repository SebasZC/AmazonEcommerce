package com.Amazon.ecommerce.Servicios;


import com.Amazon.ecommerce.Modelos.Comentario;
import com.Amazon.ecommerce.Modelos.Producto;
import com.Amazon.ecommerce.Repositorios.ComentarioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServicio {

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    public void crearComentario(Comentario comentario){
        comentarioRepositorio.save(comentario);
    }

    public void crearComentario(Comentario comentario, Producto producto){
        comentario.setProducto(producto);
        this.crearComentario(comentario);
    }

    public void crearComentario(Comentario comentario, int productoId){

        this.crearComentario(comentario);
    }


    public List<Comentario> getAll(){
        return comentarioRepositorio.findAll();
    }
}
