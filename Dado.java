/**
* La classe Pitagora è un programma che
* stampa la stringa della ipotenusa sullo standard output.
*/
import java.util.Random;
public class Dado {
	
	public static void main(String[] args) {

		Random rnd=new Random();
		int Casuale= rnd.nextInt(1,7);
		System.out.println(Casuale);
	}
	
}