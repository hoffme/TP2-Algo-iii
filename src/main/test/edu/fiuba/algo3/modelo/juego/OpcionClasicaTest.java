package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.juego.opcion.Opcion;
import edu.fiuba.algo3.modelo.juego.opcion.OpcionClasica;
import edu.fiuba.algo3.modelo.util.punto.Punto;
import edu.fiuba.algo3.modelo.util.punto.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionClasicaTest {
    @Test
    public void ObtenerTituloDevuelveElTituloDeLaOpcion(){
        Opcion opcion = new OpcionClasica("Una opcion", new PuntoPositivo());
        assertEquals("Una opcion",opcion.obtenerTitulo());
    }

    @Test
    public void ObtenerPuntoDevuelveElPuntoDeLaOpcion(){
        Punto puntoPositivo = new PuntoPositivo();

        Opcion opcion = new OpcionClasica("Otra opcion", puntoPositivo);

        assertEquals(puntoPositivo ,opcion.obtenerPunto());
    }
}