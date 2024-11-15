public class Main {
  public static void main(String[] args) {
    // Crear un héroe base de tipo guerrero
    Heroe guerrero = new Heroe("Arthas", "Guerrero", "Aspecto Guerrero", 1500,      15, 10);
    guerrero.addHabilidad(new Habilidad("Espada Relámpago", "Ataque"));
    guerrero.addHabilidad(new Habilidad("Escudo de Titanio", "Defensa"));

    // Crear un héroe base de tipo mago
    Heroe mago = new Heroe("Merlín", "Mago", "Aspecto Mago", 1300, 12, 8);
    mago.addHabilidad(new Habilidad("Bola de Fuego", "Magia"));
    mago.addHabilidad(new Habilidad("Invisibilidad", "Magia"));

    // Clonar y personalizar el guerrero
    Heroe clonGuerrero = guerrero.clone();
    clonGuerrero.setNombre("Thorin");
    clonGuerrero.setAspectoVisual("Guerrero Oscuro");

    // Clonar y personalizar el mago
    Heroe clonMago = mago.clone();
    clonMago.setNombre("Gandalf");
    clonMago.setAspectoVisual("Mago Blanco");

    // Imprimir los héroes originales y sus clones
    System.out.println("Héroe Original (Guerrero): " + guerrero);
    System.out.println("Clon del Guerrero: " + clonGuerrero);
    System.out.println("Héroe Original (Mago): " + mago);
    System.out.println("Clon del Mago: " + clonMago);
  }
}

