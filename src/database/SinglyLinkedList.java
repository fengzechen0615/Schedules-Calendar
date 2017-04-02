package database;

public class SinglyLinkedList implements List {

	private Node first = null;
	private int size = 0;

	public Node first() {
		return  first;
	}

	public Node last() {
		if(isEmpty())
			return null;
		Node n = first;
		while(n.next != null){
			n = n.next;
		}
		return n;
	}
	
	public Node before(Node p) {
		if(isEmpty() || p == first)
			return null;
		Node i = first;
		while(i.next != null && i.next != p){
			i = i.next;
		}
		return i;
	}
	
	public Node after(Node p) {
		return p.next;
	}
	
	public Node insertBefore(Node p, Object d) {
		Node i = new Node(d);
		Node bp = before(p);
		i.next = p;
		bp.next = i;
		size = size + 1;
		return null;
	}
	
	public Node insertAfter(Node p, Object d) {
		Node i = new Node(d);
		i.next = p.next;
		p.next = i;
		size = size + 1;
		return null;
	}
	
	public Node insertFirst(Object d) {
		Node j = new Node(d);
		j.next = first;
		first= j;
		size = size + 1;
		return null;
	}
	
	public Node insertLast(Object d) {
		Node k = new Node(d);
		if (isEmpty()){
			k.next = first;
			first = k;
			size = size + 1;
		}
		else{
			Node p = last();
			p.next = k;
			size = size + 1;
		}
		return null;
	}
	
	public int remove(Node p) {
		if(p == first){
			first = p.next;
			size = size - 1;
		}
		Node i = first;
		while(i.next != null && i.next != p){
			i = i.next;
		}
		i.next = p.next;
		return 0;
	}

	public int size() {	
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void print() {
		if(isEmpty())
			return;
		Node n = first;
		System.out.print("[ "); 
		while(n != null){
			if(n.next != null) 
				System.out.print(n.element() + " -> ");
			else
				System.out.print(n.element()); 
			n = n.next;
		}
		System.out.println(" ]");
	}
	
}