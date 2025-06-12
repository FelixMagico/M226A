import java.util.Objects;

/**
 * Classe con l'allenatore dei Pokémon
 *
 * @author Felix Brugger
 * @version Giugno 2026
 */
public class Allenatore {
    private String nome;
    private Team team;

    public Allenatore(String nome) {
        this.nome = nome;
        this.team = new Team();
    }

    public String getNome() {
        return nome;
    }

    public Team getTeam() {
        return team;
    }

    public boolean haPokemonVivi() {
        return team.haPokemonVivi();
    }
    public Pokemon getPrimoPokemonVivo() {
        return team.getPrimoPokemonVivo();
    }

    public boolean aggiungiPokemon(Pokemon pokemon) {
        return team.aggiungiPokemon(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("***** ALLENATORE: %s *****\n", nome.toUpperCase()));
        if (team.isVuoto()) {
            sb.append("Nessun Pokémon nel team\n");
        } else {
            sb.append(team.toString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Allenatore that = (Allenatore) o;
        return Objects.equals(nome, that.nome) && Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, team);
    }
}