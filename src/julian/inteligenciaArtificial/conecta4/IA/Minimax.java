package julian.inteligenciaArtificial.conecta4.IA;

import julian.inteligenciaArtificial.conecta4.Tablero;

public class Minimax {
	
	public int minimax(Tablero actual, int jugador, int profundidadMaxima, int profundidad){
		
		int mejorMovimiento = -1;
		int mejorPuntuacion = 0;
		Tablero copia = new Tablero(actual);
		for(int i = 0; i < 7; i++){
			if(!copia.columnaLlena(i)){
				copia.introducirFicha(i, jugador);
				int mejorPuntuacionTemporal = maxSearch(copia,2,profundidadMaxima, profundidad+1)+profundidad;
				
				if(mejorPuntuacionTemporal <= mejorPuntuacion){
					mejorPuntuacion = mejorPuntuacionTemporal;
					mejorMovimiento = i;
				}
				copia = new Tablero(actual);
			}
		}
		return mejorMovimiento;
	}
	
	private int maxSearch(Tablero actual, int jugador, int profundidadMaxima, int profundidad){
		if(actual.finPartida()) return actual.utilidad();
		
		int mejorMovimiento = -1;
		int mejorPuntuacion = -1000;
		for(int i = 0; i < 7; i++){
			if(!actual.columnaLlena(i)){
				actual.introducirFicha(i, jugador);
				int mejorPuntuacionTemporal = minSearch(actual,1,profundidadMaxima, profundidad+1)-profundidad;
				
				if(mejorPuntuacionTemporal >= mejorPuntuacion){
					mejorPuntuacion = mejorPuntuacionTemporal;
					mejorMovimiento = i;
				}
			}
		}
		return mejorMovimiento;
	}
	
	private int minSearch(Tablero actual, int jugador, int profundidadMaxima, int profundidad){
		if(actual.finPartida()) return actual.utilidad();
		
		int mejorMovimiento = -1;
		int mejorPuntuacion = 1000;
		for(int i = 0; i < 7; i++){
			if(!actual.columnaLlena(i)){
				actual.introducirFicha(i, jugador);
				int mejorPuntuacionTemporal = maxSearch(actual,2,profundidadMaxima, profundidad+1)+profundidad;
				
				if(mejorPuntuacionTemporal >= mejorPuntuacion){
					mejorPuntuacion = mejorPuntuacionTemporal;
					mejorMovimiento = i;
				}
			}
		}
		return mejorMovimiento;
		
	}
}
