import java.util.Objects;

public class Bouquin {
    public Bouquin(String titre) {
        this.titre = titre;
    }

    public String titre() {
        return titre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bouquin bouquin = (Bouquin) o;
        return Objects.equals(titre, bouquin.titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre);
    }

    private String titre;
}
