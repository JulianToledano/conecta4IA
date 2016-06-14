
package julian.inteligenciaArtificial.conecta4.IA;

import java.util.List;
import julian.inteligenciaArtificial.conecta4.Tablero;

public class Estado{
	Tablero estadoActual;
	int valor;
	int turno;
	
	public Estado(){
		estadoActual = null;
		valor = 0;
		turno = 0;
	}
	
	public Estado(Tablero estadoActual, int valor, int turno){
		this.estadoActual = estadoActual;
		this.valor = valor;
		this.turno = turno;
	}
	
	public Tablero getEstadoActual(){return this.estadoActual;}
	public int getValor(){return this.valor;}
	public int getTurno(){return this.turno;}
	
	public void setEstadoActual(Tablero estadoActual){this.estadoActual = estadoActual;}
	public void setvalor(int valor){this.valor = valor;}
	public void setTurno(int turno){this.turno = turno;}
}
