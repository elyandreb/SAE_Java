package test.java.com.cdal;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.junit.Test;
import main.java.com.cdal.Participant;
import main.java.com.cdal.Athlete;
import main.java.com.cdal.Epreuve;
import main.java.com.cdal.Pays;
import main.java.com.cdal.JeuxOlympique;
import main.java.com.cdal.Natation;

public class JeuxOlympiqueTest {

    @Test
    public void testConstructeurValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        assertEquals("Jeux d'été", jeuxOlympique.getNom());
        assertEquals(2024, jeuxOlympique.getAnnee());
        assertEquals("Paris", jeuxOlympique.getVille());
        assertEquals(new ArrayList<>(), jeuxOlympique.getParticipants());
        assertEquals(new ArrayList<>(), jeuxOlympique.getPays());
        assertEquals(new ArrayList<>(), jeuxOlympique.getEpreuves());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurAnneeInvalide() {
        new JeuxOlympique("Jeux d'été", 2023, "Paris");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurNomInvalide() {
        new JeuxOlympique("", 2024, "Paris");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurVilleInvalide() {
        new JeuxOlympique("Jeux d'été", 2024, "");
    }

    @Test
    public void testSetNomValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        jeuxOlympique.setNom("Nouveau nom");
        assertEquals("Nouveau nom", jeuxOlympique.getNom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        jeuxOlympique.setNom("");
    }

    @Test
    public void testSetAnneeValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        jeuxOlympique.setAnnee(2028);
        assertEquals(2028, jeuxOlympique.getAnnee());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAnneeInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        jeuxOlympique.setAnnee(2023);
    }

    @Test
    public void testSetVilleValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        jeuxOlympique.setVille("Nouvelle ville");
        assertEquals("Nouvelle ville", jeuxOlympique.getVille());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVilleInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        jeuxOlympique.setVille("");
    }

    @Test
    public void testNbParticipants() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        assertEquals(0, jeuxOlympique.nbParticipants());
    }

    @Test
    public void testNbPays() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        assertEquals(0, jeuxOlympique.nbPays());
    }

    @Test
    public void testNbEpreuves() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        assertEquals(0, jeuxOlympique.nbEpreuves());
    }

    @Test
    public void testAjouteParticipantValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Participant participant = new Athlete("Jean", "Dupond", "H", 10, 12, 5);
        jeuxOlympique.ajouteParticipant(participant);
        assertEquals(1, jeuxOlympique.nbParticipants());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouteParticipantInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Participant participant = new Athlete("Jean", "Dupond", "H", 10, 12, 5);
        jeuxOlympique.ajouteParticipant(participant);
        jeuxOlympique.ajouteParticipant(participant);
    }

    @Test
    public void testAjoutePaysValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Pays pays = new Pays("France", 10, 20, 15);
        jeuxOlympique.ajoutePays(pays);
        assertEquals(1, jeuxOlympique.nbPays());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjoutePaysInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Pays pays = new Pays("France", 10, 20, 15);
        jeuxOlympique.ajoutePays(pays);
        jeuxOlympique.ajoutePays(pays);
    }

    @Test
    public void testAjouteEpreuveValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1));
        jeuxOlympique.ajouteEpreuve(epreuve);
        assertEquals(1, jeuxOlympique.nbEpreuves());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouteEpreuveInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1));
        jeuxOlympique.ajouteEpreuve(epreuve);
        jeuxOlympique.ajouteEpreuve(epreuve);
    }

    @Test
    public void testSupprimeParticipantValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Participant participant = new Athlete("Jean", "Dupond", "H", 10, 12, 5);
        jeuxOlympique.ajouteParticipant(participant);
        jeuxOlympique.supprimeParticipant(participant);
        assertEquals(0, jeuxOlympique.nbParticipants());
    }

    @Test(expected = NoSuchElementException.class)
    public void testSupprimeParticipantInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Participant participant = new Athlete("Jean", "Dupond", "H", 10, 12, 5);
        jeuxOlympique.supprimeParticipant(participant);
    }

    @Test
    public void testSupprimePaysValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Pays pays = new Pays("France", 10, 20, 15);
        jeuxOlympique.ajoutePays(pays);
        jeuxOlympique.supprimePays(pays);
        assertEquals(0, jeuxOlympique.nbPays());
    }

    @Test(expected = NoSuchElementException.class)
    public void testSupprimePaysInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Pays pays = new Pays("France", 10, 20, 15);
        jeuxOlympique.supprimePays(pays);
    }

    @Test
    public void testSupprimeEpreuveValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1));
        jeuxOlympique.ajouteEpreuve(epreuve);
        jeuxOlympique.supprimeEpreuve(epreuve);
        assertEquals(0, jeuxOlympique.nbEpreuves());
    }

    @Test(expected = NoSuchElementException.class)
    public void testSupprimeEpreuveInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1));
        jeuxOlympique.supprimeEpreuve(epreuve);
    }

    @Test
    public void testRechercheParticipantValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Participant participant = new Athlete("Jean", "Dupond", "H", 10, 12, 5);
        jeuxOlympique.ajouteParticipant(participant);
        assertEquals(participant, jeuxOlympique.rechercheParticipant(participant));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRechercheParticipantInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Participant participant = new Athlete("Jean", "Dupond", "H", 10, 12, 5);
        jeuxOlympique.rechercheParticipant(participant);
    }

    @Test
    public void testRecherchePaysValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Pays pays = new Pays("France", 10, 20, 15);
        jeuxOlympique.ajoutePays(pays);
        assertEquals(pays, jeuxOlympique.recherchePays(pays));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRecherchePaysInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Pays pays = new Pays("France", 10, 20, 15);
        jeuxOlympique.recherchePays(pays);
    }

    @Test
    public void testRechercheEpreuveValide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1));
        jeuxOlympique.ajouteEpreuve(epreuve);
        assertEquals(epreuve, jeuxOlympique.rechercheEpreuve(epreuve));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRechercheEpreuveInvalide() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1));
        jeuxOlympique.rechercheEpreuve(epreuve);
    }

    @Test
    public void testToString() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        assertEquals("Nom des Jeux Olympiques : Jeux d'été, Année des Jeux Olympiques : 2024, Ville hôte des Jeux Olympiques : Paris, Participants aux Jeux Olympiques : [], Pays représentés aux Jeux Olympiques : [], Epreuves présentes aux Jeux Olympiques : []", jeuxOlympique.toString());
    }

    @Test
    public void testEquals() {
        JeuxOlympique jeuxOlympique1 = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        JeuxOlympique jeuxOlympique2 = new JeuxOlympique("Jeux d'été", 2024, "Paris");
        
        assertEquals(jeuxOlympique1, jeuxOlympique2); 
    }

}
