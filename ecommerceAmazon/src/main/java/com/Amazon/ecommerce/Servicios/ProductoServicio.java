package com.Amazon.ecommerce.Servicios;

import com.Amazon.ecommerce.Modelos.Comentario;
import com.Amazon.ecommerce.Modelos.Producto;
import com.Amazon.ecommerce.Repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public void crearProducto(Producto producto){
        productoRepositorio.save(producto);
    }

    public void crearProducto(Producto producto, Comentario comentario){
        //Objetivo: Actualizar el producto, vincularlo con
        //un nuevo comentario y guardar el comentario

    }

    public void crearProducto(Producto producto, List<Comentario> comentario){

    }

    public List<Producto> getAll(){
        return productoRepositorio.findAll();
    }

    public void deleteAll(){
        //productoRepositorio.deleteAll();
    }
}
