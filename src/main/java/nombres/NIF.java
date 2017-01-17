package nombres;

import java.util.Random;

public class NIF {
	private final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	private Random random;
	
	public NIF() {
		random = new Random();
	}

	/**
	 * Tomado de <a href="http://es.wikibooks.org/wiki/Algoritmo_para_obtener_la_letra_del_NIF">
	 * Wikibboks</a>
	 * @return NIF con la letra
	 */
	public String getNIF() {
		int dni = random.nextInt(99999999);
		return (""+ dni + LETRAS.charAt(dni % 23));
	}
}
