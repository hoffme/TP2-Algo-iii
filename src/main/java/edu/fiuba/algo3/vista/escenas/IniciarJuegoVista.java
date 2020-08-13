package edu.fiuba.algo3.vista.escenas;

import edu.fiuba.algo3.controladores.IniciarJuegoControlador;
import edu.fiuba.algo3.vista.componentes.botones.BotonCuadradoVista;
import edu.fiuba.algo3.vista.componentes.botones.BotonEtiquetaVista;
import javafx.scene.Node;

public class IniciarJuegoVista extends EstructuraPrincipalVista{

    private final IniciarJuegoControlador controlador;

    public IniciarJuegoVista(IniciarJuegoControlador iniciarJuegoControlador) {
        this.controlador = iniciarJuegoControlador;
    }

    @Override
    protected Node cabeceraDerecha() {
        BotonEtiquetaVista botonCargarPreguntas = new BotonEtiquetaVista("CARGAR PREGUNTAS",true);
        botonCargarPreguntas.obtenerBoton().click((event) -> this.controlador.otraEscena());

        return botonCargarPreguntas.obtenerNodo();
    }

    @Override
    protected Node cabeceraIzquierda() {
        return null;
    }

    @Override
    protected Node centro() {
        BotonCuadradoVista botonIniciar = new BotonCuadradoVista("INICIAR");
        botonIniciar.click((event) -> this.controlador.siguienteEscena());

        return botonIniciar.obtenerNodo();
    }

    @Override
    protected Node centroIzquierda() {
        return null;
    }

    @Override
    protected Node centroDerecha() { return null; }
}