/**
* La classe Pitagora è un programma che
* stampa la stringa della ipotenusa sullo standard output.
*/
public class Multipli {

	public static void main(String[] args) {
		int lato1 = Integer.parseInt(args[0]);
		int multiplo=5;
		double risultato= lato1%5;
		if( risultato !=0){
			System.out.println(lato1 +" non è multiplo di 5");
		}
		else{
			System.out.println(lato1 +" è multiplo di 5");
		}

	}
}