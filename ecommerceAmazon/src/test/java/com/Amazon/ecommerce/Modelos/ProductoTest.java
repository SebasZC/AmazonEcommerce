package com.Amazon.ecommerce.Modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.charThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //=> crear mocks
class ProductoTest {

    @Mock   //Se emplea para especificar que este comentario es un "cascarón vacío"
    private Comentario comentarioLuisa;

    @Mock
    private Comentario comentarioSara;

    private Producto zapatos;

    @BeforeEach
    public void setUp(){
//        zapatos = new Producto("Zapatos", 200_000, true);
//        zapatos.getComentarios().add(comentarioLuisa);
//        zapatos.getComentarios().add(comentarioSara);
    }

    @Test
    public void testIdAutogenerado(){
        //assertEquals(1, zapatos.getId());

        Producto manzana = new Producto();

        //assertEquals(1, zapatos.getId());
        //assertEquals(2, manzana.getId());
    }

    @Test
    public void testCalificacionOK(){
        when(comentarioLuisa.getCalificacion()).thenReturn(3.0);
        when(comentarioSara.getCalificacion()).thenReturn(3.0);

        assertEquals(3.0, zapatos.getCalificacion());

        when(comentarioLuisa.getCalificacion()).thenReturn(3.0);
        when(comentarioSara.getCalificacion()).thenReturn(5.0);

        assertEquals(4.0, zapatos.getCalificacion());

    }

    @Test
    public void testCalificacionNulo(){
        //Objetivo: ignorar los comentarios "null"
        zapatos.getComentarios().add(null);

        assertEquals(0.0, zapatos.getCalificacion());

        when(comentarioSara.getCalificacion()).thenReturn(3.0);
        when(comentarioLuisa.getCalificacion()).thenReturn(4.0);

        assertEquals(3.5, zapatos.getCalificacion());
    }

    @Test
    public void testStockDisponible(){
        //Objetivo: Probar si el articulo deja de estar disponible al agotar existencias
        //zapatos.setStock(5);
        //assertEquals(true, zapatos.isDisponible());

        //zapatos.setStock(-2);
        //assertEquals(0, zapatos.getStock());
        //assertEquals(false,zapatos.isDisponible());
    }

    @Test
    public void testPrecioNegativo(){
//        assertThrows(
//                IllegalArgumentException.class,
//                () -> zapatos.setPrecio(-200)
//        );
    }

    @Test
    public void testSinComentarios(){
        Producto chqueta = new Producto();
        assertEquals(0.0, chqueta.getCalificacion());
    }
}