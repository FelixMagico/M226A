import java.util.Objects;

/**
 * Classe con le varie mosse di ogni Pokémon
 *
 * @author Felix Brugger
 * @version Giugno 2026
 */
public class Mossa {
    private String nome;
    private String tipo;
    private int potenza;

    public Mossa(String nome, String tipo, int potenza) {
        this.nome = nome;
        this.tipo = tipo;
        this.potenza = potenza;
    }

    public String getNome() {
        return nome;
    }

    public int getPotenza() {
        return potenza;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Potenza: %d", nome, tipo, potenza);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mossa mossa = (Mossa) o;
        return potenza == mossa.potenza && Objects.equals(nome, mossa.nome) && Objects.equals(tipo, mossa.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo, potenza);
    }
}