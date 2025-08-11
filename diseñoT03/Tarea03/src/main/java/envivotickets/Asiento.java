package envivotickets;
public class Asiento implements ComponenteAsiento {
    private final String numero;
    private final double precio;
    private EstadoDisponibilidad estado;
    public Asiento(String numero, double precio, EstadoDisponibilidad estado) {
        this.numero = numero;
        this.precio = precio;
        this.estado = estado;
    }
    @Override
    public double obtenerPrecio() {
        return precio;
    }
    @Override
    public EstadoDisponibilidad obtenerDisponibilidad() {
        return estado;
    }
    public void setEstado(EstadoDisponibilidad estado) {
        this.estado = estado;
    }
}