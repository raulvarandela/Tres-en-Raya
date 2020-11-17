/**
 @author : Raúl Varandela
 Descripción: clase que contiene los atributos de jugador
 */


public class Jugador {

    private String nombre;
    private int partidasGanadas;
    private int partidasJugadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidasGanadas = 0;
        this.partidasJugadas = 0;
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

    public void setPartidasGanadas() {
        this.partidasGanadas++;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas() {
        this.partidasJugadas++;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Nombre: ");
        toret.append(this.getNombre());
        toret.append("\n");
        toret.append("Partidas jugadas: ");
        toret.append(this.getPartidasJugadas());
        toret.append("\n");
        toret.append("Partidas ganadas: ");
        toret.append(this.getPartidasGanadas());

        return toret.toString();
    }
}
