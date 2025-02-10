/**
* La classe Pitagora è un programma che
* stampa la stringa della ipotenusa sullo standard output.
*/
public class Potenza {
	
	public static int getSquare(int number){
		return number * number;
	}
	
	public static void main(String[] args) {
		int lato1 = Integer.parseInt(args[0]);

		float ipotenusa = getSquare(lato1);
		
		System.out.println(ipotenusa);
	}
	
}
