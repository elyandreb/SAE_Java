package test.java.com.cdal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import main.java.com.cdal.Epreuve;
import main.java.com.cdal.Sport;
import main.java.com.cdal.Volleyball;
import main.java.com.cdal.Handball;
import main.java.com.cdal.Natation;
import main.java.com.cdal.Participant;
import main.java.com.cdal.Athlete;

public class EpreuveTest {

    @Test
    public void testCreationEpreuveValide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        assertEquals("Natation : 100m brasse femmes", epreuve.getNom());
        assertEquals("F", epreuve.getGenre());
        assertEquals(natation, epreuve.getSport());
        assertEquals(new ArrayList<Participant>(), epreuve.getParticipants());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationEpreuveNomInvalide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        new Epreuve(null, "F", natation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationEpreuveGenreInvalide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        new Epreuve("Natation : 100m brasse femmes", "X", natation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationEpreuveSportInvalide() {
        new Epreuve("Natation : 100m brasse femmes", "F", null);
    }

    @Test
    public void testSetNomValide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        epreuve.setNom("Natation : 100m brasse hommes");
        assertEquals("Natation : 100m brasse hommes", epreuve.getNom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomInvalide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        epreuve.setNom("");
    }

    @Test
    public void testSetGenreValide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        epreuve.setGenre("M");
        assertEquals("M", epreuve.getGenre());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetGenreInvalide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        epreuve.setGenre("X");
    }

    @Test
    public void testAjouteParticipantEpreuveValide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        Participant participant = new Athlete("Doe", "John", "Homme", 80, 70, 90);
        epreuve.ajouteParticipantEpreuve(participant);
        List<Participant> listeParticipants = new ArrayList<>();
        listeParticipants.add(participant);
        assertEquals(listeParticipants, epreuve.getParticipants());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouteParticipantEpreuveInvalide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        Participant participant = new Athlete("Doe", "John", "Homme", 80, 70, 90);
        epreuve.ajouteParticipantEpreuve(participant);
        epreuve.ajouteParticipantEpreuve(participant); 
    }

    @Test
    public void testSupprimeParticipantEpreuveValide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        Participant participant = new Athlete("Doe", "John", "Homme", 80, 70, 90);
        epreuve.ajouteParticipantEpreuve(participant);
        epreuve.supprimeParticipantEpreuve(participant);
        assertEquals(new ArrayList<Participant>(), epreuve.getParticipants());
    }

    @Test(expected = NoSuchElementException.class)
    public void testSupprimeParticipantEpreuveInvalide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        Participant participant = new Athlete("Doe", "John", "Homme", 80, 70, 90);
        epreuve.supprimeParticipantEpreuve(participant); 
    }

    @Test
    public void testRechercheParticipantEpreuveValide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        Participant participant = new Athlete("Doe", "John", "Homme", 80, 70, 90);
        epreuve.ajouteParticipantEpreuve(participant);
        assertEquals(participant, epreuve.rechercheParticipantEpreuve(participant));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRechercheParticipantEpreuveInvalide() {
        Sport natation = new Natation("Natation", "Individuel", 1);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", natation);
        Participant participant = new Athlete("Doe", "John", "Homme", 80, 70, 90);
        epreuve.rechercheParticipantEpreuve(participant); 
    }

    @Test
    public void testTriGenreEpreuveHomme() {
        Sport volleyball = new Volleyball("Volley-ball", "Collectif", 6);
        Sport handball = new Handball("Handball", "Collectif", 7);

        Epreuve epreuveFemme = new Epreuve("Volley-ball : femmes", "F", volleyball);
        Epreuve epreuveHomme = new Epreuve("Handball : hommes", "M", handball);

        List<Epreuve> epreuves = new ArrayList<>();
        epreuves.add(epreuveFemme);
        epreuves.add(epreuveHomme);

        Epreuve.triGenreEpreuveHomme(epreuves);

        assertEquals(epreuveHomme, epreuves.get(0));
        assertEquals(epreuveFemme, epreuves.get(1));
    }

    @Test
    public void testTriGenreEpreuveFemme() {
        Sport volleyball = new Volleyball("Volley-ball", "Collectif", 6);
        Sport handball = new Handball("Handball", "Collectif", 7);

        Epreuve epreuveFemme = new Epreuve("Handball : femmes", "F", handball);
        Epreuve epreuveHomme = new Epreuve("Volley-ball : hommes", "M", volleyball);

        List<Epreuve> epreuves = new ArrayList<>();
        epreuves.add(epreuveHomme);
        epreuves.add(epreuveFemme);

        Epreuve.triGenreEpreuveFemme(epreuves);

        assertEquals(epreuveFemme, epreuves.get(0));
        assertEquals(epreuveHomme, epreuves.get(1));
    }

    @Test
    public void testTriNomEpreuve() {
        Sport volleyball = new Volleyball("Volley-ball", "Collectif", 6);
        Sport handball = new Handball("Handball", "Collectif", 7);

        Epreuve epreuve1 = new Epreuve("Volley-ball : femmes", "F", volleyball);
        Epreuve epreuve2 = new Epreuve("Handball : hommes", "M", handball);

        List<Epreuve> epreuves = new ArrayList<>();
        epreuves.add(epreuve2);
        epreuves.add(epreuve1);

        Epreuve.triNomEpreuve(epreuves);

        assertEquals("Handball : hommes", epreuves.get(0).getNom());
        assertEquals("Volley-ball : femmes", epreuves.get(1).getNom());
    }

    @Test
    public void testToString() {
        Sport volleyball = new Volleyball("Volley-ball", "Collectif", 6);
        Epreuve epreuve = new Epreuve("Volley-ball : femmes", "F", volleyball);
        assertEquals("Nom : Volley-ball : femmes, Genre : F, Sport : Nom du sport : Volley-ball, Catégorie du sport : Collectif, Nombre de joueurs : 6, Participants : []", epreuve.toString());
    }

    @Test
    public void testEquals() {
        Sport volleyball1 = new Volleyball("Volley-ball", "Collectif", 6);
        Sport volleyball2 = new Volleyball("Volley-ball", "Collectif", 6);
        Sport handball = new Handball("Handball", "Collectif", 7);

        Epreuve epreuve1 = new Epreuve("Volley-ball : femmes", "F", volleyball1);
        Epreuve epreuve2 = new Epreuve("Volley-ball : femmes", "F", volleyball2);
        Epreuve epreuve3 = new Epreuve("Handball : hommes", "M", handball);

        assertEquals(true, epreuve1.equals(epreuve2));
        assertEquals(false, epreuve1.equals(epreuve3));
    }

}