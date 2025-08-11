package envivotickets.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SistemaEventosTest {

    FabricaEventos fabrica;
    NotificadorEventos notificador;
    SeccionAsientos seccion;
    Asiento asiento1, asiento2;

    @BeforeEach
    void setUp() {
        fabrica = new FabricaEventosConcreta();
        notificador = new NotificadorEventos();
        asiento1 = new Asiento("A1", 50, EstadoDisponibilidad.DISPONIBLE);
        asiento2 = new Asiento("A2", 70, EstadoDisponibilidad.AGOTADO);
        seccion = new SeccionAsientos("VIP");
    }

    // TC001
    @Test
    void testCrearEventoValido() {
        Evento e = fabrica.crearEvento("teatro");
        assertNotNull(e);
        assertTrue(e instanceof EventoTeatro);
    }

    // TC002
    @Test
    void testCrearEventoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> fabrica.crearEvento("TipoInexistente"));
    }

    // TC003
    @Test
    void testObtenerDetallesEvento() {
        Evento e = new EventoStandUp();
        String detalles = e.obtenerDetalles();
        assertTrue(detalles.toLowerCase().contains("stand-up") || detalles.toLowerCase().contains("stand up"));
    }

    // TC004
    @Test
    void testObtenerPoliticaPrecios() {
        Evento e = new EventoTeatro();
        PoliticaPrecios politica = e.obtenerPoliticaPrecios();
        assertNotNull(politica);
        assertEquals(50, politica.obtenerPrecioBase());
    }

    // TC005
    @Test
    void testAgregarObservador() {
        Usuario usuario = new Usuario("Carlos");
        notificador.agregarObservador(usuario);
        assertTrue(getObservadoresInternos().contains(usuario));
    }

    // TC006
    @Test
    void testRemoverObservador() {
        Usuario usuario = new Usuario("Carlos");
        notificador.agregarObservador(usuario);
        notificador.removerObservador(usuario);
        assertFalse(getObservadoresInternos().contains(usuario));
    }

    // TC007
    @Test
    void testNotificarObservadores() {
        Usuario u1 = new Usuario("Carlos");
        Administrador a1 = new Administrador("Laura");
        notificador.agregarObservador(u1);
        notificador.agregarObservador(a1);
        // Aquí no tenemos un "estado" que se actualice, así que validamos que no lance errores
        assertDoesNotThrow(() -> notificador.notificarObservadores("Cambio de horario"));
    }

    // TC008
    @Test
    void testActualizarObservador() {
        Usuario usuario = new Usuario("Ana");
        assertDoesNotThrow(() -> usuario.actualizar("Evento cancelado"));
    }

    // TC009
    @Test
    void testAgregarComponenteAsiento() {
        seccion.agregar(asiento1);
        assertEquals(50, seccion.obtenerPrecio());
    }

    // TC010
    @Test
    void testRemoverComponenteAsiento() {
        seccion.agregar(asiento1);
        seccion.remover(asiento1);
        assertEquals(0, seccion.obtenerPrecio());
    }

    // TC011
    @Test
    void testObtenerPrecioComposite() {
        seccion.agregar(asiento1);
        seccion.agregar(asiento2);
        assertEquals(120, seccion.obtenerPrecio());
    }

    // TC012
    @Test
    void testDisponibilidadComposite() {
        seccion.agregar(asiento1);
        assertEquals(EstadoDisponibilidad.DISPONIBLE, seccion.obtenerDisponibilidad());
    }

    // TC013
    @Test
    void testPrecioAsiento() {
        Asiento asiento = new Asiento("B1", 80, EstadoDisponibilidad.DISPONIBLE);
        assertEquals(80, asiento.obtenerPrecio());
    }

    // TC014
    @Test
    void testDisponibilidadAsiento() {
        Asiento asiento = new Asiento("B2", 60, EstadoDisponibilidad.AGOTADO);
        assertEquals(EstadoDisponibilidad.AGOTADO, asiento.obtenerDisponibilidad());
    }

    // Método auxiliar para acceder a la lista interna de observadores usando reflexión
    @SuppressWarnings("unchecked")
    private List<Observador> getObservadoresInternos() {
        try {
            var field = NotificadorEventos.class.getDeclaredField("observadores");
            field.setAccessible(true);
            return (List<Observador>) field.get(notificador);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
