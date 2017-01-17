package nombres;

public class StringIntervalo {
	private String nombre;
	private Intervalo intervalo;
	
	public StringIntervalo() {
		super();
	}

	/**
	 * @param nombre
	 * @param Intervalo
	 */
	public StringIntervalo(String nombre, float min, float max) {
		super();
		this.nombre = nombre;
		intervalo = new Intervalo(min, max);
	}

	public String getNombre() {
		return nombre;
	}

	public Intervalo getIntervalo() {
		return intervalo;
	}
	
}
