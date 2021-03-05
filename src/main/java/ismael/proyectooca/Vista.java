package ismael.proyectooca;

public class Vista {

    public static void mostrarTablero(Tablero t) {
        System.out.println(t.toString());
    }

    public static void informarTirada(Jugador j) {
        System.out.println(j.getNombre() + " ha tirado un " + j.getTirada());
    }

    public static void informarProgreso(Jugador j) {
        System.out.println(j.getNombre() + " se mueve a la casilla " + j.getCasillaActual());
    }

    public static void informarPozo(Jugador j) {
        if (j.getCasillaActual() == 31) {
            System.out.println("Oh no he caido en el pozo soy el jugador " + j.getNombre());
        }
    }

    public static void informarOca(Jugador j, Tablero t) {
        TipoCasilla copia = t.getCasilla(j.getCasillaActual()).getTipo();
        if (copia == TipoCasilla.OCA4 || copia == TipoCasilla.OCA5) {
            System.out.println("De oca a oca y tiro porque me toca, soy el jugador " + j.getNombre());
        }
    }

    public static void informarCalavera(Jugador j) {
        if (j.getCasillaActual() == 58) {
            System.out.println("Oh no he caido en la calavera " + j.getNombre());
        }
    }

    public static void informarCarcel(Jugador j) {
        if (j.getCasillaActual() == 56) {
            System.out.println("Oh no he caido en la carcel " + j.getNombre());
        }
    }

    public static void informarPuente(Jugador j, Tablero t) {
        TipoCasilla copia = t.getCasilla(j.getCasillaActual()).getTipo();
        if (copia == TipoCasilla.PUENTE6 || copia == TipoCasilla.PUENTE12) {
            System.out.println("De puente a puente y tiro porque me lleva la corriente " + j.getNombre());
        }
    }

    public static void informarDados(Jugador j) {
        if (j.getCasillaActual() == 26) {
            System.out.println("De dado a dado y tiro porque me ha tocado " + j.getNombre());
        }
    }

    public static void informarPosada(Jugador j) {
        if (j.getCasillaActual() == 26) {
            System.out.println("A la posada a descansar " + j.getNombre());
        }
    }

    public static void informarTodo(Jugador j, Tablero t) {
        informarPosada(j);
        informarDados(j);
        informarPuente(j, t);
        informarCarcel(j);
        informarCalavera(j);
        informarOca(j, t);
        informarPozo(j);
    }

}
