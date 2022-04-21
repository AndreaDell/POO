package poo.esempi;

import java.util.Scanner;

import poo.date.Data;
import poo.util.ArrayVector;
import poo.util.Vector;
import java.util.Iterator;

public class TestVector {
	public static void main( String[] args ) {
/*		
		Vector<Integer> vi=new ArrayVector<>(3);
		
		vi.add( 0 ); //dietro le quinte si fa new Integer(0) - autoboxing
		vi.add( 5 );
		vi.add( 8 );
		vi.add( 1, 17 );
		
		System.out.println(vi);
		
		int x=vi.get(0); //auto-unboxing cioè avviene che: vi.get(0).intValue()
		
		vi.remove(1);
		System.out.println(vi);
*/		
		Vector<String> vs=new ArrayVector<>();
		Scanner sc=new Scanner(System.in);
		for(;;) {
			System.out.print("Fornisci una stringa. Solo Invio per terminare: ");
			String st=sc.nextLine();
			if( st.length()==0 ) break;
			
			boolean flag=false;
			int i=0;
			while( i<vs.size() && !flag ) {
				String y=vs.get(i); //NON PIU' NECESSARIO IL CASTING
				if( y.compareTo(st)>=0 ) {
					vs.add( i, st );
					flag=true;
				}
				else i++;
			}//while
			if( !flag ) vs.add(st);
		}
		sc.close();
		System.out.println(vs);
/*
		Iterator<String> it=vs.iterator();
		while( it.hasNext() ) {
			String str=it.next();
			System.out.println(str);
			it.remove();
		}
		System.out.println(vs+" size="+vs.size());
*/
		for( String str: vs ) {//for-each - usa implicitamente, dietro le quinte, un iteratore
			System.out.println(str);
		}
		
/*		
		
		Vector<Character> vc=new ArrayVector<>();
		vc.add('a'); //autoboxing - new Character('a');
		vc.add('A');
		vc.add('Z');
		vc.add('5');
		vc.add('z');
		vc.add('9');
		System.out.println(vc);
		
		char c=vc.get(4); //auto-unboxing - get(4).charValue()
		
		double d=Double.parseDouble("3.4567");
		final int M=83;
		int h=0;
		h=h*M+x;
		h=h*M+((Double)d).hashCode();
		
		if( Character.isDigit(c) ) {
			int cifra=c-'0';
		}
			
		if( Character.isLetterOrDigit(c) ) ;//c è un carattere alfanumerico
		
		//Long, Byte, Short, Float, Boolean
*/
	}//main
}//TestVector
