public class Jugador {

    private String nombre;
    private int partidasGanadas;
    private int partifasJugadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidasGanadas = 1;
        this.partifasJugadas = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public int getPartifasJugadas() {
        return partifasJugadas;
    }

    public void setPartidasGanadas() {
        this.partidasGanadas++;
    }

    public void setPartifasJugadas() {
        this.partifasJugadas++;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + "\n" +
                "partidasGanadas: " + this.getPartidasGanadas() + "\n" +
                "partifasJugadas: " + this.getPartifasJugadas() + "\n";
    }
}
