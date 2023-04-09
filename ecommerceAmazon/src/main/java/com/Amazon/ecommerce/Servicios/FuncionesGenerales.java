package com.Amazon.ecommerce.Servicios;

import com.Amazon.ecommerce.Modelos.Producto;

import java.util.List;

//Objetivo: generacion de funciones de ayuda generales
public class FuncionesGenerales {

    public static Producto buscadorProducto(List<Producto> productos, int id)throws Exception{
        for (Producto producto : productos){
            if(producto.getProductoId() == id){
                return producto;
            }
        }
        throw new Exception("No existe producto con el id=  " + id);
    }
}
