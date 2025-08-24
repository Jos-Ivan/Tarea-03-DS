/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package envivotickets.test;

/**
 *
 * @author angel
 */
public class Tarea03 {
    public static void main(String[] args) {
        FabricaEventos fabrica = new FabricaEventosConcreta();
        Evento evento = fabrica.crearEvento("teatro");
        System.out.println(evento.obtenerDetalles());
        System.out.println("Precio base: " + evento.obtenerPoliticaPrecios().obtenerPrecioBase());

        // Creacion y verificacion de Eventos completada (Texto para reducir Clase en partes)
        NotificadorEventos notificador = new NotificadorEventos();
        Usuario u1 = new Usuario("Miguel");
        Administrador admin = new Administrador("Laura");
        notificador.agregarObservador(u1);
        notificador.agregarObservador(admin);
        notificador.notificarObservadores("Cambio de horario del evento.");
        //Acciones de Notifier
        Asiento a1 = new Asiento("A1", 50, EstadoDisponibilidad.DISPONIBLE);
        Asiento a2 = new Asiento("A2", 50, EstadoDisponibilidad.AGOTADO);
        SeccionAsientos vip = new SeccionAsientos("VIP");
        vip.agregar(a1);
        vip.agregar(a2);
        System.out.println("Precio total sección VIP: " + vip.obtenerPrecio());
        System.out.println("Disponibilidad: " + vip.obtenerDisponibilidad());
        // Verificacion del sistema
    }
}
