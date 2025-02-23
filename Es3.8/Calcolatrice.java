/**
*Esercizio 3.8
*Tramite due numeri e un operatore si fanno i calcoli
*
* @author Felix Brugger
* @version 10.02.2025
*/

public class Calcolatrice {
    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		String oper = args[2];

		int ris = 0;
		
		if (oper.equals("+")) {
			ris = n1 + n2;
		}
		
		else if (oper.equals("-")) {
			ris = n1 - n2;
		}
		
		else if (oper.equals("/")) {
			ris = n1 / n2;
		}
		
		else {
			ris = n1 * n2;
		}
		
		System.out.println(n1 + " " + oper + " " + n2 + " = " + ris);
    }
}