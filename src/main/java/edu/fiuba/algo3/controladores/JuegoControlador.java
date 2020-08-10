package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.escenas.JuegoVista;
import edu.fiuba.algo3.vista.escenas.RegistrarJugadoresVista;
import javafx.stage.Stage;

public class JuegoControlador {

    private Stage stage;
    private JuegoVista vista;

    public JuegoControlador(Stage stage) {
        this.vista = new JuegoVista(this);
        this.stage = stage;
        this.stage.setScene(this.vista.obtenerEscena());
    }

    public RegistrarJugadoresVista otraEscena() {
        return new RegistrarJugadoresVista(new RegistrarJugadoresControlador(this.stage));
    }
}