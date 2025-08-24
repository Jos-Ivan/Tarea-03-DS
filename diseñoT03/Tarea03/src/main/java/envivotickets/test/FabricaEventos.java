package envivotickets.test;
public abstract class FabricaEventos {
    public abstract Evento crearEvento(String tipo);
    //Evento e = new FabricaEventosConcreta().crear("CONCIERTO"); Colocar en Clases Anexas si se quiere remove middle man
}
