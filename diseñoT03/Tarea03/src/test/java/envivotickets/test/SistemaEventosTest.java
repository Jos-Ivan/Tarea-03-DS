package envivotickets.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void TC01_NotificadorEventos_AgregarYRemoverObservadores() {
        NotificadorEventos notificador = new NotificadorEventos();
        Usuario u = new Usuario("Juan");
        Administrador admin = new Administrador("Laura");

        notificador.agregarObservador(u);
        notificador.agregarObservador(admin);
        notificador.removerObservador(u);

        // Solo debe quedar el administrador
        assertDoesNotThrow(() -> notificador.notificarObservadores("Mensaje de prueba"));
    }

    @Test
    void TC02_FabricaEventosConcreta_EventoInvalido() {
        FabricaEventosConcreta fabrica = new FabricaEventosConcreta();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            fabrica.crearEvento("concierto");
        });
        assertTrue(ex.getMessage().contains("Tipo de evento no soportado"));
    }

    @Test
    void TC03_Asiento_CambioEstado() {
        Asiento asiento = new Asiento("A1", 50, EstadoDisponibilidad.DISPONIBLE);
        asiento.setEstado(EstadoDisponibilidad.RESERVADO);
        assertEquals(EstadoDisponibilidad.RESERVADO, asiento.obtenerDisponibilidad());
    }

    @Test
    void TC04_SeccionAsientos_CalculoDisponibilidad() {
        Asiento a1 = new Asiento("A1", 50, EstadoDisponibilidad.DISPONIBLE);
        Asiento a2 = new Asiento("A2", 50, EstadoDisponibilidad.AGOTADO);
        SeccionAsientos vip = new SeccionAsientos("VIP");
        vip.agregar(a1);
        vip.agregar(a2);
        assertEquals(EstadoDisponibilidad.DISPONIBLE, vip.obtenerDisponibilidad());
    }

    @Test
    void TC05_SeccionAsientos_TodosAgotados() {
        SeccionAsientos general = new SeccionAsientos("General");
        general.agregar(new Asiento("G1", 20, EstadoDisponibilidad.AGOTADO));
        general.agregar(new Asiento("G2", 20, EstadoDisponibilidad.AGOTADO));
        general.agregar(new Asiento("G3", 20, EstadoDisponibilidad.AGOTADO));
        assertEquals(EstadoDisponibilidad.AGOTADO, general.obtenerDisponibilidad());
    }

    @Test
    void TC06_PoliticaPreciosBasica_ValorCorrecto() {
        PoliticaPreciosBasica politica = new PoliticaPreciosBasica(25);
        assertEquals(25, politica.obtenerPrecioBase());
    }
}
