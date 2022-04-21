package poo.esempi;

import java.util.StringTokenizer;

public class ValutatoreEspressione {
	private String expr;
	public ValutatoreEspressione( String expr ) {
		//validazione expr mediante regex - rimandata
		this.expr=expr;
	}
	public int valuta() {
		StringTokenizer st=new StringTokenizer(expr,"+-*/()",true);
		return valutaEspressione(st);
	}//valuta
	private int valutaOperando( StringTokenizer st ) {
		String tok=st.nextToken();
		if( tok.charAt(0)=='(' ) return valutaEspressione(st);
		return Integer.parseInt(tok);
	}//valutaOperando
	private int valutaEspressione( StringTokenizer st ) {
		int ris=valutaOperando(st); //risultato parziale
		while( st.hasMoreTokens() ) {
			char op=st.nextToken().charAt(0);
			if( op==')' ) return ris;
			int opnd=valutaOperando(st);
			switch( op ) {
			case '+': ris=ris+opnd; break;
			case '-': ris=ris-opnd; break;
			case '*': ris=ris*opnd; break;
			case '/': ris=ris/opnd; break;
			default : throw new RuntimeException(op+" inatteso");
			}
		}
		return ris;
	}//valutaEspressione
	public static void main( String[] args ) {
		//espressione attesa a riga di comando
		if( args.length==0 || args.length>1 ) { 
			System.out.println("Attesa espressione."); System.exit(-1); 
		}
		ValutatoreEspressione v=new ValutatoreEspressione(args[0]);
		System.out.println(args[0]+"="+v.valuta());
	}//main
}//ValutatoreEspressione
