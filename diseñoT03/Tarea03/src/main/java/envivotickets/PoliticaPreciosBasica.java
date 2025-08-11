package envivotickets;
public class PoliticaPreciosBasica implements PoliticaPrecios {
    private final double precioBase;
    public PoliticaPreciosBasica(double precioBase) {
        this.precioBase = precioBase;
    }
    @Override
    public double obtenerPrecioBase() {
        return precioBase;
    }
}