package envivotickets.test;
public class FabricaEventosConcreta extends FabricaEventos {
    @Override
    public Evento crearEvento(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "teatro" -> new EventoTeatro();
            case "standup" -> new EventoStandUp();
            case "microteatro" -> new EventoMicroTeatro();
                // Si se quiere agregar una nueva Agrigar AQUI ()
            default -> throw new IllegalArgumentException("Tipo de evento no soportado: " + tipo);
        };
    }
}
