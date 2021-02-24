package ismael.proyectooca;

import java.util.ArrayList;


public class Casilla  {
    
    private final int id; // Número de la casilla
    private final TipoCasilla tipo; // Tipo
    // Jugadores que hay actualmente parados en esa casilla
    private ArrayList<Jugador> jugadoresCasilla; 

    public Casilla(int id, TipoCasilla tipo) {
        this.id = id;
        this.tipo = tipo;
        jugadoresCasilla = new ArrayList<>();
    }  
    
    // Este método coloca al jugador que cae en la casilla
    public void ponerJugador(Jugador j){
        jugadoresCasilla.add(j);
    }
    // Para quitar a un jugador que abandona la casilla
    public void quitarJugador(Jugador j){
         jugadoresCasilla.remove(j);
    }

    public int getId() {
        return id;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public ArrayList<Jugador> getJugadoresCasilla() {
        return jugadoresCasilla;
    }
    
    @Override
    public String toString() {
        return "[ " + id + "\t | " + tipo.getTipo() + "\t | " + jugadoresCasillatoString() + "\t]";
    }
    
    private String jugadoresCasillatoString(){
        String tmp = " ";
        for (Jugador jugador : jugadoresCasilla) {
            tmp+=jugador.getNombre()+" ";
        }
        return tmp;
    }
}
