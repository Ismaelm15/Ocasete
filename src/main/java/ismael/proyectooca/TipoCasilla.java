
package ismael.proyectooca;


public enum TipoCasilla {
    
    NORMAL ("Normal",0,0,false),
    OCA4 ("Oca 4",0,4,true),
    OCA5 ("Oca 5",0,5,true),
    PUENTE6 ("Puente", 0,13, false),
    PUENTE12 ("Puente", 0,7, false),
    POSADA ("Posada", 1,0, false),
    POZO ("Pozo negro", 100,0, false),
    LABERINTO ("Laberinto", 0,-12, false),
    CARCEL ("Cárcel", 2,0, false),
    DADOS26 ("Dados 26", 0,26,false),
    DADOS53 ("Dados 53", 0,53,false),
    CALAVERA ("Calavera",0,-57,false),
    JARDIN_OCA ("Jardín", 0,0,false);
    
    private final String tipo; // Oca, Puente, etc
    private final int turnosSinJugar; // Número de turnos sin jugar
    private final int siguienteMovimiento; // 0 no hago nada, +3 avanza 3
    private final boolean tiradaExtra; // Si se cae en esta casilla se tira otra vez

    private TipoCasilla(String tipo, int turnosSinJugar, int siguienteMovimiento, boolean tiradaExtra) {
        this.tipo = tipo;
        this.turnosSinJugar = turnosSinJugar;
        this.siguienteMovimiento = siguienteMovimiento;
        this.tiradaExtra = tiradaExtra;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTurnosSinJugar() {
        return turnosSinJugar;
    }

    public int getSiguienteMovimiento() {
        return siguienteMovimiento;
    }

    public boolean isTiradaExtra() {
        return tiradaExtra;
    } 
    
}
