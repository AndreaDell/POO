package poo.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class Heap<T extends Comparable<? super T>> implements Iterable<T>{
	private T[] heap; //usa gli indici da 1 in poi, sino a size
	private int n, size; //size punta all'ultimo occupato
	@SuppressWarnings("unchecked")
	public Heap( int n ) {
		if( n<=0 ) throw new IllegalArgumentException();
		this.n=n; size=0;
		heap=(T[])new Comparable[n+1];
	}
	public Heap() { this(17); }
	public int size() { return size; }
	public boolean contains( T x ) {
		if( size==0 || heap[1].compareTo(x)<0 ) return false;
		for( int i=2; i<=size; ++i )
			if( heap[i].equals(x) ) return true;
		return false;
	}//contains
	public void clear() {
		for( int i=1; i<=size; ++i )
			heap[i]=null;
		size=0;
	}//clear
	public String toString() {
		StringBuilder sb=new StringBuilder(300);
		sb.append('[');
		for( int i=1; i<=size; ++i ) {
			sb.append( heap[i] );
			if( i<size ) sb.append(", ");
		}
		sb.append(']');
		return sb.toString();
	}//toString
	
	public void add( T x ) {
		if( size==n ) {
			heap=java.util.Arrays.copyOf(heap,2*n+1);
			n=2*n;
		}
		size++;
		heap[size]=x;
		//aggiusta l'heap upward
		int i=size;
		while( i>1 ) {
			if( heap[i].compareTo(heap[i/2])<0 ) {
				//scambia figlio col padre
				T park=heap[i]; heap[i]=heap[i/2]; heap[i/2]=park;
				i=i/2;
			}
			else //fermati, heap aggiustato!
				break;	
		}
	}//add
	
	public T remove() {
		if( size==0 ) throw new NoSuchElementException();
		T min=heap[1]; //radice dell'albero heap
		heap[1]=heap[size];
		heap[size]=null; size--;
		//riaggiusta heap downward
		int i=1;
		while( i<=size/2 ) {
			//indici dei due figli di heap[i]
			int j=2*i, k=j+1;
			//trova minimo dei due figli
			int z=j; //ipotesi figlio piu' piccolo
			if( k<=size && heap[k].compareTo(heap[z])<0 ) z=k;
			if( heap[i].compareTo(heap[z])>0 ) {
				//scambia padre col piu' piccolo dei figli, cioe' heap[z]
				T park=heap[i]; heap[i]=heap[z]; heap[z]=park;
				i=z; //nuovo padre == minimo tra i due figli
			}
			else //heap riaggiustato, fermati
				break;
		}
		return min;
	}//remove
	
	public void remove( T x ) { //rimozione di un elemento in una posizione qualsiasi
		//scardina l'heap in modo radicale
		int i=1; //0 è una cella vacante
		while( i<=size ) {
			if( heap[i].equals(x) ) break;
			else i++;
		}
		if( i>size ) return;
		heap[i]=null; //toglie x
		int limite=size;
		size=i-1; //virtualmente sono tolti tutti gli elementi da i+1 in poi
		//re-inserire tutti gli elementi da i+1 a limite
		for( int j=i+1; j<=limite; ++j ) {
			T y=heap[j]; heap[j]=null;
			add( y );
		}
	}//remove
	
	public boolean equals( Object x ) {
		return false; //TODO
	}//equals
	
	public int hashCode() {
		return 0; //TODO
	}//hashCode
	
	public Iterator<T> iterator(){
		return new HeapIterator();
	}//iterator	
	
	private class HeapIterator implements Iterator<T>{
		private T cor=heap[1];
		private TreeSet<T> consumati=new TreeSet<>();
		private int pos=1;
		private boolean rimuovibile=false;
		public boolean hasNext() {
			if (pos<heap.length && !consumati.contains(cor))
				return true;
			return false;
			
		}//hasNext
		public T next() {
			if( !hasNext() ) throw new NoSuchElementException();
			int incr=1;
			while(consumati.contains(heap[pos+incr])) {
				incr++;
			}
			pos=pos+incr;
			cor=heap[pos];
			consumati.add(cor);
			rimuovibile=true;
			return cor;
		}//next
		public void remove() {
			if( !rimuovibile ) throw new IllegalStateException();
			rimuovibile=false;
			int incr=1;
			Heap.this.remove(cor);
			while(!consumati.contains(heap[pos-incr]) || incr<=pos) {
				incr++;
			}
			pos=pos-incr;
			cor=heap[pos];
		}//remove
	}//HeapIterator
	
	public static void main( String [] args ) {
		Heap<Integer> hs=new Heap<>();
		hs.add(5);
		hs.add(8);
		hs.add(7);
		hs.add(-8);
		hs.add(11);
		System.out.println(hs);
		
		System.out.println(hs);
		
		
	}//main
	
}//Heap
