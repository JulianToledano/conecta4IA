package julian.inteligenciaArtificial.conecta4;

import julian.inteligenciaArtificial.conecta4.IA.*;

public class Maquina {
	private char color;
	private int turno;
	Minimax IA;
	
	public Maquina(){
		color = 'R';
		turno = 1;
		IA = new Minimax();
	}
	public int elegirColumna(Tablero estadoActualJuego, int turno){
		int columnaElegida = IA.minimax(estadoActualJuego, turno, 0, 5);		// Maxima profundidad 5, todo el arbol, más profundidad -> funcionamiento incorrecto
		return columnaElegida;
	}
	
	public int getTurno(){
		return turno;
	}
	

}
