package envivotickets.test;
public interface Sujeto {
    void agregarObservador(Observador o);
    void removerObservador(Observador o);
    void notificarObservadores(String mensaje);
}