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
	
	public int victoria(int jugador){
		return jugador;
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
	
	private boolean comprobarDiagonales(int jugador){
		int iguales = 0;
		
			
		return false;
	}
	
	 
	public boolean tableroLleno(){
		for(int i = 0; i < 7; i++){
			if(!columnaLlena(i)) return false;
		}
		return true;
	}
	
	boolean columnaLlena(int columna){
		if(tablero[0][columna] == 0)return false;
		return true;
	}
	
}