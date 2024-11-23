package command;

/**
 * 
 */
public abstract class Accion {

    /**
     * Default constructor
     */
    public Accion() {
    }

    /**
     * 
     */
    public Tarea tarea;

    /**
     * 
     */
    private Dashboard dashboard;

    /**
     * 
     */
    public abstract void ejecutar();

    /**
     * 
     */
    public void guardarBackup() {
        // TODO implement here
    }

    /**
     * 
     */
    public void deshacerAccion() {
        // TODO implement here
    }

}