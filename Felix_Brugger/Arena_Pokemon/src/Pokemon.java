import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe che definisce gli attributi dei Pokémon
 *
 * @author Felix Brugger
 * @version Giugno 2026
 */
public class Pokemon {
    private String nome;
    private String tipo;
    private int hp;
    private int hpMax;
    private int attacco;
    private int difesa;
    private int velocita;
    private List<Mossa> mosse;

    public Pokemon(String nome, String tipo, int hp, int attacco, int difesa, int velocita, List<Mossa> mosse) {
        this.nome = nome;
        this.tipo = tipo;
        this.hp = hp;
        this.hpMax = hp;
        this.attacco = attacco;
        this.difesa = difesa;
        this.velocita = velocita;
        if(mosse !=null) {
            this.mosse = new ArrayList<>(mosse);
        }
        else{
            this.mosse = new ArrayList<>();
        }
    }

    public Pokemon(Pokemon altro) {
        this.nome = altro.nome;
        this.tipo = altro.tipo;
        this.hp = altro.hpMax;
        this.hpMax = altro.hpMax;
        this.attacco = altro.attacco;
        this.difesa = altro.difesa;
        this.velocita = altro.velocita;
        this.mosse = new ArrayList<>(altro.mosse);
    }

    // Getters
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }

    public int getHp() {
        return hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getAttacco() {
        return attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    public int getVelocita() {
        return velocita;
    }

    public List<Mossa> getMosse() {
        return new ArrayList<>(mosse);
     }

    public boolean isVivo() {
        return hp > 0;
    }

    public void subisciDanno(int danno) {
        hp = Math.max(0, hp - danno);
    }

    @Override
    public String toString() { //ho chiesto su google cosa era
        return String.format("%s (%s) - HP: %d/%d | ATK: %d | DEF: %d | VEL: %d", nome, tipo, hp, hpMax, attacco, difesa, velocita);
        //.format viene utilizzato per formattare una stringa con all'interno i dati nella posizione e con la struttura che vogliamo, tipo %d è per un int e verrà sostituito da un dato dopo le virgole.
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return hp == pokemon.hp && hpMax == pokemon.hpMax && attacco == pokemon.attacco && difesa == pokemon.difesa && velocita == pokemon.velocita && Objects.equals(nome, pokemon.nome) && Objects.equals(tipo, pokemon.tipo) && Objects.equals(mosse, pokemon.mosse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo, hp, hpMax, attacco, difesa, velocita, mosse);
    }
}