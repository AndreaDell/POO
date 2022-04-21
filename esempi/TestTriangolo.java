package poo.esempi;

import poo.geometria.*;

public class TestTriangolo{
	public static void main(String[] args){
	   Triangolo t=null;
	   //t=new Triangolo( new Punto(1,1), new Punto(-2,-2), new Punto(3,3) );
	   t=new Triangolo( new Punto(0,1), new Punto(3,2), new Punto(4,7) );
	   System.out.println(t);
	   System.out.printf("perimetro=%1.2f area=%1.2f\n",t.perimetro(),t.area());
	   t=new Triangolo( new Punto(2,2), new Punto(4,2), new Punto(4,5) );
	   System.out.println(t);
	   System.out.printf("perimetro=%1.2f area=%1.2f\n",t.perimetro(),t.area());
	   t=new Triangolo( new Punto(2,0), new Punto(2,2), new Punto() );
	   System.out.println(t);
	   System.out.printf("perimetro=%1.2f area=%1.2f\n",t.perimetro(),t.area());
   }
}//TestTriangolo