package envivotickets.test;
public class EventoStandUp implements Evento {
    @Override
    public String obtenerDetalles() {
        return "Show de Stand-Up Comedy.";
    }
    @Override
    public PoliticaPrecios obtenerPoliticaPrecios() {
        return new PoliticaPreciosBasica(30);
    }
}