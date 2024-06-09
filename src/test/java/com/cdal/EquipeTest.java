package test.java.com.cdal;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Test;
import main.java.com.cdal.Athlete;
import main.java.com.cdal.Epreuve;
import main.java.com.cdal.Equipe;
import main.java.com.cdal.Natation;

public class EquipeTest {

    @Test
    public void testCreationEquipeValide() {
        Equipe equipe = new Equipe("Équipe 1");
        assertEquals("Équipe 1", equipe.obtenirNom());
        assertEquals(new ArrayList<Athlete>(), equipe.getAthletes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationEquipeNomInvalide() {
        new Equipe(null);
    }

    @Test
    public void testObtenirSexeEquipeValide() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete1 = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        Athlete athlete2 = new Athlete("Marie", "Dupont", "Femme", 8, 10, 6);
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);
        assertEquals("F", equipe.obtenirSexe());
    }

    @Test(expected = NoSuchElementException.class)
    public void testObtenirSexeEquipeInvalide() {
        Equipe equipe = new Equipe("Équipe 1");
        equipe.obtenirSexe();
    }

    @Test
    public void testSetNomValide() {
        Equipe equipe = new Equipe("Équipe 1");
        equipe.setNom("Nouvelle Équipe");
        assertEquals("Nouvelle Équipe", equipe.obtenirNom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomInvalide() {
        Equipe equipe = new Equipe("Équipe 1");
        equipe.setNom(null);
    }

    @Test
    public void testNbAthletes() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete1 = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        Athlete athlete2 = new Athlete("Marie", "Dupont", "Femme", 8, 10, 6);
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);
        assertEquals(2, equipe.nbAthletes());
    }

    @Test
    public void testParticiperEquipe() {
        Equipe equipe = new Equipe("Équipe 1");
        equipe.participer(new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1)));
    }

    @Test
    public void testResultatEquipe() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete1 = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        Athlete athlete2 = new Athlete("Marie", "Dupont", "Femme", 8, 10, 6);
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);
        
        double resultat = (athlete1.getForce() + athlete1.getAgilite() + athlete1.getEndurance() +
                           athlete2.getForce() + athlete2.getAgilite() + athlete2.getEndurance()) / 6.0;
        assertEquals(resultat, equipe.resultat(new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1))), 0.001);
    }

    @Test
    public void testAjouteAthleteEquipeValide() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        equipe.ajouteAthlete(athlete);
        assertEquals(true, equipe.getAthletes().contains(athlete));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouteAthleteEquipeInvalide() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        equipe.ajouteAthlete(athlete);
        equipe.ajouteAthlete(athlete);
    }

    @Test
    public void testSupprimeAthleteEquipeValide() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        equipe.ajouteAthlete(athlete);
        equipe.supprimeAthlete(athlete);
        assertEquals(false, equipe.getAthletes().contains(athlete));
    }

    @Test
    public void testSupprimeAthleteEquipeInvalide() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        assertEquals(false, equipe.getAthletes().contains(athlete));
    }

    @Test
    public void testRechercheAthleteValide() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        equipe.ajouteAthlete(athlete);
        assertEquals(athlete, equipe.rechercheAthlete(athlete));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRechercheAthleteInvalide() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        equipe.rechercheAthlete(athlete);
    }

    @Test
    public void testTriNomEquipe() {
        Equipe equipe1 = new Equipe("Equipe 1");
        Equipe equipe2 = new Equipe("Equipe 2");
        Equipe equipe3 = new Equipe("Equipe 3");

        List<Equipe> listeEquipe = new ArrayList<>();

        listeEquipe.add(equipe1);
        listeEquipe.add(equipe2);
        listeEquipe.add(equipe3);

        equipe1.triNomEquipe(listeEquipe);

        assertEquals(equipe1, listeEquipe.get(0));
        assertEquals(equipe2, listeEquipe.get(1));
        assertEquals(equipe3, listeEquipe.get(2));
    }

    @Test
    public void testToString() {
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete1 = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        Athlete athlete2 = new Athlete("Marie", "Durand", "Femme", 8, 10, 6);

        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);

        assertEquals("Nom de l'équipe : Équipe 1, Athlètes de l'équipe : [" + athlete1.toString() + ", " + athlete2.toString() + "]", equipe.toString());
    }

    @Test
    public void testEquals() {
        Equipe equipe1 = new Equipe("Equipe 1");
        Equipe equipe2 = new Equipe("Equipe 1");

        assertEquals(true, equipe1.equals(equipe2));
    }

}
