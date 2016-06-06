package julian.inteligenciaArtificial.conecta4;

import java.util.Scanner;

public class Jugador {
	char color;
	int numero;
	
	public Jugador(){
		color = 'A';
		numero = 2;
	}
	
	public int elegirColumna(){
		Scanner sc = new Scanner(System.in);
		int columna;
		do{
			columna = sc.nextInt();
		}while(columna < 1 || columna > 8);
		return columna;
	}
}
