import org.junit.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PanierTest {

    private Panier panier;

    @Before
    public void avant_chaque() throws Exception {
        panier = new Panier();
    }

    @Test
    public void un_panier_vide_coûte_0_euro() {
        double total = panier.total();

        assertThat(total).isEqualTo(0);
    }

    @Test
    public void un_panier_avec_un_seul_livre_coûte_8_euros() {
        panier.ajoute(new Bouquin("le premier"));

        double total = panier.total();

        assertThat(total).isEqualTo(8);
    }

    @Test
    public void un_panier_avec_deux_bouquins_identiques_coûtent_16_euros() throws Exception {
        panier.ajoute(new Bouquin("le premier"));
        panier.ajoute(new Bouquin("le premier"));

        double total = panier.total();

        assertThat(total).isEqualTo(16);
    }

    @Test
    public void un_panier_avec_deux_bouquins_différents_coûtent_16_moins_5_pourcents () throws Exception {
        panier.ajoute(new Bouquin("le premier"));
        panier.ajoute(new Bouquin("le deuxième"));

        double total = panier.total();

        assertThat(total).isEqualTo(15.20);
    }


    @Test
    public void un_panier_avec_trois_bouquins_différents_coûtent_24_moins_10_pourcents ()  {
        panier.ajoute(new Bouquin("le premier"));
        panier.ajoute(new Bouquin("le deuxième"));
        panier.ajoute(new Bouquin("le troisième"));

        double total = panier.total();

        assertThat(total).isEqualTo(21.60);
    }

    @Test
    public void un_panier_avec_quatre_bouquins_différents_coûtent_32_moins_20_pourcents()  {
        panier.ajoute(new Bouquin("le premier"));
        panier.ajoute(new Bouquin("le deuxième"));
        panier.ajoute(new Bouquin("le troisième"));
        panier.ajoute(new Bouquin("le quatrième"));

        double total = panier.total();

        assertThat(total).isEqualTo(25.60);
    }

    @Test
    public void un_panier_avec_cinq_bouquins_différents_coûtent_40_moins_25_pourcents()  {
        panier.ajoute(new Bouquin("le premier"));
        panier.ajoute(new Bouquin("le deuxième"));
        panier.ajoute(new Bouquin("le troisième"));
        panier.ajoute(new Bouquin("le quatrième"));
        panier.ajoute(new Bouquin("la mort d'Harry"));

        double total = panier.total();

        assertThat(total).isEqualTo(30);
    }

    @Test
    public void un_panier_avec_trois_bouquins_dont_deux_identiques_coûtent_23_20()  {
        panier.ajoute(new Bouquin("le deuxième"));
        panier.ajoute(new Bouquin("le deuxième"));
        panier.ajoute(new Bouquin("la mort d'Harry"));

        double total = panier.total();

        assertThat(total).isEqualTo(23.20);
    }

}
