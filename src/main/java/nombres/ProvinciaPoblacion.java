package nombres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import data.BalancedTree;

public class ProvinciaPoblacion {
	private Hashtable<String, List<String>> provinciaPoblacion;
	private String ficheroProvincia;
	private String ficheroPoblacion;
	private BalancedTree provincias;
	private ArrayList<StringIntervalo> listaProvincias;
	private Random random = new Random();

	public ProvinciaPoblacion(String ficheroProvincia, String ficheroPoblacion) {
		this.ficheroProvincia = ficheroProvincia;
		this.ficheroPoblacion = ficheroPoblacion;
		provinciaPoblacion = new Hashtable<String, List<String>>();
		leeFicheroProvincia();
		leeFicheroPoblacion();
	}

	private final void leeFicheroProvincia() {
		LeeFichero lector = new LeeFichero(ficheroProvincia);
		listaProvincias = lector.getIntervalos();
		provincias = new BalancedTree(listaProvincias);
	}

	private final void leeFicheroPoblacion() {
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream(ficheroPoblacion);
			InputStreamReader fr = new InputStreamReader(is);
//			FileReader fr = new FileReader(ficheroPoblacion);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea = br.readLine()) != null) {
				procesaLinea(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero: " + ficheroPoblacion);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void procesaLinea(String linea) {
		String tokens[] = linea.split(";");
		if(tokens.length == 3) {
			int codigoProvincia = Integer.parseInt(tokens[0]) - 1;
			String provincia = listaProvincias.get(codigoProvincia).getNombre();
//			System.out.println("Provincia: " + provincia);
			List<String> poblaciones = provinciaPoblacion.get(provincia);
			if(poblaciones == null) provinciaPoblacion.put(provincia, new ArrayList<String>());
			else poblaciones.add(tokens[2]);
		} else System.out.println("Algo raro hay en esta línea: " + linea);
	}

	public String getProvincia() {
		return provincias.contains(random.nextFloat()*100);
	}

	public String getPoblacion(String provincia) {
		List<String> poblaciones = provinciaPoblacion.get(provincia);
		if(poblaciones != null) {
			return poblaciones.get(random.nextInt(poblaciones.size()));
		}
		else return "La provincia no existe.";
	}
}
