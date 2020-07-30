package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Composite.Punto;

import java.util.ArrayList;

public class Respuesta {
    protected Pregunta pregunta;
    protected Jugador jugador;
    protected ArrayList<Opcion> opcionesElegidas = new ArrayList<>();

    public Respuesta(Pregunta pregunta, Jugador jugador) {
        this.pregunta = pregunta;
        this.jugador = jugador;
    }

    public void agregarOpcion(Opcion opcion) throws RespuestaError {
        if (this.opcionesElegidas.contains(opcion)){
            throw new RespuestaError(opcion.toString() + "ya fue elegida");
        }
        this.opcionesElegidas.add(opcion);
    }

    public ArrayList<Opcion> obtenerOpcionesElegidas() {
        return new ArrayList<>(this.opcionesElegidas);
    }

    public Punto obtenerPuntaje() throws PreguntaError {
        return this.pregunta.puntajeConOpciones(this.opcionesElegidas);
    }
}
