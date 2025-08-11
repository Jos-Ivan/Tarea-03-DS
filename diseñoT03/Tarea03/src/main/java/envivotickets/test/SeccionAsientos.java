package envivotickets.test;
import java.util.ArrayList;
import java.util.List;
public class SeccionAsientos implements ComponenteAsiento {
    private final String nombre;
    private final List<ComponenteAsiento> componentes = new ArrayList<>();
    public SeccionAsientos(String nombre) {
        this.nombre = nombre;
    }
    public void agregar(ComponenteAsiento c) {
        componentes.add(c);
    }
    public void remover(ComponenteAsiento c) {
        componentes.remove(c);
    }
    @Override
    public double obtenerPrecio() {
        return componentes.stream().mapToDouble(ComponenteAsiento::obtenerPrecio).sum();
    }
    @Override
    public EstadoDisponibilidad obtenerDisponibilidad() {
        boolean todosAgotados = componentes.stream()
            .allMatch(c -> c.obtenerDisponibilidad() == EstadoDisponibilidad.AGOTADO);
        return todosAgotados ? EstadoDisponibilidad.AGOTADO : EstadoDisponibilidad.DISPONIBLE;
    }
}