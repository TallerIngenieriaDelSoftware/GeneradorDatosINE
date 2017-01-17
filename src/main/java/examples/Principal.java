package examples;

import es.uji.www.GeneradorDatosINE;

public final class Principal {
	private Principal() {
		super();
	}

	private void ejecuta() {
		
		GeneradorDatosINE nie = new GeneradorDatosINE();
		System.out.println("Hombre: " + nie.getNombreHombre());
		System.out.println("Mujer: " + nie.getNombreMujer());
		System.out.println("Nombre: " + nie.getNombre());
		String provincia = nie.getProvincia();
		System.out.println("Provincia: " + provincia);
		System.out.println("Poblacion: " + nie.getPoblacion(provincia));
		System.out.println("DNI: " + nie.getNIF());
	}

	public static void main(String[] args) {
		new Principal().ejecuta();
	}
}
