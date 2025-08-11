package envivotickets.test;
public class EventoMicroTeatro implements Evento {
    @Override
    public String obtenerDetalles() {
        return "MicroTeatro: obras cortas en espacios pequeños.";
    }
    @Override
    public PoliticaPrecios obtenerPoliticaPrecios() {
        return new PoliticaPreciosBasica(20);
    }
}