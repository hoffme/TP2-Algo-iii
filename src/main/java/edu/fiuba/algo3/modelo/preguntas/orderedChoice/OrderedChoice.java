package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.excepciones.PreguntaError;
import edu.fiuba.algo3.modelo.excepciones.RespuestaError;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.opcion.Opcion;
import edu.fiuba.algo3.modelo.juego.opcion.OpcionClasica;
import edu.fiuba.algo3.modelo.juego.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.penalidad.Penalidad;
import edu.fiuba.algo3.modelo.preguntas.penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.util.punto.Puntaje;
import edu.fiuba.algo3.modelo.util.punto.Punto;
import edu.fiuba.algo3.modelo.util.punto.PuntoNulo;
import edu.fiuba.algo3.modelo.util.punto.PuntoPositivo;

import java.util.ArrayList;

public class OrderedChoice implements Pregunta {
    private String titulo;
    private ArrayList<Opcion> opciones;
    private Respuesta respuestaActual;
    // private Penalidad estadoPenalidad = new SinPenalidad();

    public OrderedChoice(String titulo) {
        this.titulo = titulo;
        this.opciones = new ArrayList<>();
    }

    public void agregarOpcion(String opcionTitulo) throws PreguntaError {
        if (this.opciones.size() == 5) {
            throw new PreguntaError("Se alcanzo el maximo de opciones para esta pregunta");
        }
        this.opciones.add(new OpcionClasica(opcionTitulo, new PuntoNulo()));
    }

    public String titulo() {
        return this.titulo;
    }

    public ArrayList<Opcion> obtenerOpciones() {
        return this.opciones;
    }

    @Override
    public void iniciar(Jugador jugador) throws PreguntaError {
        if (this.opciones.size() < 2) {
            throw new PreguntaError("Cantidad de opciones guardadas invalida");
        }
        if (jugador == null) {
            throw new PreguntaError("Jugador nulo");
        }
        if (this.respuestaActual != null) {
            throw new PreguntaError("No se ha cerrado el ultimo jugador");
        }
        this.respuestaActual = new Respuesta(this, jugador);
    }

    @Override
    public void seleccionarOpcion(Opcion opcion) throws RespuestaError {
        this.respuestaActual.agregarOpcion(opcion);
    }

    @Override
    public Respuesta confirmar() {
        Respuesta resultado = this.respuestaActual;
        this.respuestaActual = null;
        return resultado;
    }

    @Override
    public Punto puntajeConOpciones(ArrayList<Opcion> opciones) {
        if (opciones.size() < this.opciones.size()) {
            return new PuntoNulo();
        }

        for (int i = 0; i < opciones.size(); i++) {
            if (! opciones.get(i).obtenerTitulo().equals(this.opciones.get(i).obtenerTitulo())) {
                return new PuntoNulo();
            }
        }
        return new PuntoPositivo();
    }
}