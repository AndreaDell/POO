package poo.esempi;

import java.util.Scanner;
import poo.util.Stack;
import poo.util.StackConcatenato;

public class TestStack {
	public static void main( String[] args ) {
		String INPUT="\\w+\\$\\w+";
		Scanner sc=new Scanner( System.in );
		System.out.print("Fornisci una linea tipo string$string> ");
		String linea=sc.nextLine().toUpperCase();
		sc.close();
		if( !linea.matches(INPUT) ) throw new RuntimeException("Linea malformata.");
		Stack<Character> pila=new StackConcatenato<>();
		int i=linea.indexOf('$');
		for( int j=0; j<i; ++j )
			pila.push( linea.charAt(j) );
		int j=i+1;
		for( ; j<linea.length(); ++j ) {
			try {
				if( pila.pop()!=linea.charAt(j) ) break;
			}catch( RuntimeException e ) {
				System.out.println(linea+" e' non palindroma.");
				System.exit(-1);
			}
		}
		if( j<linea.length() || !pila.isEmpty() )
			System.out.println(linea+" e' non palindroma.");
		else
			System.out.println(linea+" e' palindroma.");
	}//main
}//TestStack
