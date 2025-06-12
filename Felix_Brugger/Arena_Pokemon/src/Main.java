import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Pokedex pokedex = new Pokedex();
    public static Allenatore allenatore;

    public static void main(String[] args) {

        System.out.println("********************************************");
        System.out.println("        BENVENUTO NEL MONDO POKÉMON!        ");
        System.out.println("********************************************");
        System.out.println();

        inizializzaGiocatore();

        boolean continua = true;
        while(continua) {
            mostrarMenuPrincipale();
            int scelta = sceltaScanner(4);

            if (scelta == 1) {
                creaTeam();
            } else if (scelta == 2) {
                iniziaBattaglia();
            } else if (scelta == 3) {
                salvaTeam();
            } else if (scelta == 4) {
                System.out.println("Grazie per aver giocato, arrivederci!");
                continua = false;
            }
        }
        scanner.close();
    }

    public static void inizializzaGiocatore() {
        System.out.print("Inserisci il tuo nome, allenatore! ");
        String nome = scanner.nextLine();
        if (nome.isEmpty()) {
            nome = "Ash";
        }
        allenatore = new Allenatore(nome);
        System.out.println("Benvenuto in Pokémon, " + nome + "!");
        System.out.println();
    }

    public static void mostrarMenuPrincipale() {
        System.out.println("***** MENU PRINCIPALE *****");
        System.out.println("1) Crea Team");
        System.out.println("2) Inizia Battaglia");
        System.out.println("3) Salva Team");
        System.out.println("4) Esci");
        System.out.print("Scegli un'opzione: ");
    }

    public static void creaTeam() {
        System.out.println("\n***** CREAZIONE TEAM *****");

        boolean continua = true;
        while (continua) {
            System.out.println("\n1. Aggiungi Pokémon");
            System.out.println("2. Visualizza team");
            System.out.println("3. Torna al menu");
            System.out.print("Scegli: ");

            int scelta = sceltaScanner(3);

            if (scelta == 1) {
                addPokemon();
            } else if (scelta == 2) {
                System.out.println("\n" + allenatore.toString());
            } else if (scelta == 3) {
                continua = false;
            }
        }
    }

    public static void addPokemon() {
        if (allenatore.getTeam().isPieno()) {
            System.out.println("Team pieno (massimo 6 Pokémon)");
            return;
        }

        pokedex.mostraListaPokemon();
        System.out.print("Scegli un Pokémon: ");
        int scelta = sceltaScanner(pokedex.getDimensione());

        Pokemon pokemonScelto = pokedex.getPokemon(scelta);
        if (pokemonScelto != null && allenatore.aggiungiPokemon(pokemonScelto)) {
            System.out.println(pokemonScelto.getNome() + " aggiunto al team!");
        } else {
            System.out.println("Errore nell'aggiunta");
        }
    }

    public static void iniziaBattaglia() {
        if (allenatore.getTeam().isVuoto()) {
            System.out.println("Non puoi combattere senza Pokémon");
            return;
        }

        if (!allenatore.haPokemonVivi()) {
            System.out.println("Tutti i Pokémon sono stati sconfitti");
            return;
        }

        System.out.println("\n***** BATTAGLIA *****");
        Allenatore avversario = creaAvversario();

        System.out.println("Battaglia contro " + avversario.getNome() + "!");
        System.out.print("Premi INVIO per iniziare...");
        scanner.nextLine();

        Battaglia battaglia = new Battaglia(allenatore, avversario);
        battaglia.iniziaBattaglia();
    }

    /**
     * Sceglie l'avversario tramite random
     *
     * @return l'avversario
     */
    public static Allenatore creaAvversario() {
        String[] nomi = {"Brock", "Misty", "Lt. Surge", "Erika", "Gary"};
        Random random = new Random();
        String nome = nomi[random.nextInt(nomi.length)];

        Allenatore avversario = new Allenatore(nome);

        // numero casuale tra 2 e 4 inclusi
        int numPokemon = 2 + random.nextInt(3);
        List<Integer> indiciUsati = new ArrayList<>();

        for (int i = 0; i < numPokemon; i++) {
            int indice;
            do {
                indice = 1 + random.nextInt(pokedex.getDimensione());
            } while (indiciUsati.contains(indice));

            indiciUsati.add(indice);
            Pokemon pokemon = pokedex.getPokemon(indice);
            if (pokemon != null) {
                avversario.aggiungiPokemon(pokemon);
            }
        }

        return avversario;
    }

    /**
     * Salva il team nel file txt team_pokemon
     *
     */
    public static void salvaTeam() {
        if (allenatore.getTeam().isVuoto()) {
            System.out.println("Non puoi salvare un team vuoto");
            return;
        }

        List<String> righe = new ArrayList<>();
        righe.add("ALLENATORE:" + allenatore.getNome());
        righe.add("NUMERO POKEMON:" + allenatore.getTeam().getDimensione());

        List<Pokemon> membri = allenatore.getTeam().getMembri();
        for (int i = 0; i < membri.size(); i++) {
            Pokemon p = membri.get(i);
            righe.add(String.format("POKEMON_%d:%s|%s|%d|%d|%d|%d", i + 1, p.getNome(), p.getTipo(), p.getHpMax(), p.getAttacco(), p.getDifesa(), p.getVelocita()));
        }

        righe.add("**************************************");

        try {
            Path path = Paths.get("team_pokemon.txt");
            Files.write(path, righe, StandardOpenOption.APPEND);
            System.out.println("Team salvato in team_pokemon.txt");
        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    /**
     * Prende l'input dell'utente ad ogni scelta
     *
     * @return la scelta dell'utente
     */
    public static int sceltaScanner(int max) {
        int scelta = 0;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                String input = scanner.nextLine().trim();
                scelta = Integer.parseInt(input);

                if (scelta >= 1 && scelta <= max) {
                    inputValido = true;
                } else {
                    System.out.printf("Inserisci un numero tra %d e %d: ", 1, max);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Inserisci un numero valido tra %d e %d: ", 1, max);
            }
        }
        return scelta;
    }
}