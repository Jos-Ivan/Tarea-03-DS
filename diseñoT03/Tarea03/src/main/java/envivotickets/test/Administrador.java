package envivotickets.test;
public class Administrador implements Observador {
    private final String nombre;
    public Administrador(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Administrador " + nombre + " recibió: " + mensaje);
    }
}