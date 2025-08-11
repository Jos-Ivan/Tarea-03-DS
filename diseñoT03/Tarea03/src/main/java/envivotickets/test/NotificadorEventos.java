package envivotickets.test;
import java.util.ArrayList;
import java.util.List;
public class NotificadorEventos implements Sujeto {
    private final List<Observador> observadores = new ArrayList<>();
    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }
    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }
    @Override
    public void notificarObservadores(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }
}