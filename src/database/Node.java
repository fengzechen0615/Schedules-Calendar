package database;

public class Node implements Position {
	private Object element;
	Node next;
	
	public Node(Object e){
		element = e;
	}
	
	public String[] element() {
		return (String[]) element;
	}
}
