package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class MultipleChoiceParcial implements Pregunta {

    private String titulo;
    private ArrayList<Opcion> opciones = new ArrayList<>();
    private Respuesta respuestaActual;
    private Integer segundos;

    public MultipleChoiceParcial(String titulo, Integer segundos) throws PreguntaError {
        if (segundos < 0){
            throw new PreguntaError("Los segundos no pueden ser negativos");
        }
        this.segundos = segundos;
        this.titulo = titulo;
    }

    public void agregarOpcionCorrecta(String opcionTitulo) throws PreguntaError {
        if (this.opciones.size() == 5){
            throw new PreguntaError("Se alcanzo el maximo de opciones para esta pregunta");
        }
        Opcion opcion = new Opcion(opcionTitulo, 1);
        this.opciones.add(opcion);
    }

    public void agregarOpcionIncorrecta(String opcionTitulo) throws PreguntaError {
        if (this.opciones.size() == 5){
            throw new PreguntaError("Se alcanzo el maximo de opciones para esta pregunta");
        }
        Opcion opcion = new Opcion(opcionTitulo, 0);
        this.opciones.add(opcion);
    }

    public String obtenerTitulo() {
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
    public void seleccionarOpcion(Opcion opcion) throws PreguntaError, RespuestaError {
        this.respuestaActual.agregarOpcion(opcion);
    }

    @Override
    public Respuesta confirmar() throws PreguntaError {
        Respuesta resultado = this.respuestaActual;
        this.respuestaActual = null;
        return resultado;
    }

    @Override
    public Integer puntajeConOpciones(ArrayList<Opcion> opciones) {
        if (opciones.size() == 0){
            return 0;
        }
        Integer puntajeParcial = 0;
        for (Opcion opcion : opciones){
            puntajeParcial = puntajeParcial + opcion.getValor();
        }
        if (puntajeParcial != opciones.size()) {
            return 0;
        }
        return puntajeParcial;
    }

    @Override
    public void extraerOpciones(JsonObject object) throws PreguntaError {
        JsonArray opcionesCorrectas = object.getAsJsonArray("opcionesCorrectas");
        if (opcionesCorrectas == null) { throw new PreguntaError("Formato de opciones no soportado."); }
        JsonArray opcionesIncorrectas = object.getAsJsonArray("opcionesIncorrectas");
        if (opcionesIncorrectas == null) { throw new PreguntaError("Formato de opciones no soportado."); }

        for (JsonElement opcion: opcionesCorrectas){
            agregarOpcionCorrecta(opcion.getAsString());
        }
        for (JsonElement opcion: opcionesIncorrectas){
            agregarOpcionIncorrecta(opcion.getAsString());
        }
        //System.out.println("MCParcial");
    }
}
