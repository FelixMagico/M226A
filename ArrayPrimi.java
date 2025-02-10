/**
* La classe Progressione è un programma che
* stampa se i numeri sono in una progressione costante uguale, sullo standard output.
*/

public class ArrayPrimi {
	
	public static void main(String[] args){
		
		int[] numeri = {2,4,4,5,6,7,8,9,11,12};
		for(int i=0;i<numeri.length;i++){
			int conta=0;
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