package ahorcado;
import java.lang.*;

public class Ahorcado {
	private String oculta;
	private int vidas;
	private char[] respuestas;

	public Ahorcado(String palabraSecreta) {
		this.oculta = palabraSecreta.toLowerCase();
		this.vidas = 5;
		this.respuestas = new char[this.oculta.length()];
		for (int i = 0; i < respuestas.length; i++) {
			this.respuestas[i] = '_';
		}
	}

	public StringBuilder mostrar() {
		StringBuilder sb = new StringBuilder(this.oculta.length());
		sb.append(toString()+"\n");
		for (int i = 0; i < respuestas.length; i++) {
			sb.append(this.respuestas[i]);
			sb.append(" ");
		}
		
		return sb;
	}
	
	@Override
	public String toString() {
		return "vidas: " + vidas;
	}

	/*arriesgarLetra(char letra)
	 * Devuelve true si la letra se encuentra en la palabra oculta
	 * sino descuenta una vida y retorna false
	 */
	public boolean arriesgarLetra(char l) {
		char letra = Character.toLowerCase(l);
		boolean laEncontre=false;
		if(this.vidas>0) {
			for (int i = 0; i < this.oculta.length(); i++) {
				if(this.oculta.charAt(i)==letra) {
					this.respuestas[i] = letra;
					laEncontre=true;
				}
			}
			if(!laEncontre) {//laEncontre==false
				this.vidas--;
			}
			
		}
		return laEncontre;
	}
	
	/* arriesgarPalabra(String palabra)
	 * Recibe una Palabra y si es igual a la palabra oculta, gana el juego sino pierde
	 */
	public void arriesgarPalabra(String p) {
		p=p.toLowerCase();
		if(p.equals(this.oculta)) {
			for (int i = 0; i < respuestas.length; i++) { //Contiene la letra
				this.respuestas[i]= oculta.charAt(i);
			}
		}
		else {
			this.vidas=0;	
		}
	}
	
	public boolean ganado() {
		for (int i = 0; i < respuestas.length; i++) {
			if(respuestas[i]=='_') { //Si hay '_' todavía hay palabras sin descubrir
				return false;
			}
		}
		return true;		
	}
	
	public boolean terminado() {
		return this.ganado() || this.vidas==0;
	}
	


}
