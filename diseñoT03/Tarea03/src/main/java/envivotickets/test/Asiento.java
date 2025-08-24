package envivotickets.test;
public class Asiento implements ComponenteAsiento {
    private final SeatNumber numero;
    private Money precio;
    private EstadoDisponibilidad estado;
    public Asiento(SeatNumber numero, Money precio, SeatState estado) {
        this.numero = numero;
        this.precio = precio;
        this.estado = estado;
    }
    @Override
    public Money obtenerPrecio() {
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
