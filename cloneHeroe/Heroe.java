import java.util.ArrayList;
import java.util.List;

class Heroe implements Cloneable {
  private String nombre;
  private String clase;
  private String aspectoVisual;
  private int experiencia;
  private int nivel;
  private int puntosHabilidad;
  private List<Habilidad> habilidades;

  // Constructor
  public Heroe(String nombre, String clase, String aspectoVisual, int experiencia, int nivel, int puntosHabilidad) {
    this.nombre = nombre;
    this.clase = clase;
    this.aspectoVisual = aspectoVisual;
    this.experiencia = experiencia;
    this.nivel = nivel;
    this.puntosHabilidad = puntosHabilidad;
    this.habilidades = new ArrayList<>();
  }

  // Método para añadir habilidades al héroe
  public void addHabilidad(Habilidad habilidad) {
    habilidades.add(habilidad);
  }

  // Implementación del método clone para clonar el héroe
  @Override
  public Heroe clone() {
    try {
      Heroe clon = (Heroe) super.clone();
      clon.habilidades = new ArrayList<>(this.habilidades); // Copia profunda de habilidades
      return clon;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError("Error de clonación");
    }
  }

  // Métodos de personalización para el héroe clonado
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setAspectoVisual(String aspectoVisual) {
    this.aspectoVisual = aspectoVisual;
  }

  // Representación del héroe en texto para visualizar su estado
  @Override
  public String toString() {
      return "Heroe{" +
              "nombre='" + nombre + '\'' +
              ", clase='" + clase + '\'' +
              ", aspectoVisual='" + aspectoVisual + '\'' +
              ", experiencia=" + experiencia +
              ", nivel=" + nivel +
              ", puntosHabilidad=" + puntosHabilidad +
              ", habilidades=" + habilidades +
              '}';
  }
}