/**
* La classe Pitagora è un programma che
* stampa la stringa della ipotenusa sullo standard output.
*/
import java.util.Random;
public class SwapValori {
	
	public static void main(String[] args) {
		int valA = Integer.parseInt(args[0]);
		int valB = Integer.parseInt(args[1]);
		System.out.println(valA);
		System.out.println(valB);	
		
		int valC = 0;
		valC=valB;
		valB=valA;
		valA=valC;
		System.out.println(valA);
		System.out.println(valB);
	}
	
}