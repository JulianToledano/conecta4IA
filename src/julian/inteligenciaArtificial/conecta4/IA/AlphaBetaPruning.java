package julian.inteligenciaArtificial.conecta4.IA;

import julian.inteligenciaArtificial.conecta4.Tablero;

public class AlphaBetaPruning {
	
	Tablero estadoActual;
	Nodo root;
	
	public AlphaBetaPruning(Tablero actual){
		estadoActual = actual;
		root = null;
	}
	
	
	private void crearArbol(){
		// Creamos el árbol y su primer nivel con 7 hojas una por columna. Siete hijos.
		Nodo root = new Nodo(0, estadoActual, null);
		for(int i = 0; i < 7; i++)
			root.insertarHijos(i,1);
		
		// Creamos el segundo nivel
		for(int i = 0; i < root.hijos.size(); i++){
			for(int j = 0; j < 7; j++)
				root.hijos.get(i).insertarHijos(j,2);
		}
		
		// Creamos el tercer nivel
		for(int i = 0; i < root.hijos.size(); i++){
			for(int j = 0; j < root.hijos.get(i).hijos.size(); j++){
				for(int z = 0; z < 7; z++)
					root.hijos.get(i).hijos.get(j).insertarHijos(z,1);
			}
		}
	}
	
	public void negamax(Tablero estado, int profundidad, int profundidadMaxima){
		crearArbol();
	}
}
