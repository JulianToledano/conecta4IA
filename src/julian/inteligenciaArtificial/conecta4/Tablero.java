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
		
	public void pintarTablero(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++)
				System.out.print(tablero[i][j]);
			System.out.println();
		}
	}
	
	public int introducirFicha(int columna, int jugador){
		if(!columnaLlena(columna)){
			for(int i = 6; i >= 0; i--)
				if(tablero[i][columna] == 0)
					tablero[i][columna] = jugador;
			return 0;
		}
		return -1;
	}
	
	private boolean comprobarHorizontales(int jugador){
		int iguales = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				if(tablero[i][j] == jugador)iguales += 1;
				else iguales = 0;
				if(iguales == 4) return true;
			}
		}
		return false;
	}
	 
	private boolean comprobarVerticales(int jugador){
		int iguales = 0;
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 6; j++){
				if(tablero[j][i] == jugador) iguales += 1;
				else iguales = 0;
				if(iguales == 4)return true;
			}
		}
		return false;
	}
	
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
	
	int victoria(int jugador){
		if(comprobarVerticales(jugador) || comprobarHorizontales(jugador) || comprobarDiagonales(jugador))
			return jugador;
		return 0;
	}
	
	 
	public boolean tableroLleno(){
		for(int i = 0; i < 7; i++){
			if(!columnaLlena(i)) return false;
		}
		return true;
	}
	
	int utilidad(int jugador){
		int oponente;
		if(jugador == 1)oponente = 2;
		else oponente = 1;
		if(tableroLleno()) return 0;
		else if(victoria(jugador) == jugador) return 1;
		else if(victoria(oponente) == oponente)return -1;
		else return 0;
	}
	
	boolean columnaLlena(int columna){
		if(tablero[0][columna] == 0)return false;
		return true;
	}
	
}