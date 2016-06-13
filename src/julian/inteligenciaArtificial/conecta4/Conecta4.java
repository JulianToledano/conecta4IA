// Esta clase representa el juego al completo, un tablero, dos jugadores (persona y m�quina) y administra los turnos.
package julian.inteligenciaArtificial.conecta4;

public class Conecta4 {
	Tablero tablero;
	Jugador jugador;
	Maquina maquina;
	
	public Conecta4(){
		tablero = new Tablero();
		jugador = new Jugador();
		maquina = new Maquina();
	}
	
	/**
	 * Da comienzo a la partida, alterna entre los turnos de la m�quina y la persona
	 */
	public void jugar(){
		
		int turno = maquina.getTurno();
		tablero.pintarTablero();
		while(!tablero.finPartida()){
			System.out.print("Es el turno del jugador " + turno);
			if(turno == 1){ // Turno de la m�quina
				tablero.introducirFicha(jugador.elegirColumna()-1,turno);
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
}

