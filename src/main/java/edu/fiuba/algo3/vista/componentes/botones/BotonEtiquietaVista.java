package edu.fiuba.algo3.vista.componentes.botones;

import edu.fiuba.algo3.vista.componentes.Componente;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class BotonEtiquietaVista implements Componente {

    private Node nodo;
    private String titulo;

    public BotonEtiquietaVista(String titulo, Boolean etiquetaIzquierda) {
        this.titulo = titulo;

        this.aplicarEstilo(etiquetaIzquierda);
    }

    private void aplicarEstilo(Boolean etiquetaIzquierda) {
        StackPane contenedor = new StackPane();

        if (etiquetaIzquierda) { contenedor.setAlignment(Pos.CENTER_RIGHT);
        } else { contenedor.setAlignment(Pos.CENTER_LEFT); }

        contenedor.getChildren().add(this.etiqueta(etiquetaIzquierda));
        contenedor.getChildren().add(this.boton(etiquetaIzquierda));

        this.nodo = contenedor;
    }

    private Node etiqueta(Boolean etiquetaIzquierda) {
        StackPane etiqueta = new StackPane();

        etiqueta.setMaxHeight(40);
        etiqueta.setMaxWidth(250);
        etiqueta.setPadding(new Insets(5, 5, 5, 5));
        etiqueta.setStyle("-fx-border-radius: 2;-fx-border-color: grey; -fx-background-radius: 2; -fx-background-color: white");

        if (etiquetaIzquierda) {
            etiqueta.setTranslateX(-10);
            etiqueta.setAlignment(Pos.CENTER_LEFT);
        } else {
            etiqueta.setTranslateX(10);
            etiqueta.setAlignment(Pos.CENTER_RIGHT);
        }

        Label texto = new Label(this.titulo);
        etiqueta.getChildren().add(texto);

        return etiqueta;
    }

    private Node boton(Boolean etiquetaIzquierda) {
        BotonCircularVista boton;

        if (etiquetaIzquierda) { boton =  BotonCircularVista.crearFlechaSiguiente(); }
        else { boton = BotonCircularVista.crearFlechaAntras(); }

        boton.activar();

        return boton.obtenerNodo();
    }

    @Override
    public Node obtenerNodo() {
        return this.nodo;
    }
}