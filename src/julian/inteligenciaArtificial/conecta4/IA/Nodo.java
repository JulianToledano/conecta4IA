package julian.inteligenciaArtificial.conecta4.IA;

import julian.inteligenciaArtificial.conecta4.Tablero;
import java.util.ArrayList;


public class Nodo{
	protected Estado estado;
	protected Nodo padre;
	protected ArrayList<Nodo>hijos;
	
	public Nodo(Estado estado, Nodo padre){
		this.estado = estado;
		this.hijos = new ArrayList();
		if((padre != null) && (!this.estado.equals(padre.estado))){
			this.padre = padre;
			this.padre.hijos.add(this);
		}
	}
	
	public Estado getElemento(){
		return this.estado;
	}
	
	public int getValor(){
		return estado.getValor();
	}
	
	public ArrayList<Nodo>expandir(){
		ArrayList<Nodo>resultado = new ArrayList();
		for(int i = 0; i < 7; i++){
			if(!estado.estadoActual.finPartida()){
				Estado estadoNuevoNodo = new Estado();
				estadoNuevoNodo.setEstadoActual(estado.getEstadoActual());
				if(estado.getTurno() == 1) estadoNuevoNodo.setTurno(2);
				else estadoNuevoNodo.setTurno(1);
				estadoNuevoNodo.estadoActual.introducirFicha(i, estadoNuevoNodo.getTurno());
				Nodo hijo = new Nodo(estadoNuevoNodo,this);
				resultado.add(hijo);
			}
		}
		return resultado;
	}
}