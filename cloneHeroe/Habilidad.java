import java.util.Objects;

class Habilidad {
    private String nombre;
    private String tipo; // Puede ser Ataque, Defensa, Magia, etc.

    public Habilidad(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Habilidad{" + "nombre='" + nombre + "', tipo='" + tipo + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad habilidad = (Habilidad) o;
        return Objects.equals(nombre, habilidad.nombre) && Objects.equals(tipo, habilidad.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipo);
    }
}
