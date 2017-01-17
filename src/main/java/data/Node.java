package data;

import nombres.StringIntervalo;

public class Node {
	private Node left = null;
	private Node right = null;
	private StringIntervalo intervalo;
	
	public Node(StringIntervalo intervalo) {
		this.intervalo = intervalo;
	}
	
	public void addLeft(Node left) {
		this.left = left;
	}
	
	public void addRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public StringIntervalo getIntervalo() {
		return intervalo;
	}
	
	public int contains(float value) {
		return intervalo.getIntervalo().contiene(value);
	}

	@Override
	public String toString() {
		return "Node [data=" + intervalo + "]";
	}
}
