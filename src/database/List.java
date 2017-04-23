package database;

public interface List {

	public Node first();
	public Node last();
	public Node before(Node p);
	public Node after(Node p);
	public Node insertBefore(Node p,Object d);
	public Node insertAfter(Node p,Object d);
	public Node insertFirst(Object d);
	public Node insertLast(Object d);
	public int remove(Node p);
	public int size();
	public boolean isEmpty();
	public void print();
	
}
