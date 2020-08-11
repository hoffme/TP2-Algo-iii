package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.escenas.CargarPreguntasVista;
import edu.fiuba.algo3.vista.escenas.GanadorVista;
import edu.fiuba.algo3.vista.escenas.IniciarJuegoVista;
import edu.fiuba.algo3.vista.escenas.PuntosObtenidosVista;
import javafx.stage.Stage;

public class GanadorControlador {
    private Stage stage;
    private GanadorVista vista;

    public GanadorControlador(Stage stage) {
        this.stage = stage;
        this.vista = new GanadorVista(this);
        this.stage.setScene(this.vista.obtenerEscena());
    }

    public PuntosObtenidosVista escenaAnterior() {
        return new PuntosObtenidosVista();
    }

    public void mostrarVista() { this.stage.show(); }
}