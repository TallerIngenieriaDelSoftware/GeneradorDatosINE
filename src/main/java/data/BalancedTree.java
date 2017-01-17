package data;

import java.util.ArrayList;

import nombres.StringIntervalo;

public class BalancedTree {
	private Node root;

	public BalancedTree() {
		super();
	}

	public BalancedTree(ArrayList<StringIntervalo> data) {
		root = new Node(data.get((data.size()-1)/2));
		createTree(data, root, 0, data.size()-1);
	}

	private final void createTree(ArrayList<StringIntervalo> data, Node nodo, int izq, int der) {
		Node nodoIzq, nodoDer;
		int centro = (izq + der)/2;
			if(izq <= centro-1) {
				nodoIzq = new Node(data.get((izq + centro-1)/2));
				nodo.addLeft(nodoIzq);
				createTree(data, nodoIzq, izq, centro-1);
			}
			if(der >= centro+1) {
				nodoDer = new Node(data.get((centro+1 + der)/2));
				nodo.addRight(nodoDer);
				createTree(data, nodoDer, centro+1, der);
			}
	}

	public Node getRoot() {
		return root;
	}
	
	public void showTree() {
		showTree(root);
	}
	
	private void showTree(Node nodo) {
		if(nodo.getLeft() != null) showTree(nodo.getLeft());
		if(nodo.getRight() != null) showTree(nodo.getRight());
		System.out.println(nodo);
	}
	
	public String contains(float value) {
		return contains(root, value);
	}
	
	private String contains(Node nodo, float value) {
		if(nodo == null) return "No se encotró.";
		int contiene = nodo.contains(value);
		if(contiene == 0) return nodo.getIntervalo().getNombre();
		else {
			if(contiene < 0) return contains(nodo.getLeft(), value);
			else if(contiene > 0) return contains(nodo.getRight(), value);
		}
		return "No se encontró.";
	}	
}
