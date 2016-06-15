package julian.inteligenciaArtificial.conecta4.IA;

import julian.inteligenciaArtificial.conecta4.*;

public class Minimax {
	
	public int minimax(Tablero estado, int jugador, int pro, int proMax){
		int mejorMovimiento = -10000;
		int resultado = -1;
		int mejorMovimientoTemporal;
		Tablero temporal = new Tablero(estado);
		
		for(int i = 0; i < 7; i++){
			estado.introducirFicha(i, jugador);
			
			if(jugador == 1)
				mejorMovimientoTemporal = minValue(estado,2,pro+1,proMax);
			else
				mejorMovimientoTemporal = minValue(estado,1,pro+1,proMax);
			
			if(mejorMovimientoTemporal > mejorMovimiento && !estado.columnaLlena(i)){	// Como el método introducirFicha(columna,jugador) no proporciona ningún control
				mejorMovimiento = mejorMovimientoTemporal;								// sobre la elección de una columna llena, debemos asegurarnos de que la IA no selecciona
				resultado = i;															// 
			}
			
			estado = new Tablero(temporal);		// Se necesita poner el tablero al estado inicial. De lo contrario se guarda 
												// el movimiento respecto a las demás llamadas recursivas.
			
		}
		
		return resultado; // Devuelve mejor movimiento
	}
	
	
	// Comprobar que una columna está llena y no elegirla
	
	private int maxValue(Tablero estado, int jugador, int pro, int proMax){
		if(estado.finPartida() || pro == proMax)return estado.utilidad();
		int mejorPuntuacion = -10000;
		int mejorPuntuacionTemporal;
		
		Tablero temporalenMax = new Tablero(estado);
		
		for(int i = 0; i < 7; i++){
				estado.introducirFicha(i,jugador);
				
				if(jugador == 1)
					mejorPuntuacionTemporal = minValue(estado,2,pro+1,proMax);
				else
					mejorPuntuacionTemporal = minValue(estado,1,pro+1,proMax);
				
				if(mejorPuntuacionTemporal >= mejorPuntuacion)
					mejorPuntuacion = mejorPuntuacionTemporal;
				
				estado = new Tablero(temporalenMax);
				
		}
		return mejorPuntuacion; // Devuelve un valor uutilidad
	}
	
	int minValue(Tablero estado, int jugador, int pro, int proMax){
		if(estado.finPartida() || pro == proMax)return estado.utilidad();
		int mejorPuntuacion = 10000;
		int mejorPuntuacionTemporal;
		
		Tablero temporalenMin = new Tablero(estado);
		
		for(int i = 0; i < 7; i++){
			estado.introducirFicha(i, jugador);
			
			if(jugador == 1)
				mejorPuntuacionTemporal = maxValue(estado,2,pro+1,proMax);
			else				
				mejorPuntuacionTemporal = maxValue(estado,1,pro+1,proMax);

			if(mejorPuntuacionTemporal <= mejorPuntuacion)
				mejorPuntuacion = mejorPuntuacionTemporal;
			
			estado = new Tablero(temporalenMin);
			
		}
		
		return mejorPuntuacion; // Devuelve un valor utilidad
	}
	
}
