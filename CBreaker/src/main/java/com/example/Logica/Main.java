package CBreaker.src.main.java.com.example.Logica;
public class Main {

	public static void main(String[] args) {
			
			ScoreCredito scoreCredito = new ScoreCredito();
			
			// Simulando varias llamadas al servicio para ver cÛmo se comporta el Circuit Breaker
			System.out.println("Primer intento (debe ser exitoso):");
			int puntaje1 = scoreCredito.valorAprobado("Juan PÈrez", 123456, 1500);
			System.out.println("Puntaje: " + puntaje1);

			// Simulamos que el servicio falla
			System.out.println("\nIntentando con un valor de prÈstamo incorrecto (falla el servicio):");
			scoreCredito.valorAprobado("Juan PÈrez", 123456, -500);

			// Simulamos el servicio fuera de lÌnea por varios intentos
			System.out.println("\nIntentos fallidos, el circuito est· abierto (el servicio se cae):");
			for (int i = 0; i < 4; i++) {
					scoreCredito.valorAprobado("Juan PÈrez", 123456, -500); // Fallando el servicio
			}

			// Simulamos que el servicio se recupere despuÈs de un tiempo
			System.out.println("\nEsperando a que el servicio se recupere...");
			try {
					Thread.sleep(6000); // Esperamos m·s de 5 segundos para permitir que el circuito se recupere
			} catch (InterruptedException e) {
					e.printStackTrace();
			}

			System.out.println("\nIntento despuÈs de recuperaciÛn del servicio:");
			int puntaje2 = scoreCredito.valorAprobado("Juan PÈrez", 123456, 1500);
			System.out.println("Puntaje: " + puntaje2);
	}
}
