package edu.fiuba.algo3.vista.escenas;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.vista.componentes.botones.BotonEtiquietaVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class PreviaPreguntaVista extends EstructuraPrincipalVista {

    private Jugada jugada;

    public PreviaPreguntaVista(Jugada jugada){
        this.jugada = jugada;
    }

    @Override
    protected Node cabeceraDerecha() {
        return null;
    }

    @Override
    protected Node cabeceraIzquierda() {
        Label jLabelTurno = new Label("Turno de " + jugada.obtenerJugador().nombre());
        jLabelTurno.setOpacity(100);
        jLabelTurno.setStyle("-fx-text-fill: #9A31E1; -fx-font-size: 18;");

        return jLabelTurno;
    }

    @Override
    protected Node centro() {
        VBox vbox = new VBox(100);
        vbox.setPadding(new Insets(100));
        Label jLabelTipoPregunta = new Label(jugada.obtenerPregunta().getClass().getSimpleName());
        jLabelTipoPregunta.setAlignment(Pos.CENTER);
        jLabelTipoPregunta.setStyle("-fx-text-fill: #9A31E1; -fx-font-size: 18; -fx-font-weight: bold");

        Label jLabelTituloPregunta = new Label(jugada.tituloPregunta());
        jLabelTituloPregunta.setAlignment(Pos.CENTER);
        jLabelTituloPregunta.setStyle("-fx-text-fill: #9A31E1; -fx-font-size: 24; -fx-font-weight: bold");

        vbox.getChildren().addAll(jLabelTipoPregunta, jLabelTituloPregunta);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }
}