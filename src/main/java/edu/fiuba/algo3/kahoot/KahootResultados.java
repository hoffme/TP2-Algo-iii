package edu.fiuba.algo3.kahoot;

import edu.fiuba.algo3.eventos.kahoot.CambioEscenaEventHandler;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pregunta;
import edu.fiuba.algo3.vista.escenas.resultados.UltimaLayout;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.ArrayList;

public class KahootResultados extends KahootModo {
    private Juego juego;
    public KahootResultados(Stage stage, ArrayList<Pregunta> preguntas, ArrayList<Jugador> jugadores) {
        super(stage, preguntas, jugadores);
    }

    @Override
    public void iniciar(MediaPlayer reproductor) {
        this.juego = new Juego(this.preguntas, this.jugadores);
        UltimaLayout finalizacion = new UltimaLayout(reproductor,this.jugadores,this.juego);
        finalizacion.eventoSiguiente(this.eventoSalida,"Volver a Jugar");

        new CambioEscenaEventHandler(this.stage, finalizacion).handle(null);
    }
}
