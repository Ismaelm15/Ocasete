package ismael.proyectooca;

import java.util.Objects;
import java.util.Random;

public class Jugador {

    // Atributo de clase
    private static Random r = new Random();
    // Atributos de instancia
    private final String nombre;
    private int casillaActual; // Casilla en la que se encuentra
    private int turnosSinJugar;
    private boolean tiraOtraVez;
    private int tirada; // Para guardar lo que saca en el dado

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.casillaActual = 1;
    }

    // Tirada del dado. Guarda el valor en el atributo correspondiente
    public void tirarDado() {
        this.tirada = r.nextInt(6) + 1;
    }

    // Mira la tirada y mueve a la nueva casilla. Controla el rebote   
    public void mover(int movimiento) {
        this.casillaActual += movimiento;
        // Hay que controlar que no se salga del tablero
        if (this.casillaActual >= Tablero.TOTAL_CASILLAS) {
            // Rebote
            int rebote = this.casillaActual - (Tablero.TOTAL_CASILLAS - 1);
            this.casillaActual = Tablero.TOTAL_CASILLAS - 1 - rebote;
        }
    }

    public void copiarDatosCasilla(Tablero t) {
        TipoCasilla copia = t.getCasilla(casillaActual).getTipo();
        this.tiraOtraVez = copia.isTiradaExtra();
        this.turnosSinJugar = copia.getTurnosSinJugar();
        this.mover(copia.getSiguienteMovimiento());

    }

    public void jugarTurno(Tablero t) {

        if (turnosSinJugar > 0) {//Cuando se tiene un turno sin jugar no hace nada
            turnosSinJugar--;
            System.out.println("El jugador " + this.getNombre() + " se ha quedado"
                    + " sin jugar este turno, quedan " + getTurnosSinJugar() + 1
                    + " turnos sin jugar");
        } else {
            do {//Ciclo de turno normal
                t.getCasilla(casillaActual).quitarJugador(this);//quitar el jugador
                tirarDado();//Tirada
                this.mover(tirada);//movimiento
                System.out.println("El jugador " + getNombre()
                        + " ha sacado un " + tirada);//Mostrar cuanto ha sacado
                copiarDatosCasilla(t);//Copia los datos de la casilla en el jugador
                t.getCasilla(casillaActual).ponerJugador(this);//colocar al jugador
                Vista.informarTodo(this, t);//Informacion de la casilla en la que ha caido
            } while (tiraOtraVez);
        }
    }

    public boolean ganaPartida() {
        return this.casillaActual == Tablero.TOTAL_CASILLAS - 1;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    // Consideramos que un jugador es igual a otro si los nombres coinciden
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }

    public int getTurnosSinJugar() {
        return turnosSinJugar;
    }

    public void setTurnosSinJugar(int turnosSinJugar) {
        this.turnosSinJugar = turnosSinJugar;
    }

    public boolean TiraOtraVez() {
        return tiraOtraVez;
    }

    public void setTiraOtraVez(boolean tiraOtraVez) {
        this.tiraOtraVez = tiraOtraVez;
    }

    public int getTirada() {
        return tirada;
    }

    public void setTirada(int tirada) {
        this.tirada = tirada;
    }

}
