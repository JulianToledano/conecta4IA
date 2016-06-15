package julian.inteligenciaArtificial.conecta4.IA;

import julian.inteligenciaArtificial.conecta4.*;

/**
 * Algoritmo Minimax. Crea un ábol de juego mediante la llamada sucesiva dos funciones recursivas.
 * <pre>
 * {@code
 * @see https://github.com/aimacode/aima-pseudocode/blob/master/md/Minimax-Decision.md
 * 
 * PseudoCódigo Minimax sacado del libro Artificial Intelligence a Modern Approach
 * 
 * 
 * function MINIMAX-DECISION(state) returns an action
  return arg max a ∈ ACTIONS(s) MIN-VALUE(RESULT(state, a))
 *
 * function MAX-VALUE(state) returns a utility value
   if TERMINAL-TEST(state) the return UTILITY(state)
   v ← −∞
   for each a in ACTIONS(state) do
    v ← MAX(v, MIN-VALUE(RESULT(s, a)))
   return v

 * function MIN-VALUE(state) returns a utility value
   if TERMINAL-TEST(state) the return UTILITY(state)
   v ← ∞
   for each a in ACTIONS(state) do
    v ← MIN(v, MAX-VALUE(RESULT(s, a)))
   return v
 * }
 * </pre>
 * @author Julián Toledano
 * @version 15/06/2016 v 1.0
 * @see <a href = "https://github.com/JulianToledano/conecta4IA/tree/master>mio</a>
 */
public class Minimax {
	
	/**
	 * Algoritmo minimax.
	 * ERROR: Si profundidad -> 5 ignora la columna
	 * @param estado estado actual del tablero
	 * @param jugador quien realiza el movimietno
	 * @param profundidad profundidad actual del árbol
	 * @param profundiadMaxima profundidad máxima del arbol
	 * @return el mejor movimiento posible
	 */
	public int minimax(Tablero estado, int jugador, int profundidad, int profundiadMaxima){
		int mejorMovimiento = -10000;
		int resultado = -1;
		int mejorMovimientoTemporal;
		Tablero temporal = new Tablero(estado);
		
		for(int i = 0; i < 7; i++){
			estado.introducirFicha(i, jugador);
			
			if(jugador == 1)
				mejorMovimientoTemporal = minValue(estado,2,profundidad+1,profundiadMaxima);
			else
				mejorMovimientoTemporal = minValue(estado,1,profundidad+1,profundiadMaxima);
			
			if(mejorMovimientoTemporal > mejorMovimiento && !estado.columnaLlena(i)){	// Como el método introducirFicha(columna,jugador) no proporciona ningún control
				mejorMovimiento = mejorMovimientoTemporal;								// sobre la elección de una columna llena, debemos asegurarnos de que la IA no selecciona
				resultado = i;															 
			}
			
			estado = new Tablero(temporal);												// Se necesita poner el tablero al estado inicial. De lo contrario se guarda 
																						// el movimiento respecto a las demás llamadas recursivas.
			
		}
		
		return resultado; // Devuelve mejor movimiento
	}
	
	/**
	 * Función para deternar la utilidad máxima
	 * @param estado estado actual del tablero
	 * @param jugador quien realiza el movimietno
	 * @param profundidad profundidad actual del árbol
	 * @param profundiadMaxima profundidad máxima del arbol
	 * @return el la mejor puntuacion obtenida
	 */
	private int maxValue(Tablero estado, int jugador, int profundidad, int profundiadMaxima){
		if(estado.finPartida() || profundidad == profundiadMaxima)return estado.utilidad();
		int mejorPuntuacion = -10000;
		int mejorPuntuacionTemporal;
		
		Tablero temporalenMax = new Tablero(estado);
		
		for(int i = 0; i < 7; i++){
				estado.introducirFicha(i,jugador);
				
				if(jugador == 1)
					mejorPuntuacionTemporal = minValue(estado,2,profundidad+1,profundiadMaxima);
				else
					mejorPuntuacionTemporal = minValue(estado,1,profundidad+1,profundiadMaxima);
				
				if(mejorPuntuacionTemporal >= mejorPuntuacion)
					mejorPuntuacion = mejorPuntuacionTemporal;
				
				estado = new Tablero(temporalenMax);
				
		}
		return mejorPuntuacion; // Devuelve un valor uutilidad
	}
	
	/**
	 * Función para deternar la utilidad mínima
	 * @param estado estado actual del tablero
	 * @param jugador quien realiza el movimietno
	 * @param profundidad profundidad actual del árbol
	 * @param profundiadMaxima profundidad máxima del arbol
	 * @return el la mejor puntuacion obtenida
	 */
	private int minValue(Tablero estado, int jugador, int profundidad, int profundiadMaxima){
		if(estado.finPartida() || profundidad == profundiadMaxima)return estado.utilidad();
		int mejorPuntuacion = 10000;
		int mejorPuntuacionTemporal;
		
		Tablero temporalenMin = new Tablero(estado);
		
		for(int i = 0; i < 7; i++){
			estado.introducirFicha(i, jugador);
			
			if(jugador == 1)
				mejorPuntuacionTemporal = maxValue(estado,2,profundidad+1,profundiadMaxima);
			else				
				mejorPuntuacionTemporal = maxValue(estado,1,profundidad+1,profundiadMaxima);

			if(mejorPuntuacionTemporal <= mejorPuntuacion)
				mejorPuntuacion = mejorPuntuacionTemporal;
			
			estado = new Tablero(temporalenMin);
			
		}
		
		return mejorPuntuacion; // Devuelve un valor utilidad
	}
	
}
