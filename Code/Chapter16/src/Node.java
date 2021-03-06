
public class Node <E> {
	private E data;
	private Node <E> next;

	
	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}
	@Override
	public String toString() {
		return data + "--->" + next;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public static void main(String[] args) {
		Node <Integer> n1 = new Node<Integer>(10, null);
		Node <Integer> n2 = new Node<Integer>(20, null);
		Node <Integer> n3 = new Node<Integer>(30, null);
		n1.setNext(n2);n2.setNext(n3);
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		n2.setNext(n1);n1.setNext(n3);
		System.out.println(n2);
		
	}

}
