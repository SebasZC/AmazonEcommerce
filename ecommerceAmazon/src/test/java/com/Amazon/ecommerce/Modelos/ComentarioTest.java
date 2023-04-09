package com.Amazon.ecommerce.Modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComentarioTest {

    @Test
    public void testCalificacionValida(){
        //la calificación es valida cuando esta entre 0 y 5
        Comentario comentarioSebas = new Comentario("zapatasebastian001@gmail.com", "Buen producto", 3.2);

        assertEquals(3.2, comentarioSebas.getCalificacion());
    }

    @Test
    public void testCalificacionInvalida(){
        assertThrows(
               IllegalArgumentException.class,
                () -> new Comentario("zapatasebastian001@gmail.com", "Buen producto", -3.2)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Comentario("zapatasebastian001@gmail.com", "Buen producto", 5.1)
        );
    }
}