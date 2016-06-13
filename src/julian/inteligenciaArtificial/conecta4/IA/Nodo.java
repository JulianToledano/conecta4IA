package julian.inteligenciaArtificial.conecta4.IA;

import julian.inteligenciaArtificial.conecta4.Tablero;
import java.util.ArrayList;


public class Nodo{
	int profundidad;
	Tablero estadoActual;
	Nodo padre;
	ArrayList<Nodo>hijos;

	public Nodo(int profundidad, Tablero actual, Nodo padre){
		this.profundidad = profundidad;
		estadoActual = actual;
		this.padre = padre;
		hijos = new ArrayList<Nodo>();
	}
	
	public void insertarHijos(int columna, int jugador){
		Nodo nodoHijo = new Nodo(this.profundidad+1, estadoActual, this);
		nodoHijo.estadoActual.introducirFicha(columna,jugador);
		hijos.add(nodoHijo);
	}
}