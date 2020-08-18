package edu.fiuba.algo3.vista.escenas.preguntas;

import edu.fiuba.algo3.vista.componentes.botones.BotonOpcionClasica;
import edu.fiuba.algo3.modelo.juego.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.opcion.Opcion;
import edu.fiuba.algo3.vista.escenas.controlador.ControladorEscenas;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public abstract class VistaPregunta extends VBox {
    protected ControladorEscenas controlador;
    protected GridPane grid;
    protected ArrayList<BotonOpcionClasica> seleccion = new ArrayList<>();

    protected ArrayList<BotonOpcionClasica> botones = new ArrayList<>();

    public VistaPregunta(Pregunta pregunta, ArrayList<Opcion> opciones, ControladorEscenas controlador) {
        super(20);
        this.controlador = controlador;

        Label indicadorPregunta = new Label(pregunta.obtenerTitulo());
        indicadorPregunta.setStyle("-fx-text-fill: #9A31E1; -fx-font-size: 18; -fx-font-weight: bold");
        indicadorPregunta.setWrapText(true);

        this.grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        grid.setHgap(50);
        rellenarGrilla(opciones);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(indicadorPregunta, grid);

    }

    public ArrayList<BotonOpcionClasica> obtenerBotones(ArrayList<Opcion> opciones) {
        //ArrayList<BotonOpcion> botones = new ArrayList<>();
        for (Opcion opcion : opciones) {
            BotonOpcionClasica boton = new BotonOpcionClasica(opcion, 250, 100);
            botones.add(boton);
        }
        return botones;
    }

    public ArrayList<Opcion> obtenerSeleccion() {
        //System.out.println(botonesSeleccionados);
        ArrayList<Opcion> opcionesSeleccionadas = new ArrayList<>();
        for (BotonOpcionClasica boton: seleccion){
            //System.out.println(boton.obtenerOpcion().obtenerTitulo());
            opcionesSeleccionadas.add(boton.obtenerOpcion());
        }
        return opcionesSeleccionadas;
    }

    public void rellenarGrilla(ArrayList<Opcion> opciones) { }

}