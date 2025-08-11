package envivotickets.test;
public class Usuario implements Observador {
    private final String nombre;
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Usuario " + nombre + " recibió: " + mensaje);
    }
}