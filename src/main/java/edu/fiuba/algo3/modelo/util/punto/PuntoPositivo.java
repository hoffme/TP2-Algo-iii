package edu.fiuba.algo3.modelo.util.punto;

import edu.fiuba.algo3.modelo.excepciones.punto.PuntoError;

//Hoja
public class PuntoPositivo extends Punto {

    private final Integer valor = 1;

    @Override
    public Punto obtenerPunto() {
        return this;
    }

    @Override
    public Integer obtenerValor() {
        return this.valor;
    }

    @Override
    public Punto copiar() { return this.clone(); }

    @Override
    public PuntoPositivo clone() { return new PuntoPositivo(); }
}
