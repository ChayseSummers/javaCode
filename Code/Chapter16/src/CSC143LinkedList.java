
public class CSC143LinkedList<E> {
	private Node<E> head;
	
	public String toString(){
		if(head!=null)
			return head.toString();
		else
			return "null";
	}
	
	public void add(E val){
		head = new Node<E>(val,head);
	}
	public void addAtTail(E val){
		Node<E> newNode = new Node<E>(val,null);
		if(head==null)
			head = newNode;
		else{
			Node<E> cursor = head;
			while(cursor.getNext()!=null)
				cursor = cursor.getNext();
			//for(; cursor.getNext()!=null;cursor = cursor.getNext());
			cursor.setNext(newNode);
		}
	}
	//write indexOf and contains
	
	public boolean contains(E val){
		Node<E> cursor = head;
		while(cursor!=null){
			if(cursor.getData().equals(val))
				return true;
			cursor = cursor.getNext();
		}
		return false;
	}
	
	public E indexOf (E val){
		Node<E> cursor = head;
		return null;
	}
	
	public int size(){
		int count = 0;
		for(Node<E> cursor = head; cursor != null; cursor = cursor.getNext())
			++count;
		return count;
	}
	
	public E remove(int index){
		if(index>=0 && index<=this.size()){
			if(index>0){
				Node<E> cursor = head;
				int i = 0;
				while(i<index-1){
					cursor = cursor.getNext();
					++i;
				}
				E r = cursor.getNext().getData();
				cursor.setNext(cursor.getNext().getNext());
				return r;
			}
			else{// head needs to be updated.
				E r = head.getData();
				head=head.getNext();
				return r;
			}
		}	
		else
			throw new IndexOutOfBoundsException();
	}

	public static void main(String[] args) {
		CSC143LinkedList<Integer> list = new CSC143LinkedList<Integer>();
		for(int i = 0; i<=100;i++)
			list.addAtTail(i);
		System.out.println(list);
		System.out.println(list.remove(0));
		System.out.println(list);
	}

}
