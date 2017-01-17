package nombres;

public class Intervalo {
	private float min;
	private float max;
	/**
	 * 
	 */
	public Intervalo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param min
	 * @param max
	 */
	public Intervalo(float min, float max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	public boolean dentro(float valor) {
		if(valor >= min && valor <= max) return true;
		else return false;
	}
	
	public int contiene(float valor) {
		if(valor < min) return -1;
		else if(valor > max) return +1;
		else return 0;
	}
	
	@Override
	public String toString() {
		return "[" + min + ", " + max + "]";
	}
}
