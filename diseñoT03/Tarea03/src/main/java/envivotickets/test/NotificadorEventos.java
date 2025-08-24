package envivotickets.test;
import java.util.ArrayList;
import java.util.List;
public class NotificadorEventos implements Sujeto {
    private final List<Observador> observadores = new ArrayList<>();
    private final List<Observador> observadores = new ArrayList<>();

    public synchronized void addObserver(Observador o) { observadores.add(o); }
    public synchronized void removeObserver(Observador o) { observadores.remove(o); }

    public List<Observador> getObserversSnapshot() {
        return Collections.unmodifiableList(new ArrayList<>(observadores));
    }

    private void notifyAllObservers(Event e) {
        for (Observador o : getObserversSnapshot()) o.actualizar(e);
    }

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
