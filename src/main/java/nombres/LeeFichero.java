package nombres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class LeeFichero {
	private String nombreFichero;
	private ArrayList<NombreFrecuencia> nombreFrecuencia = new ArrayList<NombreFrecuencia>();
	private ArrayList<StringIntervalo> nombreIntervalo = new ArrayList<StringIntervalo>();
	
	public LeeFichero(String nombreFichero) {
		super();
		this.nombreFichero = nombreFichero;
		leeFichero();
		procesaDatos();
		creaIntervalos();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<StringIntervalo> getIntervalos() {
		return (ArrayList<StringIntervalo>)nombreIntervalo.clone();
	}
	
	private final ArrayList<NombreFrecuencia> leeFichero() {
		try {
			// Las dos siguiente líneas leen los datos desde el .jar
			InputStream is = getClass().getClassLoader().getResourceAsStream(nombreFichero);
			InputStreamReader fr = new InputStreamReader(is);
//			FileReader fr;
//			fr = new FileReader(nombreFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea = br.readLine()) != null) {
				nombreFrecuencia.add(procesaLinea(linea));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return nombreFrecuencia;
	}
	
	private void procesaDatos() {
		float total = 0;
		
		for(NombreFrecuencia dato: nombreFrecuencia) total += dato.getFrecuencia();
		
		for(NombreFrecuencia dato: nombreFrecuencia) {
			dato.setFrecuencia(dato.getFrecuencia()/total*100);
		}
	}
	
	private void creaIntervalos() {
		float frecuenciaAcumulada = 0.0f;
		float min, max;
		for(NombreFrecuencia datoFrecuencia: nombreFrecuencia) {
			min = frecuenciaAcumulada;
			frecuenciaAcumulada += datoFrecuencia.getFrecuencia();
			max = frecuenciaAcumulada;
			if(max > 100) max = 100;
			nombreIntervalo.add(new StringIntervalo(datoFrecuencia.getNombre(), min, max));
		}
	}
	
	private NombreFrecuencia procesaLinea(String linea) {
		String tokens[] = linea.split(";");
		return new NombreFrecuencia(tokens[0], Float.valueOf(tokens[1]).floatValue());
	}
	
	// Clase de utilidad para procesar datos de frecuencia
	private class NombreFrecuencia {
		private String nombre;
		private float frecuencia;
		
		public NombreFrecuencia(String nombre, float frecuencia) {
			this.nombre = nombre;
			this.frecuencia = frecuencia;
		}

		public String getNombre() {
			return nombre;
		}

		public float getFrecuencia() {
			return frecuencia;
		}

		public void setFrecuencia(float frecuencia) {
			this.frecuencia = frecuencia;
		}
	}

}
