package envivotickets.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificadorEventos implements Sujeto {

    private final List<Observador> observadores = new ArrayList<>();

    @Override
    public synchronized void agregarObservador(Observador o) {
        if (o != null && !observadores.contains(o)) {
            observadores.add(o);
        }
    }

    @Override
    public synchronized void removerObservador(Observador o) {
        observadores.remove(o);
    }

    // Encapsulamos la colección: devolvemos una copia inmutable
    public synchronized List<Observador> getObservadoresSnapshot() {
        return Collections.unmodifiableList(new ArrayList<>(observadores));
    }

    @Override
    public synchronized void notificarObservadores(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }
}
