/**
* La classe Progressione è un programma che
* stampa se i numeri sono in una progressione costante uguale, sullo standard output.
*/

public class Vocali {
	
	public static void main(String[] args){
		
		String parola=args[0];
		for(int i=0;i<parola.length;i++){

			for (int f=numeri[i];f>0;f--){
				if(numeri[i]%f==0){
					conta++;
				}
			}
			if (conta==2){
				System.out.println(numeri[i]);
			}
		}
	}
}
