package edu.fiuba.algo3.vista.escenas.prejuego;

import edu.fiuba.algo3.controladores.CargarPreguntaControlador;
import edu.fiuba.algo3.modelo.juego.Pregunta;
import edu.fiuba.algo3.vista.componentes.botones.BotonEtiquetaDerechaVista;
import edu.fiuba.algo3.vista.componentes.preguntas.PreguntaBarraVista;
import edu.fiuba.algo3.vista.componentes.botones.BotonCuadradoVista;
import edu.fiuba.algo3.vista.componentes.botones.BotonEtiquetaIzquierdaVista;
import edu.fiuba.algo3.vista.escenas.EstructuraPrincipalVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CargarPreguntasVista extends EstructuraPrincipalVista {

    private VBox contenedorPreguntas;
    private final CargarPreguntaControlador controlador;

    public CargarPreguntasVista(CargarPreguntaControlador controlador) {
        this.controlador = controlador;
    }

    @Override
    protected Node cabeceraDerecha() {
        return new BotonEtiquetaIzquierdaVista("JUGADORES");
    }

    @Override
    protected Node cabeceraIzquierda() {
        return new BotonEtiquetaDerechaVista("INICIO");
    }

    @Override
    protected Node centro() {
        VBox area = new VBox();

        VBox subContenedor = new VBox();
        String estilo = "-fx-border-radius: 2;";
        estilo += "-fx-background-radius: 2;";
        estilo += "-fx-border-width: 1;";
        estilo += "-fx-border-color: #999;";
        estilo += "-fx-background-color: white;";
        subContenedor.setStyle(estilo);

        subContenedor.getChildren().addAll(
                this.cabeceraSubContenedor(),
                this.contenedorPreguntas()
        );

        VBox.setMargin(subContenedor, new Insets(20, 20, 20, 20));
        area.getChildren().add(subContenedor);

        return area;
    }

    public void actualizarPreguntas(ArrayList<Pregunta> preguntas) {
        this.contenedorPreguntas.getChildren().clear();

        for (Pregunta pregunta: preguntas) {
            this.contenedorPreguntas.getChildren().add(
                    this.preguntaVista(pregunta)
            );
        }

        if (preguntas.size() == 0) {
            Label textoSinPreguntas = new Label("No hay preguntas seleccionadas");
            textoSinPreguntas.setPadding(new Insets(10, 10, 10, 10));

            this.contenedorPreguntas.getChildren().add(textoSinPreguntas);
        }
    }

    private Node cabeceraSubContenedor() {
        HBox cabecera = new HBox();

        String estilo = "-fx-border-width: 0 0 1 0;";
        estilo += "-fx-border-color: #999";
        cabecera.setStyle(estilo);
        cabecera.setPadding(new Insets(0, 10, 0, 10));
        cabecera.setPrefHeight(60);
        cabecera.setAlignment(Pos.CENTER_LEFT);

        Label tituloIzuiquirda = new Label("Agrege las Preguntas");
        String estiloTitulo = "-fx-font-weight: bold;";
        estiloTitulo += "-fx-font-size: 20;";
        estiloTitulo += "-fx-text-fill: #999;";
        tituloIzuiquirda.setStyle(estiloTitulo);

        Pane separador = new Pane();
        HBox.setHgrow(separador, Priority.ALWAYS);

        BotonCuadradoVista botonCargarJson = new BotonCuadradoVista("Cargar Json");
        botonCargarJson.setOnAction((event)-> this.controlador.cargarJson());

        cabecera.getChildren().addAll(
                tituloIzuiquirda,
                separador,
                botonCargarJson
        );

        return cabecera;
    }

    private ScrollPane contenedorPreguntas() {
        this.contenedorPreguntas = new VBox();
        this.contenedorPreguntas.setAlignment(Pos.TOP_CENTER);

        this.actualizarPreguntas(new ArrayList<>());

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(contenedorPreguntas);

        String estilo = "-fx-background-color: white;";
        estilo += "-fx-background: white";
        scrollPane.setStyle(estilo);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(400);

        return scrollPane;
    }

    private Node preguntaVista(Pregunta pregunta) {
        HBox barra = new HBox();
        String estilo = "-fx-border-width: 0 0 1 0";
        barra.setStyle(estilo);
        barra.setPadding(new Insets(10, 10, 10, 10));
        barra.setSpacing(5);

        BotonCuadradoVista botonSubir = new BotonCuadradoVista("subir");
        botonSubir.setOnAction((event) -> this.controlador.subirPregunta(pregunta));

        BotonCuadradoVista botonBajar = new BotonCuadradoVista("bajar");
        botonBajar.setOnAction((event) -> this.controlador.bajarPregunta(pregunta));

        PreguntaBarraVista barraPregunta = new PreguntaBarraVista(pregunta);

        Pane separador = new Pane();
        HBox.setHgrow(separador, Priority.ALWAYS);

        BotonCuadradoVista botonBorrar = new BotonCuadradoVista("borrar");
        botonBorrar.setOnAction((event) -> this.controlador.borrarPregunta(pregunta));

        barra.getChildren().addAll(
                botonSubir,
                botonBajar,
                barraPregunta,
                separador,
                botonBorrar
        );

        return barra;
    }
}