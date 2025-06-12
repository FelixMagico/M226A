import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe con i vari Team
 *
 * @author Felix Brugger
 * @version Giugno 2026
 */
public class Team {
    private List<Pokemon> membri;
    private int membri_max = 6;

    public Team() {
        this.membri = new ArrayList<>();
    }

    public boolean aggiungiPokemon(Pokemon pokemon) {
        if (pokemon != null && membri.size() < membri_max) {
            membri.add(pokemon);
            return true;
        }
        return false;
    }

    public List<Pokemon> getMembri() {
        return new ArrayList<>(membri);
    }
    public int getDimensione() {
        return membri.size();
    }
    public boolean isPieno() {
        return membri.size() >= membri_max;
    }
    public boolean isVuoto() {
        return membri.isEmpty();
    }

    public Pokemon getPrimoPokemonVivo() {
        for (Pokemon pokemon : membri) {
            if (pokemon.isVivo()) {
                return pokemon;
            }
        }
        return null;
    }

    public boolean haPokemonVivi() {
        return getPrimoPokemonVivo() != null;
    }

    public List<Pokemon> getPokemonVivi() {
        List<Pokemon> vivi = new ArrayList<>();
        for (Pokemon pokemon : membri) {
            if (pokemon.isVivo()) {
                vivi.add(pokemon);
            }
        }
        return vivi;
    }

    @Override
    public String toString() {
        if (membri.isEmpty()) return "Team vuoto";

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("=== TEAM (%d/%d) ===\n", membri.size(), membri_max));
        for (int i = 0; i < membri.size(); i++) {
            Pokemon pokemon = membri.get(i);
            String stato = pokemon.isVivo() ? "VIVO" : "KO";
            sb.append(String.format("%d. %s [%s]\n", i + 1, pokemon.toString(), stato));
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(membri, team.membri);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(membri);
    }
}