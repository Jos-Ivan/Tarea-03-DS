package envivotickets.test;
public interface Sujeto {
    void agregarObservador(Observador o);
    // Se cambia la abstraccion, no es necesario en este caso por soporte de notificaciones
    void removerObservador(Observador o);
    void notificarObservadores(String mensaje);
}   
