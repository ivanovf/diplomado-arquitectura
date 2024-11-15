package observer;

public class Main {
  public static void main(String[] args) {
    MessagingService messagingService = new MessagingService();

    // Crear dispositivos
    Observer device1 = new Device("Teléfono");
    Observer device2 = new Device("Tablet");
    Observer device3 = new Device("Laptop");

    // Registrar dispositivos
    messagingService.registerObserver(device1);
    messagingService.registerObserver(device2);
    messagingService.registerObserver(device3);

    // Recibir un mensaje y notificar a los dispositivos
    messagingService.receiveMessage("Hola, tienes un nuevo mensaje!");

    // Eliminar un dispositivo y enviar otro mensaje
    messagingService.removeObserver(device2);
    messagingService.receiveMessage("Otro mensaje para tus dispositivos!");
  }
}