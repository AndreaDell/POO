package poo.esempi;

import java.util.Scanner;

public class BucketSort {
	public static void main( String[] args ) {
		Scanner sc=new Scanner( System.in );
		int b[]=new int[101]; //azzerato per default
		for(;;) {
			int x=sc.nextInt();
			if( x<0 || x>100 ) break;
			b[x]++;
		}
		for( int i=0; i<=100; ++i )
			if( b[i]!=0 )
			for( int j=0; j<b[i]; ++j )
				System.out.print(i+" ");
		System.out.println();
		sc.close();
	}
}
