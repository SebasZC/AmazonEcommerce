package com.Amazon.ecommerce.Servicios;

import com.Amazon.ecommerce.Modelos.Comentario;
import com.Amazon.ecommerce.Modelos.Producto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest //=> test de integración
@ActiveProfiles(profiles = "test")
class ComentarioServicioTest {


    @Autowired
    private ComentarioServicio comentarioServicio;

    @Autowired
    private ProductoServicio productoServicio;

    private Producto producto;

    @BeforeEach
    public void setUp(){
        Producto zapatos = Producto.builder()
                .nombre("Zapatos de cuero")
                .precio(200_000.0)
                .disponible(true)
                .fotoCatalogo("foto")
                .foto("foto")
                .build();

        productoServicio.crearProducto(zapatos);
    }

    @AfterEach
    public void tearDown(){
        //productoServicio.deleteAll();
    }

    @Test
    public void testCrearComentario(){
        Comentario Sebas = new Comentario(
                "zapatasebastian001@gmail.com",
                "la mejor blusa del mundo mundial",
                4.5
        );

        comentarioServicio.crearComentario(Sebas, producto);

        assertEquals(1, comentarioServicio.getAll().size());
    }
}