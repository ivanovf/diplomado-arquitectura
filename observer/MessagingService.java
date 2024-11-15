package observer;

import java.util.ArrayList;
import java.util.List;

class MessagingService implements Subject {
  private List<Observer> observers = new ArrayList<>();

  @Override
  public void registerObserver(Observer observer) {
      observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
      observers.remove(observer);
  }

  @Override
  public void notifyObservers(String message) {
      for (Observer observer : observers) {
          observer.update(message);
      }
  }

  public void receiveMessage(String message) {
      System.out.println("Mensaje recibido en el sistema de mensajería: " + message);
      notifyObservers(message);
  }
}