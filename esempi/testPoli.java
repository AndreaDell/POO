package poo.esempi;

import poo.polinomi.Monomio;
import poo.polinomi.Polinomio;
import poo.polinomi.PolinomioLL;
import poo.polinomi.PolinomioSet;

public class testPoli {
	public static void main( String[] args ) {
		Polinomio p=new PolinomioSet();
		p.add( new Monomio(-3,0) );
		p.add( new Monomio(4,2) );
		p.add( new Monomio(-7,5) );
		p.add( new Monomio(-9,2) );
		p.add( new Monomio(3,5) );
		p.add( new Monomio(0,8) );
		System.out.println(p);
		Monomio m=new Monomio(5,2);
		p=p.mul(m);
		System.out.println(p);
		Polinomio q=new PolinomioSet();
		q.add( new Monomio(6,2) );
		q.add( new Monomio(7,5) );
		q.add( new Monomio(-2,4) );
		q.add( new Monomio(1,7) );
		q.add( new Monomio(3,0) );
		System.out.println(q);
		Polinomio ps=p.add(q);
		Polinomio pp=p.mul(q);
		System.out.println(p+" + "+q+" = "+ps);
		System.out.println("("+p+") * ("+q+") = "+pp);
		Polinomio pd=pp.derivata();
		System.out.println("("+pp+")' = "+pd);
		System.out.printf("pd("+2.3+")=%1.2f%n",pd.valore(2.3));
	}//main
}//TestPoli
