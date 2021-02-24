package ahorcado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Archivo {
	public String leerTxt(String direccion) 
	{
		String texto = "";
		try {
			BufferedReader bf =  new BufferedReader(new FileReader(direccion));
			String temp = "";
			String bfRead;
			while((bfRead = bf.readLine()) != null) {
				//hax el ciclo, mientras bfRead tine datos
				temp = temp + bfRead; //Guardado el texto del archivo
			}
			bf.close();
			texto = temp;
		} catch (Exception e) {
			System.err.println("No se encontró atcivo");
		}
	
		return texto;
	}

	public HashMap listarPalabras(String palabras) //Recibe una cadena larga de string donde separa las palabras con coma y sin espacios
	{
		HashMap listaPalabras = new HashMap<Integer, String>();
		StringBuilder auxPalabra = new StringBuilder(palabras.charAt(0)); //Inicializo
		int num = 0; //cantidad de palabras para key del hashmap
		for (int i = 0; i < palabras.length(); i++) {
			if(!(palabras.charAt(i) == ',')) {
				auxPalabra.append(palabras.charAt(i)); //Agrego las letras
			}else { //Si encuentra una coma finaliza la palabra
					String singleString = auxPalabra.toString();
					listaPalabras.put(num, singleString); //Agrega la palabra al diccionario
					auxPalabra.delete(0, auxPalabra.capacity()); //Recetea
					num++;
			}
		}
		return listaPalabras;
	}
	
	/*
	public HashMap listarPalabras(String palabras) {
		HashMap listaPalabras = new HashMap<Integer, String>();
		String auxPalabra = "";
		int num = 0;
		for (int i = 0; i < palabras.length(); i++) {
			if(!(palabras.charAt(i) == ',')) {
				auxPalabra = auxPalabra + palabras.charAt(i);
			}else {
					listaPalabras.put(num, auxPalabra);
					auxPalabra = "";
					num++;
			}
		}
		return listaPalabras;
	}

 */
}
