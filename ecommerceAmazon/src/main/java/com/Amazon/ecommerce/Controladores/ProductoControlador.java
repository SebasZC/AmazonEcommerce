package com.Amazon.ecommerce.Controladores;

import com.Amazon.ecommerce.Modelos.Comentario;
import com.Amazon.ecommerce.Modelos.Producto;
import com.Amazon.ecommerce.Servicios.FuncionesGenerales;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller//=> Especifica que sus metodos contendran
            //peticiones HTTP (Get, Post, Put...)
            //y que lo mas probable es que retorne una vista ("String")
            // -> retorna unn documento HTML
public class ProductoControlador {

    public static List<Producto> productos;
    public static Producto tablet;

    static {
        //Constructor "static" -> inicializar duante el tiempo de ejecucion

//        tablet = new Producto("Tablet Fire 7, pantalla de 7 pulgadas, 16 GB, (lanzamiento 2019), Negro",39.99, true, "https://m.media-amazon.com/images/I/71TI2NQuuNL._AC_SY450_.jpg");
//
//        tablet.getComentarios().add(new Comentario("zapatasebatia001@gmail.com", "la mejor tablet", 5.0));
//        tablet.getComentarios().add(new Comentario("sebas@correo","Pesima calidad",2.0));
//
//        productos = new ArrayList<Producto>(Arrays.asList(
//                new Producto("Fire TV Stick 4K con la más reciente generación de control remoto por voz Alexa (incluye controles de televisión), Dolby Vision",34.99, true, "https://m.media-amazon.com/images/I/61rQC6AM-6L._AC_SX679_.jpg"),
//                new Producto("Echo (4ta Generación) | Con sonido de alta calidad, hub de smart home y Alexa | Negro",74.99,true, "https://m.media-amazon.com/images/I/61V5O0UpgqS._AC_SX679_.jpg"),
//                tablet
//        )
//        );
    }

    public static List<Producto> getListaProductos(){
        return productos;
    }

    @GetMapping("/catalogo") //=> se trata de una peticion GET
    public String getCatalogoProductos(Model model){
        model.addAttribute("productos", productos); //=> medio de comunicacion con la vista
        return "Catalogo";
    }

    //@RequestParam() => se emplea para especificar argumentos en la URL
        //value -> hace referencia al nombre del argumento
    @GetMapping("/producto") //=> Objetivo: renderizar un solo producto
    public String getProducto(
        @RequestParam(value = "id", required = true, defaultValue = "") int id,
        Model model
    ) throws Exception {
        /*Objetivos: 1. Identificar el producto que se desea comunicar a la vista
        *            2. Añadir el objetivo a los atributos del model*/
        model.addAttribute("producto", FuncionesGenerales.buscadorProducto(productos, id));
        return "Producto";
    }
}
