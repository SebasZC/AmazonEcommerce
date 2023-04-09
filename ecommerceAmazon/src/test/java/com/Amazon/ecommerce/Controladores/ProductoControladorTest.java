package com.Amazon.ecommerce.Controladores;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductoControlador.class) //probar de forma aislada nuestro controlador
class ProductoControladorTest {
    //Objetivo: Probarque el controlador funcione de forma adecuada al
    // enviar los argumentos requeridos por la vista

    @Autowired              //=> vincular el objetivo (mock) al BeanFactory de Spring Boot
    private MockMvc mock;   //=> permite simular peticiones HTML

    @Test
    public void testGetCatalogo() throws Exception{
        mock.perform(get("/catalogo"))  //=> ejecuar peticion GET a la direccion: localhost:8000/catalogo
                .andExpect(status().isOk())       //=> esperamos que el estado de la ejecucion sea "OK" (HTTP 200)
                .andExpect(view().name("Catalogo"))
                .andExpect(model().attributeExists("productos"))
        ;
    }

    @Test
    public void testGetProducto() throws Exception{
        mock.perform(get("/producto").param("id","1"))
                .andExpect(status().isOk())
                .andExpect(view().name("Producto"))
                .andExpect(model().attribute("producto", ProductoControlador.tablet))
        ;
    }

}