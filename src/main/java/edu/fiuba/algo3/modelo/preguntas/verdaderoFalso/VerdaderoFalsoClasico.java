package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.PreguntaError;
import edu.fiuba.algo3.modelo.excepciones.RespuestaError;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Opcion;
import edu.fiuba.algo3.modelo.juego.Pregunta;
import edu.fiuba.algo3.modelo.juego.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.estados.Penalidad;
import edu.fiuba.algo3.modelo.util.punto.Punto;
import edu.fiuba.algo3.modelo.util.punto.PuntoNulo;
import edu.fiuba.algo3.modelo.util.punto.PuntoPositivo;

import java.util.ArrayList;

public class VerdaderoFalsoClasico extends Pregunta {

    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;
    private String titulo;
    private Respuesta respuestaActual;
    private Integer segundos;
    protected ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();

    public VerdaderoFalsoClasico(String titulo, Penalidad penalidad) throws PreguntaError {
        super(titulo,penalidad);
        if (segundos < 0){
            throw new PreguntaError("Los segundos no pueden ser negativos");
        }
        this.opcionCorrecta = null;
        this.opcionIncorrecta = null;
        /*this.titulo = pregunta;
        this.segundos = segundos;*/
    }

    public void agregarOpcionCorrecta(String opcionTitulo) throws PreguntaError {
        if (opcionCorrecta != null){
            throw new PreguntaError("Ya existe una opcion correcta");
        }
        this.opcionCorrecta = new Opcion(opcionTitulo, new PuntoPositivo());
        this.opcionesCorrectas.add(opcionCorrecta);
    }

    public void agregarOpcionIncorrecta(String opcionTitulo) throws PreguntaError {
        if (opcionIncorrecta != null){
            throw new PreguntaError("Ya existe una opcion incorrecta");
        }
        this.opcionIncorrecta = new Opcion(opcionTitulo, new PuntoNulo());
    }

    /*@Override
    public void iniciar(Jugador jugador) throws PreguntaError {
        if (this.opcionCorrecta == null || this.opcionIncorrecta == null) {
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
    public void seleccionarOpcion(Opcion opcion) throws PreguntaError {
        try {
            this.respuestaActual.agregarOpcion(opcion);
        } catch (RespuestaError respuestaError) {
            throw new PreguntaError("No se puede agregar la opcion: " + respuestaError.getMessage());
        }
    }

    @Override
    public Respuesta confirmar() {
        Respuesta resultado = this.respuestaActual;
        this.respuestaActual = null;
        return resultado;
    }*/

    @Override
    public Punto puntajeConOpciones(ArrayList<Opcion> opciones) {
        if (opciones.size() == 0){
            return new PuntoNulo();
        }
        return opciones.get(0).obtenerPunto();
    }

    @Override
    public ArrayList<Opcion> obtenerOpciones() {
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(this.opcionCorrecta);
        opciones.add(this.opcionIncorrecta);
        return opciones;
    }

    /*public String titulo() {
        return this.titulo;
    }*/
}