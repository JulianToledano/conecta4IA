// Esta clase se encarga de representar el tablero del juego. Entre sus funciones de encuentran la de pintar el tablero,
// introducir las fichas en el él, comprobar si el juego ha terminado y en caso de haber un ganador verificar cual de ellos es.

package julian.inteligenciaArtificial.conecta4;

public class Tablero {
	int [][]tablero = new int[6][7];
	
	public Tablero(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++)
				tablero[i][j] = 0;
			}
	}
	
	public Tablero(Tablero tableroCopia){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++)
				tablero[i][j] = tableroCopia.tablero[i][j];
			}
	}
		/**
	 * Imprime el tablero en pantalla
	 */
	public void pintarTablero(){
		for(int i = 0; i < 6; i++){
			System.out.print("| ");
			for(int j = 0; j < 7; j++)
				System.out.print(tablero[i][j] + " | ");
			System.out.println("");
		}
	}
	
	/**
	 * Inserta una ficha en una columna
	 * @param columna indica en que columna se inserta la ficha valor del 0 al 6
	 * @param jugador indica qué jugador realizo el movimiento. 1 = IA, 2 = persona
	 */
	public void introducirFicha(int columna, int jugador){
		if(!columnaLlena(columna)){
			for(int i = 5; i >= 0; i--)
				if(tablero[i][columna] == 0){
					tablero[i][columna] = jugador;
					i = -1;
				}
		}
	}
	
	/**
	 * Comprueba si hay cuatri fichas iguales en una línea horizontal
	 * @param jugador 1 = IA, 2 = persona
	 * @return true si existen 4 fichas seguidas con valor jugador
	 */
	private boolean comprobarHorizontales(int jugador){
		int iguales = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				if(tablero[i][j] == jugador)iguales += 1;
				else iguales = 0;
				if(iguales == 4) return true;
			}
			iguales = 0;
		}
		return false;
	}
	 
	/**
	 * Comprueba si hay cuatri fichas iguales en una línea vertical
	 * @param jugador 1 = IA, 2 = persona
	 * @return true si existen 4 fichas seguidas con valor jugador
	 */
	private boolean comprobarVerticales(int jugador){
		int iguales = 0;
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 6; j++){
				if(tablero[j][i] == jugador) iguales += 1;
				else iguales = 0;
				if(iguales == 4)return true;
			}
			iguales = 0;
		}
		return false;
	}
	
	/**
	 * Comprueba si existen fichas iguales en las diagonales de izquierda a derecha, para ello se aumenta en uno
	 * tanto el valor de las filas como el de las columnas
	 * @param i valor de la fila para el bucle
	 * @param j valor de la columna para el bucle
	 * @param jugador 1 = IA, 2 = persona
	 * @return true si existen 4 fichas seguidas con valor jugador
	 */
	private boolean compararDiagonalesIzquierdaDerecha(int i, int j, int jugador){
		int iguales = 0;
		while(i < 6 && j < 7){
			if(tablero[i][j] == jugador) iguales += 1;
			else iguales = 0;
			if(iguales == 4) return true;
			i++; j++;
		}
		return false;
	}
	
	/**
	 * Comprueba si existen fichas iguales en las diagonales de derecha a izquierda, para ello se aumenta en uno
	 * el valor de las filas y se disminuye en uno el valor de las columnas
	 * @param i valor de la fila para el bucle
	 * @param j valor de la columna para el bucle
	 * @param jugador 1 = IA, 2 = persona
	 * @return true si existen 4 fichas seguidas con valor jugador
	 */
	private boolean compararDiagonalesDerechaIzquierda(int i, int j, int jugador){
		int iguales = 0;
		while(i < 6 && j >= 0){
			if(tablero[i][j] == jugador) iguales += 1;
			else iguales = 0;
			if(iguales == 4) return true;
			i++; j--;
		}
		return false;
	}
	
	/**
	 * Se comprueba todas las posibles diagonales en las que puede haber cuatro fichas seguidas
	 * @param jugador 1 = IA, 2 = persona
	 * @return true si existen 4 fichas seguidas con valor jugador
	 */
	private boolean comprobarDiagonales(int jugador){
		if(compararDiagonalesIzquierdaDerecha(0,0,jugador) || compararDiagonalesIzquierdaDerecha(1,0,jugador) ||
		   compararDiagonalesIzquierdaDerecha(2,0,jugador) || compararDiagonalesIzquierdaDerecha(0,1,jugador) ||
		   compararDiagonalesIzquierdaDerecha(0,2,jugador) || compararDiagonalesIzquierdaDerecha(0,3,jugador) ||
		   compararDiagonalesDerechaIzquierda(0,6,jugador) || compararDiagonalesDerechaIzquierda(1,6,jugador) ||
		   compararDiagonalesDerechaIzquierda(2,6,jugador) || compararDiagonalesDerechaIzquierda(0,5,jugador) ||
		   compararDiagonalesDerechaIzquierda(0,4,jugador) || compararDiagonalesDerechaIzquierda(0,3,jugador))
			return true;
		
		return false;
	}
	
	/**
	 * Comprueba si existen 4 fichas seguidas de un jugador tanto en las filas como en las columnas como en las diagonales
	 * @param jugador 1 = IA, 2 = persona
	 * @return true si existen 4 fichas seguidas con el valor jugador en cualquier parte del tablero
	 */
	public int victoria(int jugador){
		if(comprobarVerticales(jugador) || comprobarHorizontales(jugador) || comprobarDiagonales(jugador))
			return jugador;
		return 0;
	}
	
	/**
	 * Comprueb si el tablero está lleno
	 * @return tipo void
	 */
	public boolean tableroLleno(){
		for(int i = 0; i < 7; i++){
			if(!columnaLlena(i)) return false;
		}
		return true;
	}
	
	/**
	 * Comprueba si la partida se ha acabado bien porque un jugador gana o porqur no quedan huecos donde
	 * realizar movimientos
	 * @return true si alguien gana o no quedan huecos libres
	 */
	public boolean finPartida(){
		if(tableroLleno()) return true;
		else if(victoria(1) == 1) return true;
		else if(victoria(2) == 2) return true;
		else return false;
	}
	
	/*
	public int utilidad(int jugador){
		int oponente;
		if(jugador == 1)oponente = 2;
		else oponente = 1;
		if(tableroLleno()) return 0;
		else if(victoria(jugador) == jugador) return 1;
		else if(victoria(oponente) == oponente)return -1;
		else return 0;
	}*/
	
	/**
	 * Valor heurístico para determinar  la utilidad de los movimientos
	 * @return -1 si gana la máquinam 1 si gana la persona, 0 si empate
	 */
	public int utilidad(){
		if(victoria(1) == 1) return 1;
		else if(victoria(2) == 2) return -1;
		else return 0;
	}
	
	/**
	 * Comprueba si se puede realizar un movimiento en una determinada columna
	 * @param columna en la que se quiere insertar una ficha
	 * @return false se si puede realizar el movimiento, true si está llena
	 */
	public boolean columnaLlena(int columna){
		if(tablero[0][columna] == 0)return false;
		return true;
	}
	
}