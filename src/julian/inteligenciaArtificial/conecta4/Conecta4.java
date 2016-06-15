// Esta clase representa el juego al completo, un tablero, dos jugadores (persona y máquina) y administra los turnos.
package julian.inteligenciaArtificial.conecta4;

import julian.inteligenciaArtificial.conecta4.IA.*;


public class Conecta4 {
	Tablero tablero;
	Jugador jugador;
	Maquina maquina;
	Minimax test;
	
	public Conecta4(){
		tablero = new Tablero();
		jugador = new Jugador();
		maquina = new Maquina();
		test = new Minimax();
	}
	
	/**
	 * Da comienzo a la partida, alterna entre los turnos de la máquina y la persona
	 */
	public void jugar(){
		
		int turno = maquina.getTurno();
		tablero.pintarTablero();
		while(!tablero.finPartida()){
			System.out.println("Es el turno del jugador " + turno);
			if(turno == 1){ // Turno de la máquina
				int movimiento;
				Tablero copia = new Tablero(tablero);
				do{
				movimiento = test.minimax(copia,turno,0,5);
				System.out.println("La maquina elige " + movimiento+1);
				}while(tablero.columnaLlena(movimiento));
				tablero.introducirFicha(movimiento,turno);
				turno += 1;
			}
			else{
				tablero.introducirFicha(jugador.elegirColumna()-1, turno);
				turno -= 1;
			}
			tablero.pintarTablero();
			if(tablero.victoria(turno)!= 0){
				System.out.print("Ha ganado el jugador " + turno);
			}
		}
		System.out.print("Se acabo el juego");
	}
	
	public int minimax(){
		
		
		return 0;
	}
}

