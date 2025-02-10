/**
* La classe Pitagora è un programma che
* stampa la stringa della ipotenusa sullo standard output.
*/
public class Pitagora {
	
	public static int getSquare(int number){
		return number * number;
	}
	
	public static void main(String[] args) {
		int lato1 = Integer.parseInt(args[0]);
		int lato2 = Integer.parseInt(args[1]);
		double ipotenusa = Math.sqrt(getSquare(lato1) + getSquare(lato2));
		
		System.out.println("Cateti inseriti: " + lato1 + " e "  + lato2);
		System.out.println("Ipotenusa: " + ipotenusa);
	}
	
}
