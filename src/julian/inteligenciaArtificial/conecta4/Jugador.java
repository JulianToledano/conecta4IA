// Clase  que representa a la persona desde aquí el jugador elige la columna a la que insertar una ficha. 
package julian.inteligenciaArtificial.conecta4;

import java.util.Scanner;

public class Jugador {
	char color;
	int turno;
	
	public Jugador(){
		color = 'A';
		turno = 2;
	}
	
	public int elegirColumna(){
		Scanner sc = new Scanner(System.in);
		int columna;
		do{
			columna = sc.nextInt();
		}while(columna < 1 || columna > 8);
		//sc.close();
		return columna;
	}

}