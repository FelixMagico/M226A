/**
 *Es4.9
 *Confronta N stringhe passate da argomento e le stampa ordinate per lunghezza
 *
 * @author Felix Brugger
 * @version 23.02.2025
 */

public class Main {
    public static void main(String[] args) {
        String[] input = new String[args.length];

        System.out.print("Stampa di args: ");
        for (int i = 0; i < args.length; i++) {
            input[i] = args[i];
            System.out.print(args[i] + " ");
        }
        System.out.println("");

        for (int x = 0; x < input.length - 1; x++) {
            for (int y = 0; y < input.length - 1 - x; y++) {
                if (input[y].length() > input[y + 1].length()) {
                    String primo = input[y];
                    input[y] = input[y + 1];
                    input[y + 1] = primo;
                }
            }
        }

        for (String s : input) {
            System.out.println(s);
        }
    }
}