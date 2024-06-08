package test.java.com.cdal;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import main.java.com.cdal.Volleyball;
import main.java.com.cdal.Natation;
import main.java.com.cdal.Handball;
import main.java.com.cdal.Escrime;
import main.java.com.cdal.Athletisme;

public class SportTest {

    @Test
    public void testCreationVolleyball() {
        Volleyball volleyball = new Volleyball("Volleyball", "Collectif", 6);
        assertEquals("Volleyball", volleyball.getNom());
        assertEquals("Collectif", volleyball.getCategorie());
        assertEquals(6, volleyball.getNbJoueur());
    }

    @Test
    public void testCreationNatation() {
        Natation natation = new Natation("Natation", "Individuel", 1);
        assertEquals("Natation", natation.getNom());
        assertEquals("Individuel", natation.getCategorie());
        assertEquals(1, natation.getNbJoueur());
    }

    @Test
    public void testCreationHandball() {
        Handball handball = new Handball("Handball", "Collectif", 7);
        assertEquals("Handball", handball.getNom());
        assertEquals("Collectif", handball.getCategorie());
        assertEquals(7, handball.getNbJoueur());
    }

    @Test
    public void testCreationEscrime() {
        Escrime escrime = new Escrime("Escrime", "Individuel", 1);
        assertEquals("Escrime", escrime.getNom());
        assertEquals("Individuel", escrime.getCategorie());
        assertEquals(1, escrime.getNbJoueur());
    }

    @Test
    public void testCreationAthletisme() {
        Athletisme athletisme = new Athletisme("Athlétisme", "Individuel", 1);
        assertEquals("Athlétisme", athletisme.getNom());
        assertEquals("Individuel", athletisme.getCategorie());
        assertEquals(1, athletisme.getNbJoueur());
    }

    @Test
    public void testSetNomValide() {
        Volleyball volleyball = new Volleyball("Volleyball", "Collectif", 6);
        volleyball.setNom("Beach Volleyball");
        assertEquals("Beach Volleyball", volleyball.getNom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomInvalideNull() {
        Volleyball volleyball = new Volleyball("Volleyball", "Collectif", 6);
        volleyball.setNom(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomInvalideVide() {
        Volleyball volleyball = new Volleyball("Volleyball", "Collectif", 6);
        volleyball.setNom("");
    }

    @Test
    public void testSetCategorieValide() {
        Handball handball = new Handball("Handball", "Collectif", 7);
        handball.setCategorie("Individuel");
        assertEquals("Individuel", handball.getCategorie());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCategorieInvalide() {
        Handball handball = new Handball("Handball", "Collectif", 7);
        handball.setCategorie("Aucune");
    }

    @Test
    public void testSetNbJoueurValide() {
        Natation natation = new Natation("Natation", "Individuel", 1);
        natation.setNbJoueur(2);
        assertEquals(2, natation.getNbJoueur());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNbJoueurInvalide() {
        Natation natation = new Natation("Natation", "Individuel", 1);
        natation.setNbJoueur(0);
    }

    @Test
    public void testToString() {
        Escrime escrime = new Escrime("Escrime", "Individuel", 1);
        assertEquals("Nom du sport : Escrime, Catégorie du sport : Individuel, Nombre de joueurs : 1", escrime.toString());
    }

    @Test
    public void testEquals() {
        Athletisme athletisme1 = new Athletisme("Athlétisme", "Individuel", 1);
        Athletisme athletisme2 = new Athletisme("Athlétisme", "Individuel", 1);
        assertEquals(true, athletisme1.equals(athletisme2));
    }

}
