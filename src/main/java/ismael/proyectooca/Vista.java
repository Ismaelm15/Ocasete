
package ismael.proyectooca;


public class Vista {
    
    public static void mostrarTablero(Tablero t){
        System.out.println(t.toString());
    }
    
    public static void informarTirada(Jugador j){
        System.out.println(j.getNombre() + " ha tirado un " + j.getTirada());
    }
    
    public static void informarProgreso(Jugador j){
        System.out.println(j.getNombre() + " se mueve a la casilla " + j.getCasillaActual());
    }
}
