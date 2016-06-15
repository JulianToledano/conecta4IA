package julian.inteligenciaArtificial.conecta4;

import julian.inteligenciaArtificial.conecta4.IA.*;

/**
 * Representa al ordenador como jugador. Desde aquí se importa el paquete IA que contiene a la clase Minimax
 * que es invocada para llamar a la función minimax(estado, jugador, profundidad, profundidadMaxima)
 * @author Julián Toledano
 * @version 15/06/2016 v 1.0
 * @see <a href = "https://github.com/JulianToledano/conecta4IA/tree/master"
 */
public class Maquina {
	private char color;
	private int turno;
	Minimax IA;
	
	public Maquina(){
		color = 'R';
		turno = 1;
		IA = new Minimax();
	}
	
	/**
	 * LLama a la funcion minimax(estado, jugador, profundidad, profundidadMaxima) de la clase
	 * Minimax del paquete julian.inteligenciaArtificial.conecta4.IA.*;
	 * @param estadoActualJuego estado en el que se encuentra el tablero en el momento de realizar el movimiento.
	 * @param jugador A quien le toca jugar.
	 * @return La columna elegida por el algoritmo minimax.
	 */
	public int elegirColumna(Tablero estadoActualJuego, int jugador){
		int columnaElegida = IA.minimax(estadoActualJuego, jugador, 0, 5);		// Maxima profundidad 5, todo el arbol, más profundidad -> funcionamiento incorrecto.
		return columnaElegida;													
	}
	
	public int getTurno(){
		return turno;
	}
	

}
