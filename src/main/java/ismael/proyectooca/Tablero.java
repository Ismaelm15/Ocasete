package ismael.proyectooca;

import java.util.ArrayList;

public class Tablero {

    // Array de casillas
    private Casilla[] tablero;
    // Sólo hay 63 casillas útiles, la casilla 0 se ignora
    public static final int TOTAL_CASILLAS = 64;

    public Tablero() {
        tablero = new Casilla[TOTAL_CASILLAS];

        // tablero[0] no se inicializa. Se ignora
        for (int i = 1; i < TOTAL_CASILLAS; i++) {
            switch (i) {
                // Casillas OCA4
                case 5:
                case 14:
                case 23:
                case 32:
                case 41:
                case 50:
                case 59:
                    tablero[i] = new Casilla(i, TipoCasilla.OCA4);
                    break;
                // Casillas OCA5
                case 9:
                case 18:
                case 27:
                case 36:
                case 45:
                case 54:
                    tablero[i] = new Casilla(i, TipoCasilla.OCA5);
                    break;
                // Casilla PUENTE6
                case 6:
                    tablero[i] = new Casilla(i, TipoCasilla.PUENTE6);
                    break;
                // Casilla PUENTE12
                case 12:
                    tablero[i] = new Casilla(i, TipoCasilla.PUENTE12);
                    break;
                // Casilla POSADA
                case 19:
                    tablero[i] = new Casilla(i, TipoCasilla.POSADA);
                    break;
                // Casilla DADOS26
                case 26:
                    tablero[i] = new Casilla(i, TipoCasilla.DADOS26);
                    break;
                // Casilla POZO
                case 31:
                    tablero[i] = new Casilla(i, TipoCasilla.POZO);
                    break;
                // Casilla LABERINTO
                case 42:
                    tablero[i] = new Casilla(i, TipoCasilla.LABERINTO);
                    break;
                // Casilla DADOS53
                case 53:
                    tablero[i] = new Casilla(i, TipoCasilla.DADOS53);
                    break;
                // Casilla CARCEL
                case 56:
                    tablero[i] = new Casilla(i, TipoCasilla.CARCEL);
                    break;
                // Casilla CALAVERA
                case 58:
                    tablero[i] = new Casilla(i, TipoCasilla.CALAVERA);
                    break;
                // Casilla JARDIN_OCA
                case 63:
                    tablero[i] = new Casilla(i, TipoCasilla.JARDIN_OCA);
                    break;
                // Casilla NORMAL
                default:
                    tablero[i] = new Casilla(i, TipoCasilla.NORMAL);
            }
        }
    }

    public Casilla getCasilla(int numeroCasilla) {
        if (numeroCasilla > 0 && numeroCasilla < tablero.length) {
            return tablero[numeroCasilla];
        }
        return null;
    }

    @Override
    public String toString() {
        String tmp = "";
        for (int i = 1; i < TOTAL_CASILLAS; i++) {
            tmp += tablero[i].toString() + "\n";
        }
        return tmp;
    }

//    public boolean hayJugadoresPozo(Jugador j, ArrayList<Jugador> listaJugadores) {
//        for (Jugador aux : listaJugadores) {
//            if (!aux.equals(j)) {
//                if (aux.getCasillaActual() == j.getCasillaActual()) {
//                    return true;
//                }
//            }
//        }
//        return false;
    public boolean hayJugadoresDespuesPozo() {
        if(tablero[31].getJugadoresCasilla().size()>1){
        return true;
        }
        for (int i = 32; i < tablero.length; i++) {
            if (!tablero[i].getJugadoresCasilla().isEmpty()) {
                return true;
            }
        }
        return false;
    }

}

