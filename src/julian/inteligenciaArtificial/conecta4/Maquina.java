package julian.inteligenciaArtificial.conecta4;

import julian.inteligenciaArtificial.conecta4.IA.*;

public class Maquina {
	private char color;
	private int turno;
	Minimax test;
	
	public Maquina(){
		color = 'R';
		turno = 1;
		test = new Minimax();
	}
	public int elegirColumna(){
		
		return 0;
	}
	
	public int getTurno(){
		return turno;
	}
	

}
