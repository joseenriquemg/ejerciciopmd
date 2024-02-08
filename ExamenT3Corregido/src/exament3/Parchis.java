package exament3;

import java.util.Random;

/**
 * Clase Parchis
 */
public class Parchis {
	/**
	 * Funcion estatica para la clase TAM_TABLERO
	 */
	public static final int TAM_TABLERO = 10;
	/**
	 * Variable estatica para recoger loas dos tiradas de dados.
	 */
	static int dado1, dado2;

	int fichaJ1 = 0, fichaJ2 = 0;
	//Creamos las variables string
	String nomJ1 = "", nomJ2 = "";

	/**
	 * Clase Parchis
	 */
	public Parchis() {
		super();
	}

	/**
	 * Clase Parchis
	 * 
	 * @param nomJ1
	 * @param nomJ2
	 */
	public Parchis(String nomJ1, String nomJ2) {
		super();
		this.nomJ1 = nomJ1;
		this.nomJ2 = nomJ2;
	}

	/**
	 * Clase tiraDados
	 */
	public static void tiraDados() {
		Random rand = new Random();
		dado1 = rand.nextInt(1, 7);
		dado2 = rand.nextInt(1, 7);
	}

	/**
	 * Clase pintaTablero
	 */
	public void pintaTablero() {
		System.out.print("\tI");
		for (int i = 1; i < TAM_TABLERO; i++) {
			System.out.print("\t" + i);
		}
		System.out.println("\tF");

		System.out.print(nomJ1 + "\tI");

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ1) {
				System.out.print("\tO");
			} else {
				System.out.print("\t");
			}
		}

		System.out.println("\tF");

		System.out.print(nomJ2 + "\tI");

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ2) {
				System.out.print("\tO");
			} else {
				System.out.print("\t");
			}
		}
		System.out.println("\tF\n");

	}

	/**
	 * Clase avanzaPosiciones
	 * 
	 * @param jugador
	 */
	public void avanzaPosiciones(int jugador) {
		// Variable para la suma de los dados
		int tirada = dado1 + dado2;
		// Creamos nuestra condicion
		if (jugador == 1) {
			fichaJ1 += tirada;
			// Creamos la segunda condicion
			if (fichaJ1 > TAM_TABLERO) {
				fichaJ1 = TAM_TABLERO - (fichaJ1 - TAM_TABLERO);
			}
			// Creamos la tercera condicion
		} else if (jugador == 2) {
			fichaJ2 += tirada;

			if (fichaJ2 > TAM_TABLERO) {
				fichaJ2 = 2 * TAM_TABLERO - fichaJ2;
			}
		}
	}

	/**
	 * Clase estadoCarrera
	 */
	public void estadoCarrera() {
		if (fichaJ1 > fichaJ2) {
			System.out.println("Va ganando " + nomJ1);
		} else if (fichaJ1 < fichaJ2) {
			System.out.println("Va ganando " + nomJ2);
		} else {
			System.out.println("Van empatados");
		}
		System.out.println();
	}

	/**
	 * Clase esGanador
	 * 
	 * @return
	 */
	public String esGanador() {

		if (fichaJ1 == TAM_TABLERO) {
			return nomJ1;
		} else if (fichaJ2 == TAM_TABLERO) {
			return nomJ2;
		} else {
			return "";
		}

	}

}
