package com.Amazon.ecommerce.Servicios;

import com.Amazon.ecommerce.Controladores.ProductoControlador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionesGeneralesTest {

    @Test
    public void testBuscadorProductos() throws Exception{
        assertEquals("Tablet Fire 7, pantalla de 7 pulgadas, 16 GB, (lanzamiento 2019), Negro",FuncionesGenerales.buscadorProducto(
                ProductoControlador.getListaProductos(), 1).getNombre());
    }

    @Test
    public void testBucarProductoQueNoExiste(){
        assertThrows(
                Exception.class,
                () -> FuncionesGenerales.buscadorProducto(
                        ProductoControlador.getListaProductos(),50
                )
        );
    }

}