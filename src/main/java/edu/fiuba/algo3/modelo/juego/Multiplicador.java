package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.excepciones.ComodinError;

public class Multiplicador {
    private int factor;

    public Multiplicador(int factor) throws ComodinError {
        if (factor == 0)  {
            throw new ComodinError(" Factor del multiplicador nulo invalido ");
        }
        if (factor < 0) {
            throw new ComodinError(" Factor del multiplicador negativo invalido ");
        }
        this.factor = factor;
    }

    public int factor() {
        return this.factor;
    }

    public void asignarA(Respuesta respuesta) throws ComodinError {
        if(respuesta.pregunta().conPenalidad()){
            throw new ComodinError("Aplicacion de comodin invalida");
        }
        respuesta.agregarComodin(this);
    }

}