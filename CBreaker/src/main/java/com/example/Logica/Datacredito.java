package CBreaker.src.main.java.com.example.Logica;

public class Datacredito {

    public int obtenerPuntaje(int identificacion, int valorPrestamo) {
        // Simula la lógica del servicio externo
        if (valorPrestamo > 1000) {
            return 450; // Si el préstamo es mayor a 1000, el puntaje es 450
        } else {
            return 800; // Si el préstamo es menor o igual a 1000, el puntaje es 800
        }
    }
}
