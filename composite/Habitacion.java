package composite;

/**
 * 
 */
public class Habitacion {

    /**
     * Default constructor
     */
    public Habitacion(int id, String tipoHabitacion) {
        this.id = id;
        this.tipoHabitacion = tipoHabitacion;
    }

    public String[] getDecoracionBase() {
        return decoracionBase;
    }

    public void agregarMejora(Mejora mejora){

    }

    public void eliminarMejora(Mejora mejora){

    }

    String[] decoracionBase= {"sabanas basico", "arreglo de mesa basico"};

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public String tipoHabitacion;

}