/**
*Esercizio 2.14
*Media pesata di 4 note
*
* @author Felix Brugger
* @version 09.02.2025
*/

public class NotaModuloFelix {
    public static void main(String[] args) {
		double nota1 = (Float.parseFloat(args[0]))*0.1;
		double nota2 = (Float.parseFloat(args[1]))*0.3;
		double nota3 = (Float.parseFloat(args[2]))*0.3;
		double nota4 = (Float.parseFloat(args[3]))*0.3;
		double notaF = (nota1+nota2+nota3+nota4);
		System.out.println(notaF);
	}
}