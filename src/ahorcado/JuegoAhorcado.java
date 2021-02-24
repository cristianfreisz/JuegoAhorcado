package ahorcado;

import java.util.HashMap;
import java.util.Scanner;

public class JuegoAhorcado {
	static public String palabraAletoria() {
		Archivo a = new Archivo();
		HashMap<Integer, String> listaPalabras = new HashMap<Integer, String>();
		String s=a.leerTxt("E:\\Dropbox\\Dropbox\\CursoJAva\\JuegoAhorcado\\txt\\palabras.txt");
		
		listaPalabras = a.listarPalabras(s);
		System.out.println(listaPalabras);
		int numAle = (int) Math.floor(Math.random()*(listaPalabras.size()));	
		String palabraJuego= listaPalabras.get(numAle);
		return palabraJuego;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Ahorcado juego = new Ahorcado(palabraAletoria());
		Scanner sc = new Scanner(System.in);
		while(!juego.terminado()) {
			System.out.println(juego.mostrar());
			System.out.print("Escriba letra o palabra: ");
			String palabra = sc.next();
			
			if(palabra.length()==1) {
				juego.arriesgarLetra(palabra.charAt(0));
			}
			else {
				juego.arriesgarPalabra(palabra);
			}
		}
		System.out.println(juego.mostrar());
		if(juego.ganado()) {
			System.out.println("Gano");
		}
		else {
			System.out.println("Perdió");
		}
	
	}

}
