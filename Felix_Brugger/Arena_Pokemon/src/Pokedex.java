import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe contenente tutte le liste di mosse e Pokémon
 *
 * @author Felix Brugger
 * @version Giugno 2026
 */
public class Pokedex {
    private List<Pokemon> catalogo;
    private List<Mossa> mossa1;
    private List<Mossa> mossa2;
    private List<Mossa> mossa3;
    private List<Mossa> mossa4;
    private List<Mossa> mossa5;
    private List<Mossa> mossa6;

    public Pokedex() {

        this.catalogo = new ArrayList<>();


        this.mossa1 = new ArrayList<>();
        mossa1.add(new Mossa("Lanciafiamme", "Fuoco", 90));
        mossa1.add(new Mossa("Volo", "Volante", 90));
        mossa1.add(new Mossa("Taglio", "Normale", 50));
        mossa1.add(new Mossa("Dragartigli", "Drago", 80));

        catalogo.add(new Pokemon("Charizard", "Fuoco", 78, 84, 78, 100, mossa1));


        this.mossa2 = new ArrayList<>();
        mossa2.add(new Mossa("Idropompa", "Acqua", 110));
        mossa2.add( new Mossa("Surf", "Acqua", 90));
        mossa2.add(new Mossa("Bolla", "Acqua", 40));
        mossa2.add(new Mossa("Presa", "Normale", 55));

        catalogo.add(new Pokemon("Blastoise", "Acqua", 79, 83, 100, 78, mossa2));


        this.mossa3 = new ArrayList<>();
        mossa3.add(new Mossa("Foglielama", "Erba", 90));
        mossa3.add(new Mossa("Solarraggio", "Erba", 120));
        mossa3.add(new Mossa("Sonnifero", "Erba", 0));
        mossa3.add(new Mossa("Velenpolvere", "Veleno", 0));

        catalogo.add(new Pokemon("Venusaur", "Erba", 80, 82, 83, 80, mossa3));


        this.mossa4 = new ArrayList<>();
        mossa4.add(new Mossa("Fulmine", "Elettro", 90));
        mossa4.add(new Mossa("Tuono", "Elettro", 110));
        mossa4.add(new Mossa("Velocità", "Normale", 40));
        mossa4.add(new Mossa("Doppiasberla", "Normale", 15));

        catalogo.add(new Pokemon("Pikachu", "Elettro", 35, 55, 40, 90, mossa4));


        this.mossa5 = new ArrayList<>();
        mossa5.add(new Mossa("Psichico", "Psico", 90));
        mossa5.add(new Mossa("Psicoraggio", "Psico", 65));
        mossa5.add(new Mossa("Teletrasporto", "Psico", 0));
        mossa5.add(new Mossa("Recupero", "Normale", 0));

        catalogo.add(new Pokemon("Alakazam", "Psico", 55, 50, 45, 120, mossa5));


        this.mossa6 = new ArrayList<>();
        mossa6.add(new Mossa("Karatè", "Lotta", 50));
        mossa6.add(new Mossa("Sottomissione", "Lotta", 80));
        mossa6.add(new Mossa("Dinamipugno", "Lotta", 100));
        mossa6.add(new Mossa("Forzabruta", "Normale", 120));

        catalogo.add(new Pokemon("Machamp", "Lotta", 90, 130, 80, 55, mossa6));
    }

    public int getDimensione() {
        return catalogo.size();
    }

    public Pokemon getPokemon(int indice) {
        if (indice >= 1 && indice <= catalogo.size()) {
            return new Pokemon(catalogo.get(indice - 1));
        }
        return null;
    }

    public void mostraListaPokemon() {
        System.out.println("***** LISTA POKÉMON DISPONIBILI *****");
        System.out.printf("%-15s %-12s %-8s %-8s %-8s %-8s%n",
                "NOME", "TIPO", "HP", "ATK", "DEF", "VEL");
        System.out.println("***************************************************************");

        for (int i = 0; i < catalogo.size(); i++) {
            Pokemon pokemon = catalogo.get(i);
            System.out.printf("%2d. %-12s %-12s %-8d %-8d %-8d %-8d%n",
                    i + 1, pokemon.getNome(), pokemon.getTipo(),
                    pokemon.getHpMax(), pokemon.getAttacco(),
                    pokemon.getDifesa(), pokemon.getVelocita());
        }
        System.out.println();
    }
}