package ismael.proyectooca;

public class Juego {

    private final Tablero tablero;
    private final ControladorJugadores cj;

    // Crea el juego a partir del tablero y la  lista de jugadores
    // Pone a los jugadores en la casilla de salida
    public Juego(Tablero tablero, ControladorJugadores controlador) {
        this.tablero = tablero;
        this.cj = controlador;
        // Coloca a los jugadores en la casilla de salida
        for (Jugador aux : cj.getTodosJugadores()) {
            this.tablero.getCasilla(1).ponerJugador(aux);
        }

    }

    public static void main(String[] args) {

        // Se crea el juego
        String[] nombres = {"J1", "J2", "J3"};
        ControladorJugadores cj = new ControladorJugadores(nombres);
        Tablero tablero = new Tablero();
        Juego juego = new Juego(tablero, cj);
        boolean ganar = false;
        // Imprime el estado del tablero inicialmente
        Vista.mostrarTablero(juego.getTablero());
        do {
            for (Jugador aux : cj.getTodosJugadores()) {
                for (Jugador j : cj.getTodosJugadores()) {
                    if (j.getCasillaActual() == 31) {
                        if (tablero.hayJugadoresPozo(j, cj.getTodosJugadores())) {
                            j.setTurnosSinJugar(0);
                        }
                    }

                }
                aux.jugarTurno(tablero);
                Vista.mostrarTablero(juego.getTablero());
                ganar = aux.ganaPartida();
            }

        } while (!ganar);
        for (Jugador aux : cj.getTodosJugadores()) {
            if (aux.ganaPartida()) {

                System.out.println("Ha ganado el jugador " + aux.getNombre());
                break;
            }
        }

    }

    public Tablero getTablero() {
        return tablero;
    }

    public ControladorJugadores getCj() {
        return cj;
    }

}