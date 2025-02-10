/**
* La classe Pitagora è un programma che
* stampa la stringa della ipotenusa sullo standard output.
*/
public class Codice {
	
	public static int getSquare(int number){
		return number * number;
	}
	
	public static void main(String[] args) {
		String parola = args[0];
		
		String lettera1 = parola.substring(0,1);
		String lettera2 = parola.substring(2,3);
		String lettera3 = parola.substring(parola.length()-1,parola.length());
		String lettera4 = parola.substring(parola.length()-2,parola.length()-1);
		String parola2= (lettera1+lettera2+lettera3+lettera4);
		System.out.println(parola2);
	}
}