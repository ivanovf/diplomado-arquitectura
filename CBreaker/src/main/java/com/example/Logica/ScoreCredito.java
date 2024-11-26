package CBreaker.src.main.java.com.example.Logica;

public class ScoreCredito {

    private Datacredito datacredito = new Datacredito();
    private CircuitBreaker circuitBreaker = new CircuitBreaker();

    public int valorAprobado(String nombreCliente, int identificacion, int valorPrestamo) {
        System.out.println("Validando datos de cliente: " + nombreCliente);

        // Lógica para validar datos del cliente (este ejemplo siempre devuelve un valor aprobado)
        if (valorPrestamo <= 0) {
            System.out.println("El valor del préstamo debe ser mayor a 0.");
            return 0; // Rechazamos la solicitud si el valor del préstamo es 0 o negativo
        }

        return puntaje(identificacion, valorPrestamo); // Valida puntaje
    }

    public int puntaje(int identificacion, int valorPrestamo) {
        if (!circuitBreaker.estaOperando()) {
            System.out.println("El servicio está fuera de línea. No se puede obtener el puntaje.");
            return -1; // Retorna -1 si el servicio está caído
        }

        try {
            // Simulando llamada al servicio externo
            int puntaje = datacredito.obtenerPuntaje(identificacion, valorPrestamo);
            circuitBreaker.exito(); // Si la llamada es exitosa, se resetea el contador de fallos
            return puntaje;
        } catch (Exception e) {
            circuitBreaker.fallo(); // Si hay un fallo, se incrementa el contador de fallos
            System.out.println("Error al obtener el puntaje: " + e.getMessage());
            return -1; // Retorna -1 si el servicio falla
        }
    }
}
