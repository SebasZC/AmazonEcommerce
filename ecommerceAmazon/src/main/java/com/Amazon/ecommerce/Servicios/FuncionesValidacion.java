package com.Amazon.ecommerce.Servicios;

//Objetivo: crear una serie de funciones genericas que nos
//          permitan validar los datos
public class FuncionesValidacion {
    public static void validarCalificacion(double calificacion){
        if(calificacion < 0 || calificacion > 5){
            throw new IllegalArgumentException("La calificacion no puedue ser menor a 0.0 o mayor a 5.0");
        }
    }

    public static void validarPrecioProducto(double precio){
        if(precio < 0){
            throw new IllegalArgumentException("No es posible trabajar con precios negativos");
        }
    }
}
