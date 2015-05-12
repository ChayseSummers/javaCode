import java.util.Arrays;


public class CSC143ArrayList <E>{
	//data
	private E[] data;
	private int size;
	
	//constructor(s)
	@SuppressWarnings("unchecked")
	public CSC143ArrayList(){
		data = (E[]) new Object[10];
		size = 0;
	}
	@SuppressWarnings("unchecked")
	public CSC143ArrayList(int length){
		data = (E[]) new Object[length];
		size = 0;
	}
	
	//methods
	public int size(){
		return this.size;
	}
	public boolean isEmpty(){
		return (size==0);
	}
	public E get(int index){
		if(index < 0 || index >= size()){
			throw new IndexOutOfBoundsException("Index doesn't exist in the collection.");
		}
		else{
			return data[index];
		}
	}	
	public boolean add(E val){
		if(size>=data.length){
			@SuppressWarnings("unchecked")
			E[] temp =(E[]) new Object[data.length*2];
			int i = 0;
			for(E entry:data){
				temp[i] = entry;
				i++;
			}
			data = temp;
		}
		data[size]=val;
		++size;
		return true;
	}
	public boolean remove(E o){
		int index = indexOf(o);
		if(index >= 0){
			remove(index);
			return true;
		}
		else{
			return false;
		}
	}
	public E remove(int index){
		E toReturn = null;
		if(index < 0 || index >= size()){
			throw new IndexOutOfBoundsException("Index doesn't exist in the collection.");
		}
		else{
			toReturn = data[index];
			for(int i = index + 1;i<size;i++){
				data[i-1]=data[i];
			}
			data[size-1]=null;
			--size;
		}
		return toReturn;
		//How I did it.
//		E temp = data[index];
//		for(int i = index;i<data.length;i++){
//			data[i]=data[i+1];
//		}
//		return temp;
	}
	public int indexOf(E o){
		for(int i = 0; i<size; i++){
			if (data[i].equals(o)){
				return i;
			}
		}
		return -1;
//		int i = 0;
//		for(E element:data){
//			if(element.equals(o){
//				return i;
//			}
//			else{
//				i++;
//			}
//		}
	}
	public boolean contains(E val){
		return(indexOf(val)>=0);
	}
	public String toString(){ //This is hack, need to use fence post method to write our own toString.
		
		return Arrays.toString(data);
	}

}
