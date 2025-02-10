/**
* La classe Progressione è un programma che
* stampa se i numeri sono in una progressione costante uguale, sullo standard output.
*/

import java.util.Random;
public class Matrice {
    public static void main(String[] args) {
        Random rnd = new Random(); //Oggetto generatore Random
        int casuale = 0;
        int dimensione;
        int maxCasuale;
        try{
            maxCasuale = Integer.parseInt(args[1]);
            dimensione = Integer.parseInt(args[0]);
        }catch(NumberFormatException ne){
            System.out.println("Dimensione o massimo casuale non valido. Matrice impostata con valori di default");
            maxCasuale = 2;
            dimensione = 2;
        }
        int [][] matrice = new int[dimensione][dimensione];
        for(int i = 0;i< dimensione; i++){
            for(int j = 0;j < dimensione; j++){
                casuale = rnd.nextInt(maxCasuale);
                matrice[i][j] = casuale;
                System.out.print(casuale);
            }
            System.out.println();
        }
    }
}