import java.util.*;

/**
 * Classe che gestisce la battaglia tra i vari Pokémon
 *
 * @author Felix Brugger
 * @version Giugno 2026
 */
public class Battaglia {
    private Allenatore giocatore;
    private Allenatore avversario;
    private Pokemon pokemonGiocatore;
    private Pokemon pokemonAvversario;
    private Scanner scanner;
    private Random random;
    private int turniTotali;

    public Battaglia(Allenatore giocatore, Allenatore avversario) {
        this.giocatore = giocatore;
        this.avversario = avversario;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.turniTotali = 0;
    }

    /**
     * Imposta la logica della battaglia
     *
     */
    public void iniziaBattaglia() {
        System.out.println("*************************************************");
        System.out.println("           INIZIA LA BATTAGLIA! ");
        System.out.println("*************************************************");

        pokemonGiocatore = selezionaPokemonGiocatore();
        pokemonAvversario = avversario.getPrimoPokemonVivo();


        System.out.println(giocatore.getNome() + " manda in campo " + pokemonGiocatore.getNome());
        System.out.println(avversario.getNome() + " manda in campo " + pokemonAvversario.getNome());

        while (giocatore.haPokemonVivi() && avversario.haPokemonVivi()) {
            eseguiTurno();
            turniTotali++;

            if (!pokemonGiocatore.isVivo()) {
                System.out.println(pokemonGiocatore.getNome() + " è stato sconfitto");
                if (giocatore.haPokemonVivi()) {
                    pokemonGiocatore = selezionaPokemonGiocatore();
                } else break;
            }

            if (!pokemonAvversario.isVivo()) {
                System.out.println(pokemonAvversario.getNome() + " è stato sconfitto");
                if (avversario.haPokemonVivi()) {
                    pokemonAvversario = avversario.getPrimoPokemonVivo();
                } else break;
            }
        }

        if (giocatore.haPokemonVivi()) {
            System.out.println(giocatore.getNome() + " ha vinto la battaglia!");
        } else {
            System.out.println(avversario.getNome() + " ha vinto la battaglia!");
        }

        System.out.println("Battaglia durata " + turniTotali + " turni");
        System.out.println("**********************************************");
    }

    /**
     * Fa selezionare al giocatore con quale Pokémon combattere
     *
     * @return il Pokémon scelto dall'utente nella lista di quelli ancora vivi
     *
     */
    public Pokemon selezionaPokemonGiocatore() {
        List<Pokemon> pokemonVivi = giocatore.getTeam().getPokemonVivi();
        if (pokemonVivi.isEmpty()) {
            return null;
        }
        if (pokemonVivi.size() == 1) {
            return pokemonVivi.get(0);
        }

        System.out.println("***** SELEZIONE POKÉMON *****");
        for (int i = 0; i < pokemonVivi.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, pokemonVivi.get(i).toString());
        }

        System.out.print("Scegli il tuo Pokémon: ");
        int sceltaPokemon = -1;
        boolean sceltaValidaPokemon = false;

        while (!sceltaValidaPokemon) {
            try {
                String input = scanner.nextLine().trim();
                sceltaPokemon = Integer.parseInt(input);
                if (sceltaPokemon >= 1 && sceltaPokemon <= pokemonVivi.size()) {
                    sceltaValidaPokemon = true;
                } else {
                    System.out.printf("Inserisci un numero tra %d e %d: ", 1, pokemonVivi.size());
                }
            } catch (NumberFormatException e) {
                System.out.printf("Inserisci un numero valido tra %d e %d: ", 1, pokemonVivi.size());
            }
        }

        return pokemonVivi.get(sceltaPokemon - 1);

    }

    /**
     * Contiene la logica del turno con gli attacchi vari
     *
     */
    public void eseguiTurno() {
        System.out.println("***** TURNO " + (turniTotali + 1) + " *****");
        System.out.println(pokemonGiocatore.toString());
        System.out.println(pokemonAvversario.toString());

        Mossa mossaGiocatore = selezionaMossaGiocatore();
        Mossa mossaAvversario = selezionaMossaAvversario();

        boolean giocatorePrimo = pokemonGiocatore.getVelocita() >= pokemonAvversario.getVelocita();

        if (giocatorePrimo) {
            eseguiAttacco(pokemonGiocatore, pokemonAvversario, mossaGiocatore);
            if (pokemonAvversario.isVivo()) {
                eseguiAttacco(pokemonAvversario, pokemonGiocatore, mossaAvversario);
            }
        } else {
            eseguiAttacco(pokemonAvversario, pokemonGiocatore, mossaAvversario);
            if (pokemonGiocatore.isVivo()) {
                eseguiAttacco(pokemonGiocatore, pokemonAvversario, mossaGiocatore);
            }
        }
    }

    /**
     * Fa selezionare al giocatore la mossa del Pokémon
     *
     * @return la mossa scelta
     *
     */
    public Mossa selezionaMossaGiocatore() {
        List<Mossa> mosse = pokemonGiocatore.getMosse();
        if (mosse.isEmpty()) {
            return new Mossa("Tackle", "Normale", 40);
        }

        System.out.println("***** SELEZIONE MOSSA *****");
        for (int i = 0; i < mosse.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, mosse.get(i).toString());
        }

        System.out.print("Scegli la mossa: ");
        int sceltaMossa = -1;
        boolean sceltaValidaMossa = false;

        while (!sceltaValidaMossa) {
            try {
                String input = scanner.nextLine().trim();
                sceltaMossa = Integer.parseInt(input);
                if (sceltaMossa >= 1 && sceltaMossa <= mosse.size()) {
                    sceltaValidaMossa = true;
                } else {
                    System.out.printf("Inserisci un numero tra %d e %d: ", 1, mosse.size());
                }
            } catch (NumberFormatException e) {
                System.out.printf("Inserisci un numero valido tra %d e %d: ", 1, mosse.size());
            }
        }

        return mosse.get(sceltaMossa - 1);

    }

    /**
     * Seleziona una mossa random per l'avversario
     *
     * @return la mossa random
     */
    public Mossa selezionaMossaAvversario() {
        List<Mossa> mosse = pokemonAvversario.getMosse();
        if (mosse.isEmpty()) {
            return new Mossa("Tackle", "Normale", 40);
        }
        return mosse.get(random.nextInt(mosse.size()));
    }

    public void eseguiAttacco(Pokemon attaccante, Pokemon difensore, Mossa mossa) {
        System.out.println(attaccante.getNome() + " usa " + mossa.getNome() + "!");

        int danno = calcolaDanno(attaccante, difensore, mossa);

        if (danno > 0) {
            difensore.subisciDanno(danno);
            System.out.println(difensore.getNome() + " subisce " + danno + " danni!");
            System.out.println(difensore.getNome() + " ha ora " + difensore.getHp() + "/" + difensore.getHpMax() + " HP");
        } else {
            System.out.println("L'attacco non ha effetto");
        }

        System.out.println();
    }

    public int calcolaDanno(Pokemon attaccante, Pokemon difensore, Mossa mossa) {
        if (mossa.getPotenza() <= 0) {
            return 0;
        }
        double dannoBase = (double) attaccante.getAttacco() * mossa.getPotenza() / difensore.getDifesa();
        return Math.max(1, (int) dannoBase);
    }
}
