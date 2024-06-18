package test.java.com.cdal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import main.java.com.cdal.Athlete;
import main.java.com.cdal.Equipe;
import main.java.com.cdal.Pays;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PaysTest {

    @Test
    public void testCreationPaysValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        assertEquals("France", pays.getNom());
        assertEquals(10, pays.getNbMedaillesOr());
        assertEquals(20, pays.getNbMedaillesArgent());
        assertEquals(30, pays.getNbMedaillesBronze());
        assertEquals(new ArrayList<Equipe>(), pays.getEquipes());
        assertEquals(new ArrayList<Athlete>(), pays.getAthletes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationPaysNomInvalide() {
        new Pays(null, 10, 20, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationPaysMedaillesOrInvalide() {
        new Pays("France", -10, 20, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationPaysMedaillesArgentInvalide() {
        new Pays("France", 10, -20, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationPaysMedaillesBronzeInvalide() {
        new Pays("France", 10, 20, -30);
    }

    @Test
    public void testSetNomValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        pays.setNom("Espagne");
        assertEquals("Espagne", pays.getNom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        pays.setNom("");
    }

    @Test
    public void testSetNbMedaillesOrValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        pays.setNbMedaillesOr(15);
        assertEquals(15, pays.getNbMedaillesOr());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNbMedaillesOrInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        pays.setNbMedaillesOr(-5);
    }

    @Test
    public void testSetNbMedaillesArgentValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        pays.setNbMedaillesArgent(25);
        assertEquals(25, pays.getNbMedaillesArgent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNbMedaillesArgentInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        pays.setNbMedaillesArgent(-10);
    }

    @Test
    public void testSetNbMedaillesBronzeValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        pays.setNbMedaillesBronze(35);
        assertEquals(35, pays.getNbMedaillesBronze());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNbMedaillesBronzeInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        pays.setNbMedaillesBronze(-15);
    }

    @Test
    public void testNbMedaillesTotal() {
        Pays pays = new Pays("France", 10, 20, 30);
        assertEquals(60, pays.nbMedaillesTotal());
    }

    @Test
    public void testNbEquipes() {
        Pays pays = new Pays("France", 10, 20, 30);
        assertEquals(0, pays.nbEquipes());
        pays.ajouteEquipe(new Equipe("Équipe 1"));
        assertEquals(1, pays.nbEquipes());
    }

    @Test
    public void testNbAthletes() {
        Pays pays = new Pays("France", 10, 20, 30);
        assertEquals(0, pays.nbAthletes());
        pays.ajouteAthlete(new Athlete("Jean", "Dupond", "Homme", 10, 12, 5));
        assertEquals(1, pays.nbAthletes());
    }

    @Test
    public void testAjouteEquipeValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Equipe equipe = new Equipe("Équipe 1");
        pays.ajouteEquipe(equipe);
        assertEquals(true, pays.getEquipes().contains(equipe));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouteEquipeInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Equipe equipe = new Equipe("Équipe 1");
        pays.ajouteEquipe(equipe);
        pays.ajouteEquipe(equipe);
    }

    @Test
    public void testAjouteAthleteValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        pays.ajouteAthlete(athlete);
        assertEquals(true, pays.getAthletes().contains(athlete));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouteAthleteInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        pays.ajouteAthlete(athlete);
        pays.ajouteAthlete(athlete);
    }

    @Test
    public void testSupprimeEquipeValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Equipe equipe = new Equipe("Équipe 1");
        pays.ajouteEquipe(equipe);
        pays.supprimeEquipe(equipe);
        assertEquals(false, pays.getEquipes().contains(equipe));
    }

    @Test(expected = NoSuchElementException.class)
    public void testSupprimeEquipeInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Equipe equipe = new Equipe("Équipe 1");
        pays.supprimeEquipe(equipe);
    }

    @Test
    public void testSupprimeAthleteValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        pays.ajouteAthlete(athlete);
        pays.supprimeAthlete(athlete);
        assertEquals(false, pays.getAthletes().contains(athlete));
    }

    @Test(expected = NoSuchElementException.class)
    public void testSupprimeAthleteInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        pays.supprimeAthlete(athlete);
    }

    @Test
    public void testRechercheEquipeValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Equipe equipe = new Equipe("Équipe 1");
        pays.ajouteEquipe(equipe);
        assertEquals(equipe, pays.rechercheEquipe(equipe));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRechercheEquipeInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Equipe equipe = new Equipe("Équipe 1");
        pays.rechercheEquipe(equipe);
    }

    @Test
    public void testRechercheAthleteValide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        pays.ajouteAthlete(athlete);
        assertEquals(athlete, pays.rechercheAthlete(athlete));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRechercheAthleteInvalide() {
        Pays pays = new Pays("France", 10, 20, 30);
        Athlete athlete = new Athlete("Jean", "Dupond", "Homme", 10, 12, 5);
        pays.rechercheAthlete(athlete);
    }

    @Test
    public void testTriMedaillesTotalDecroissant() {
        Pays pays1 = new Pays("Pays1", 10, 20, 30);
        Pays pays2 = new Pays("Pays2", 20, 30, 40);
        Pays pays3 = new Pays("Pays3", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays3);
        listePays.add(pays1);
        listePays.add(pays2);

        Pays.triMedaillesTotalDecroissant(listePays);

        assertEquals(pays3, listePays.get(0));
        assertEquals(pays2, listePays.get(1));
        assertEquals(pays1, listePays.get(2));
    }

    public void testTriMedaillesTotalCroissant() {
        Pays pays1 = new Pays("Pays1", 10, 20, 30);
        Pays pays2 = new Pays("Pays2", 20, 30, 40);
        Pays pays3 = new Pays("Pays3", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays3);
        listePays.add(pays1);
        listePays.add(pays2);

        Pays.triMedaillesTotalCroissant(listePays);

        assertEquals(pays1, listePays.get(0));
        assertEquals(pays2, listePays.get(1));
        assertEquals(pays3, listePays.get(2));
    }

    @Test
    public void testTriMedaillesOrDecroissant() {
        Pays pays1 = new Pays("Pays1", 10, 20, 30);
        Pays pays2 = new Pays("Pays2", 20, 30, 40);
        Pays pays3 = new Pays("Pays3", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays3);
        listePays.add(pays1);
        listePays.add(pays2);

        Pays.triMedaillesOrDecroissant(listePays);

        assertEquals(pays3, listePays.get(0));
        assertEquals(pays2, listePays.get(1));
        assertEquals(pays1, listePays.get(2));
    }

    @Test
    public void testTriMedaillesOrCroissant() {
        Pays pays1 = new Pays("Pays1", 10, 20, 30);
        Pays pays2 = new Pays("Pays2", 20, 30, 40);
        Pays pays3 = new Pays("Pays3", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays3);
        listePays.add(pays1);
        listePays.add(pays2);

        Pays.triMedaillesOrCroissant(listePays);

        assertEquals(pays1, listePays.get(0));
        assertEquals(pays2, listePays.get(1));
        assertEquals(pays3, listePays.get(2));
    }

    @Test
    public void testTriMedaillesArgentDecroissant() {
        Pays pays1 = new Pays("Pays1", 10, 20, 30);
        Pays pays2 = new Pays("Pays2", 20, 30, 40);
        Pays pays3 = new Pays("Pays3", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays3);
        listePays.add(pays1);
        listePays.add(pays2);

        Pays.triMedaillesArgentDecroissant(listePays);

        assertEquals(pays3, listePays.get(0));
        assertEquals(pays2, listePays.get(1));
        assertEquals(pays1, listePays.get(2));
    }

    @Test
    public void testTriMedaillesArgentCroissant() {
        Pays pays1 = new Pays("Pays1", 10, 20, 30);
        Pays pays2 = new Pays("Pays2", 20, 30, 40);
        Pays pays3 = new Pays("Pays3", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays3);
        listePays.add(pays1);
        listePays.add(pays2);

        Pays.triMedaillesArgentCroissant(listePays);

        assertEquals(pays1, listePays.get(0));
        assertEquals(pays2, listePays.get(1));
        assertEquals(pays3, listePays.get(2));
    }

    @Test
    public void testTriMedaillesBronzeDecroissant() {
        Pays pays1 = new Pays("Pays1", 10, 20, 30);
        Pays pays2 = new Pays("Pays2", 20, 30, 40);
        Pays pays3 = new Pays("Pays3", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays3);
        listePays.add(pays1);
        listePays.add(pays2);

        Pays.triMedaillesBronzeDecroissant(listePays);

        assertEquals(pays3, listePays.get(0));
        assertEquals(pays2, listePays.get(1));
        assertEquals(pays1, listePays.get(2));
    }

    @Test
    public void testTriMedaillesBronzeCroissant() {
        Pays pays1 = new Pays("Pays1", 10, 20, 30);
        Pays pays2 = new Pays("Pays2", 20, 30, 40);
        Pays pays3 = new Pays("Pays3", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays3);
        listePays.add(pays1);
        listePays.add(pays2);

        Pays.triMedaillesBronzeCroissant(listePays);

        assertEquals(pays1, listePays.get(0));
        assertEquals(pays2, listePays.get(1));
        assertEquals(pays3, listePays.get(2));
    }

    @Test
    public void testTriNomPays() {
        Pays pays1 = new Pays("France", 10, 20, 30);
        Pays pays2 = new Pays("Allemagne", 20, 30, 40);
        Pays pays3 = new Pays("Canada", 30, 40, 50);

        List<Pays> listePays = new ArrayList<>();
        listePays.add(pays2);
        listePays.add(pays3);
        listePays.add(pays1);

        Pays.triNomPays(listePays);

        assertEquals(pays2, listePays.get(0));
        assertEquals(pays3, listePays.get(1));
        assertEquals(pays1, listePays.get(2));
    }

    @Test
    public void testToString() {
        Pays pays1 = new Pays("France", 10, 20, 30);
        assertEquals("Nom du pays : France, Médailles d'or : 10, Médailles d'argent : 20, Médailles de bronze : 30, Liste des équipes : [], Liste des athlètes : []", pays1.toString());
    }

    @Test
    public void testEquals() {
        Pays pays1 = new Pays("France", 10, 20, 30);
        Pays pays2 = new Pays("Allemagne", 20, 30, 40);
        Pays pays3 = new Pays("Canada", 30, 40, 50);

        assertEquals(false, pays1.equals(pays2)); 
        assertEquals(true, pays1.equals(pays1)); 
        assertEquals(false, pays1.equals(pays3)); 
    }

}