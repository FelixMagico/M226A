/**
* La classe Progressione è un programma che
* stampa se i numeri sono in una progressione costante uguale, sullo standard output.
*/

public class ProgressioneAritmetica {
	
	public static void main(String[] args){
		
		int numero1 = Integer.parseInt(args[0]);
		int numero2 = Integer.parseInt(args[1]);
		int numero3 = Integer.parseInt(args[2]);

		int differenza = numero2-numero1;
		
		if (numero2-numero1 == numero3-numero2){
			System.out.println("I tre numeri sono in progressione aritmetica " + "(differenza costante di " + differenza + " )");
		}
		else{
			System.out.println("I tre numeri non sono in progressione aritmetica, differenza non costante");
		}
	}
}