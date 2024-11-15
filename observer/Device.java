package observer;

class Device implements Observer {
  private String deviceName;

  public Device(String deviceName) {
      this.deviceName = deviceName;
  }

  @Override
  public void update(String message) {
      System.out.println("[" + deviceName + "] Nuevo mensaje recibido: " + message);
  }
}