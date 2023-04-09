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


@SpringBootTest
@ActiveProfiles(profiles = "dev")
class ProductoServicioTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ComentarioServicio comentarioServicio;

    private Producto zapatos;

    @BeforeEach
    public void setUp(){
        zapatos = Producto.builder()
                .nombre("Zapatos de cuero")
                .precio(200_000.0)
                .disponible(true)
                .fotoCatalogo("..")
                .foto("...")
                .build();
        productoServicio.crearProducto(zapatos);
    }

    @AfterEach
    public void tearDown(){
        //productoServicio.deleteAll();
    }

    @Test
    public void testCrearProducto(){
        assertEquals(1, productoServicio.getAll().size());
    }

    @Test
    public void testAdicionarAProductoComentario(){
        Comentario comentarioSebas = Comentario.builder()
                .usuario("zapatasebastian001@gmail.com")
                .contenido("La mejor cosa que he comprado")
                .calificacion(4.5)
                .producto(zapatos)
                .build();

        comentarioServicio.crearComentario(comentarioSebas,zapatos);

        assertEquals(1, comentarioServicio.getAll().size());
    }

}