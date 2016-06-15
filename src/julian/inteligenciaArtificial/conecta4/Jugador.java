package julian.inteligenciaArtificial.conecta4;

import java.util.Scanner;

/**
 * Clase  que representa a la persona. Contiene la función que permite al jugador
 * elegir la columna en la que insertar una ficha.
 * @author Julián Toledano
 * @version 15/06/2016 v 1.0
 * @see <a href = "https://github.com/JulianToledano/conecta4IA/tree/master"
 */
public class Jugador {
	char color;
	int turno;
	
	public Jugador(){
		color = 'A'; 										// Amarillo						
		turno = 2;											// Siempre jugará en segundo lugar.
	}
	
	/**
	 * Se pide por teclado que se inserte un número entero.
	 * @return columna en la que se quiere insertar una ficha. Valor de (1 a 7).
	 */
	public int elegirColumna(){
		Scanner sc = new Scanner(System.in);
		int columna;
		do{
			columna = sc.nextInt();
		}while(columna < 1 || columna > 8);
		//sc.close(); 										// Causa problemas
		return columna;
	}

}