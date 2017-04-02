package database;

public class Node implements Position {
	private Object element;
	Node next;
	
	public Node(Object e){
		element = e;
	}
	
	public Object element() {
		return element;
	}
}
