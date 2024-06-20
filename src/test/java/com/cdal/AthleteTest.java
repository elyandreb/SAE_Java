package test.java.com.cdal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import main.java.com.cdal.Athlete;
import main.java.com.cdal.Epreuve;
import main.java.com.cdal.Natation;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AthleteTest {

    @Test
    public void testConstructeurValides() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        assertEquals("Doe", athlete.obtenirNom());
        assertEquals("John", athlete.getPrenom());
        assertEquals("H", athlete.obtenirSexe());
        assertEquals(80, athlete.getForce());
        assertEquals(70, athlete.getAgilite());
        assertEquals(90, athlete.getEndurance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNomInvalide() {
        new Athlete("", "John", "H", 80, 70, 90);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrenomInvalide() {
        new Athlete("Doe", "", "H", 80, 70, 90);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSexeInvalide() {
        new Athlete("Doe", "John", "Aucun", 80, 70, 90);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForceInvalide() {
        new Athlete("Doe", "John", "H", -10, 70, 90);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgiliteInvalide() {
        new Athlete("Doe", "John", "H", 80, -10, 90);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnduranceInvalide() {
        new Athlete("Doe", "John", "H", 80, 70, -10);
    }

    @Test
    public void testSetNomValide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setNom("Smith");
        assertEquals("Smith", athlete.obtenirNom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomInvalide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setNom("");
    }

    @Test
    public void testSetPrenomValide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setPrenom("Alice");
        assertEquals("Alice", athlete.getPrenom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPrenomInvalide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setPrenom(null);
    }

    @Test
    public void testSetSexeValide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setSexe("F");
        assertEquals("F", athlete.obtenirSexe());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetSexeInvalide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setSexe("Aucun");
    }

    @Test
    public void testSetForceValide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setForce(85);
        assertEquals(85, athlete.getForce());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetForceInvalide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setForce(-10);
    }

    @Test
    public void testSetAgiliteValide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setAgilite(75);
        assertEquals(75, athlete.getAgilite());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAgiliteInvalide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setAgilite(-10);
    }

    @Test
    public void testSetEnduranceValide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setEndurance(95);
        assertEquals(95, athlete.getEndurance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetEnduranceInvalide() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        athlete.setEndurance(-10);
    }

    @Test
    public void testPerfAthlete() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        assertEquals(80.0, athlete.perfAthlete(), 0.01);
    }

    @Test
    public void testParticiper() {
        Athlete athlete = new Athlete("Jean", "Dupond", "H", 10, 12, 5);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1));
        athlete.participer(epreuve);
    }

    @Test
    public void testResultat() {
        Athlete athlete = new Athlete("Jean", "Dupond", "H", 10, 12, 5);
        Epreuve epreuve = new Epreuve("Natation : 100m brasse femmes", "F", new Natation("Natation", "Individuel", 1));
        double expected = (10 + 12 + 5) / 3.0; 
        assertEquals(expected, athlete.resultat(epreuve), 0.01); 
    }

    @Test
    public void testTriForceCroissant() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triForceCroissant(listeAthletes);

        assertEquals(70, listeAthletes.get(0).getForce());
        assertEquals(80, listeAthletes.get(1).getForce());
        assertEquals(90, listeAthletes.get(2).getForce());
    }

    @Test
    public void testTriForceDecroissant() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triForceDecroissant(listeAthletes);

        assertEquals(90, listeAthletes.get(0).getForce());
        assertEquals(80, listeAthletes.get(1).getForce());
        assertEquals(70, listeAthletes.get(2).getForce());
    }

    @Test
    public void testTriAgiliteCroissant() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triAgiliteCroissant(listeAthletes);

        assertEquals(60, listeAthletes.get(0).getAgilite());
        assertEquals(70, listeAthletes.get(1).getAgilite());
        assertEquals(80, listeAthletes.get(2).getAgilite());
    }

    @Test
    public void testTriAgiliteDecroissant() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triAgiliteDecroissant(listeAthletes);

        assertEquals(80, listeAthletes.get(0).getAgilite());
        assertEquals(70, listeAthletes.get(1).getAgilite());
        assertEquals(60, listeAthletes.get(2).getAgilite());
    }

    @Test
    public void testTriEnduranceCroissant() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triEnduranceCroissant(listeAthletes);

        assertEquals(80, listeAthletes.get(0).getEndurance());
        assertEquals(90, listeAthletes.get(1).getEndurance());
        assertEquals(90, listeAthletes.get(2).getEndurance());
    }

    @Test
    public void testTriEnduranceDecroissant() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triEnduranceDecroissant(listeAthletes);

        assertEquals(90, listeAthletes.get(0).getEndurance());
        assertEquals(90, listeAthletes.get(1).getEndurance());
        assertEquals(80, listeAthletes.get(2).getEndurance());
    }

    @Test
    public void testTriPerfCroissant() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triPerfCroissant(listeAthletes);

        assertEquals(76.0, listeAthletes.get(0).perfAthlete(), 0.01);
        assertEquals(80.0, listeAthletes.get(1).perfAthlete(), 0.01);
        assertEquals(80.0, listeAthletes.get(2).perfAthlete(), 0.01); 
    }

    @Test
    public void testTriPerfDecroissant() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triPerfDecroissant(listeAthletes);

        assertEquals(80.0, listeAthletes.get(0).perfAthlete(), 0.01);
        assertEquals(80.0, listeAthletes.get(1).perfAthlete(), 0.01);
        assertEquals(76.0, listeAthletes.get(2).perfAthlete(), 0.01); 
    }

    @Test
    public void testTriSexeHomme() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triSexeHomme(listeAthletes);

        assertEquals("Doe", listeAthletes.get(0).obtenirNom());
        assertEquals("Brown", listeAthletes.get(1).obtenirNom());
        assertEquals("Smith", listeAthletes.get(2).obtenirNom());
    }

    @Test
    public void testTriSexeFemme() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triSexeFemme(listeAthletes);

        assertEquals("Smith", listeAthletes.get(0).obtenirNom());
        assertEquals("Doe", listeAthletes.get(1).obtenirNom());
        assertEquals("Brown", listeAthletes.get(2).obtenirNom());
    }

    @Test
    public void testTriNomAthlete() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Smith", "Alice", "F", 70, 80, 90);
        Athlete athlete3 = new Athlete("Brown", "Michael", "H", 90, 60, 80);

        List<Athlete> listeAthletes = new ArrayList<>();
        listeAthletes.add(athlete1);
        listeAthletes.add(athlete2);
        listeAthletes.add(athlete3);

        Athlete.triNomAthlete(listeAthletes);

        assertEquals("Brown", listeAthletes.get(0).obtenirNom());
        assertEquals("Doe", listeAthletes.get(1).obtenirNom());
        assertEquals("Smith", listeAthletes.get(2).obtenirNom());
    }

    @Test
    public void testToString() {
        Athlete athlete = new Athlete("Doe", "John", "H", 80, 70, 90);
        assertEquals("Nom : Doe, Prénom : John, Sexe : H, Force : 80, Agilité : 70, Endurance : 90", athlete.toString());
    }

    @Test
    public void testEquals() {
        Athlete athlete1 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete2 = new Athlete("Doe", "John", "H", 80, 70, 90);
        Athlete athlete3 = new Athlete("Smith", "Alice", "F", 70, 80, 90);

        assertEquals(true, athlete1.equals(athlete2));
        assertEquals(false, athlete1.equals(athlete3));
    }

}
