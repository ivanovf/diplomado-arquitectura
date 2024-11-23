package com.example.Logica;

public class CircuitBreaker {

    private enum Estado {
        CERRADO, ABIERTO, SEMI_ABIERTO
    }

    private Estado estado = Estado.CERRADO;
    private int fallos = 0;
    private static final int LIMITE_FALLOS = 3;
    private static final int TIEMPO_ESPERA = 5000; // Tiempo en milisegundos para esperar cuando está semi-abierto
    private long ultimoTiempoDeFallos = 0;

    public boolean estaOperando() {
        if (estado == Estado.ABIERTO) {
            if (System.currentTimeMillis() - ultimoTiempoDeFallos > TIEMPO_ESPERA) {
                estado = Estado.SEMI_ABIERTO;
            } else {
                return false; // No puede operar si el circuito está abierto
            }
        }

        return estado != Estado.ABIERTO;
    }

    public void fallo() {
        fallos++;
        if (fallos >= LIMITE_FALLOS) {
            estado = Estado.ABIERTO;
            ultimoTiempoDeFallos = System.currentTimeMillis();
        }
    }

    public void exito() {
        fallos = 0;
        if (estado == Estado.SEMI_ABIERTO) {
            estado = Estado.CERRADO; // Si el servicio vuelve a funcionar correctamente, cierra el circuito
        }
    }
}
