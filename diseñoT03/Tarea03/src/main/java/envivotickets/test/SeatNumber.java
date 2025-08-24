package envivotickets.test;
public final class SeatNumber {
    private final String value;
    public SeatNumber(String v) {
        if (v == null || !v.matches("[A-Z]\d{1,2}"))
            throw new IllegalArgumentException("Número de asiento inválido");
        this.value = v;
    }
    public String toString(){ return value; }
}
