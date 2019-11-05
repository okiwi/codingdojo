import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Panier {

    public double total() {
        Map<String, List<Bouquin>> bouquinsGroupés = bouquins
                .stream()
                .collect(Collectors.groupingBy(Bouquin::titre));

        

        return REGLES.get(bouquinsGroupés.size()).apply((double) (size() * PRIX_UNITAIRE));
    }

    private int size() {
        return bouquins.size();
    }

    public void ajoute(Bouquin bouquin) {
        bouquins.add(bouquin);
    }

    private List<Bouquin> bouquins = new ArrayList<>();
    private static final Map<Integer, Function<Double, Double>> REGLES = new HashMap<>();

    static {
        REGLES.put(0, (p) -> (double) 0);
        REGLES.put(1, (p) -> Double.valueOf(p));
        REGLES.put(2, (p) -> p * 0.95);
        REGLES.put(3, (p) -> p * 0.90);
        REGLES.put(4, (p) -> p * 0.80);
        REGLES.put(5, (p) -> p * 0.75);
    }

    private static final int PRIX_UNITAIRE = 8;
}
