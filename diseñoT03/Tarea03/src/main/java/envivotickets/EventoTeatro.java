package envivotickets;
public class EventoTeatro implements Evento {
    @Override
    public String obtenerDetalles() {
        return "Evento de Teatro con elenco internacional.";
    }
    @Override
    public PoliticaPrecios obtenerPoliticaPrecios() {
        return new PoliticaPreciosBasica(50);
    }
}