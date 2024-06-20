package main.java.com.cdal;

import java.util.ArrayList;
import java.util.List;

public class Executable {
    public static void main(String[] args) {

        JeuxOlympique iutOlympique = new JeuxOlympique("Jeux IUT'Olympiques",2024,"Orléans");
        System.out.println(iutOlympique);

        Sport natation = new Natation("Natation", "Individuel", 1);
        Sport handball = new Handball("Handball", "Collectif", 7);
        Sport volleyball = new Volleyball("Volley-ball", "Collectif", 6);
        Sport escrime = new Escrime("Escrime", "Individuel", 1);
        Sport athletisme = new Athletisme("Athlétisme", "Individuel", 1);
        System.out.println(natation);
        System.out.println(handball);
        System.out.println(volleyball);
        System.out.println(escrime);
        System.out.println(athletisme);

        Epreuve natation100mBrasseHommes = new Epreuve("100m brasse", "M", natation);
        Epreuve natation100mBrasseFemmes = new Epreuve("100m brasse", "F", natation);
        Epreuve natation4x100mNageLibreRelaisFemmes = new Epreuve("4x100m nage libre (relais femmes)", "F", natation);
        Epreuve natation4x100mNageLibreRelaisHommes = new Epreuve("4x100m nage libre (relais hommes)", "M", natation);
        System.out.println(natation100mBrasseHommes);
        System.out.println(natation100mBrasseFemmes);
        System.out.println(natation4x100mNageLibreRelaisFemmes);
        System.out.println(natation4x100mNageLibreRelaisHommes);

        Epreuve handballFemmes = new Epreuve("Handball", "F", handball);
        Epreuve handballHommes = new Epreuve("Handball", "M", handball);
        System.out.println(handballFemmes);
        System.out.println(handballHommes);

        Epreuve volleyBallFemmes = new Epreuve("Volley-ball", "F", volleyball);
        Epreuve volleyBallHommes = new Epreuve("Volley-ball", "M", volleyball);
        System.out.println(volleyBallFemmes);
        System.out.println(volleyBallHommes);

        Epreuve escrimeFleuretFemmes = new Epreuve("Fleuret", "F", escrime);
        Epreuve escrimeFleuretHommes = new Epreuve("Fleuret", "M", escrime);
        Epreuve escrimeEpeeFemmes = new Epreuve("Epée", "F", escrime);
        Epreuve escrimeEpeeHommes = new Epreuve("Epée", "M", escrime);
        System.out.println(escrimeFleuretFemmes);
        System.out.println(escrimeFleuretHommes);
        System.out.println(escrimeEpeeFemmes);
        System.out.println(escrimeEpeeHommes);

        Epreuve athletisme110mHaiesFemmes = new Epreuve("110m haies", "F", athletisme);
        Epreuve athletisme110mHaiesHommes = new Epreuve("110m haies", "M", athletisme);
        Epreuve athletisme4x100mRelaisFemmes = new Epreuve("4x100m relais", "F", athletisme);
        Epreuve athletisme4x100mRelaisHommes = new Epreuve("4x100m relais", "M", athletisme);
        System.out.println(athletisme110mHaiesFemmes);
        System.out.println(athletisme110mHaiesHommes);
        System.out.println(athletisme4x100mRelaisFemmes);
        System.out.println(athletisme4x100mRelaisHommes);

        Pays france = new Pays("France", 10, 5, 3);
        Pays japon = new Pays("Japon", 8, 6, 4);
        Pays coree = new Pays("Corée", 7, 4, 5);
        Pays allemagne = new Pays("Allemagne", 9, 7, 6);
        Pays maroc = new Pays("Maroc", 3, 2, 1);
        System.out.println(france);
        System.out.println(japon);
        System.out.println(coree);
        System.out.println(allemagne);
        System.out.println(maroc);

        Athlete athlete1 = new Athlete("Usain", "Bolt", "H", 90, 85, 80);
        Athlete athlete2 = new Athlete("Simone", "Biles", "F", 85, 90, 85);
        Athlete athlete3 = new Athlete("Michael", "Phelps", "H", 88, 86, 82);
        Athlete athlete4 = new Athlete("Serena", "Williams", "F", 87, 88, 84);
        Athlete athlete5 = new Athlete("Kobe", "Bryant", "H", 89, 87, 83);
        Athlete athlete6 = new Athlete("Serena", "Williams", "F", 86, 89, 81);
        Athlete athlete7 = new Athlete("LeBron", "James", "H", 87, 88, 80);
        Athlete athlete8 = new Athlete("Rafael", "Nadal", "H", 88, 87, 81);
        Athlete athlete9 = new Athlete("Simone", "Biles", "F", 89, 86, 79);
        Athlete athlete10 = new Athlete("Cristiano", "Ronaldo", "H", 90, 85, 82);
        System.out.println(athlete1);
        System.out.println(athlete2);
        System.out.println(athlete3);
        System.out.println(athlete4);
        System.out.println(athlete5);
        System.out.println(athlete6);
        System.out.println(athlete7);
        System.out.println(athlete8);
        System.out.println(athlete9);
        System.out.println(athlete10);

        Equipe equipe1 = new Equipe("Équipe 1");
        Equipe equipe2 = new Equipe("Équipe 2");
        Equipe equipe3 = new Equipe("Équipe 3");
        Equipe equipe4 = new Equipe("Équipe 4");
        Equipe equipe5 = new Equipe("Équipe 5");
        System.out.println(equipe1);
        System.out.println(equipe2);
        System.out.println(equipe3);
        System.out.println(equipe4);
        System.out.println(equipe5);

        iutOlympique.ajoutePays(france);
        iutOlympique.ajoutePays(japon);
        iutOlympique.ajoutePays(coree);
        iutOlympique.ajoutePays(allemagne);
        iutOlympique.ajoutePays(maroc);
        System.out.println(iutOlympique.getPays());
        iutOlympique.supprimePays(maroc);
        System.out.println(iutOlympique.getPays());
        System.out.println(iutOlympique.recherchePays(france));
        System.out.println(iutOlympique.nbPays());

        iutOlympique.ajouteEpreuve(natation100mBrasseFemmes);
        iutOlympique.ajouteEpreuve(natation100mBrasseHommes);
        iutOlympique.ajouteEpreuve(natation4x100mNageLibreRelaisFemmes);
        iutOlympique.ajouteEpreuve(natation4x100mNageLibreRelaisHommes);
        iutOlympique.ajouteEpreuve(handballFemmes);
        iutOlympique.ajouteEpreuve(handballHommes);
        iutOlympique.ajouteEpreuve(volleyBallFemmes);
        iutOlympique.ajouteEpreuve(volleyBallHommes);
        iutOlympique.ajouteEpreuve(escrimeFleuretFemmes);
        iutOlympique.ajouteEpreuve(escrimeFleuretHommes);
        iutOlympique.ajouteEpreuve(escrimeEpeeFemmes);
        iutOlympique.ajouteEpreuve(escrimeEpeeHommes);
        iutOlympique.ajouteEpreuve(athletisme110mHaiesFemmes);
        iutOlympique.ajouteEpreuve(athletisme110mHaiesHommes);
        iutOlympique.ajouteEpreuve(athletisme4x100mRelaisFemmes);
        iutOlympique.ajouteEpreuve(athletisme4x100mRelaisHommes);
        System.out.println(iutOlympique.getEpreuves());
        iutOlympique.supprimeEpreuve(escrimeFleuretFemmes);
        iutOlympique.supprimeEpreuve(escrimeFleuretHommes);
        System.out.println(iutOlympique.getEpreuves());
        System.out.println(iutOlympique.rechercheEpreuve(natation100mBrasseFemmes));
        System.out.println(iutOlympique.nbEpreuves());

        iutOlympique.ajouteParticipant(athlete1);
        iutOlympique.ajouteParticipant(athlete2);
        iutOlympique.ajouteParticipant(athlete3);
        iutOlympique.ajouteParticipant(athlete4);
        iutOlympique.ajouteParticipant(athlete5);
        iutOlympique.ajouteParticipant(athlete6);
        iutOlympique.ajouteParticipant(athlete7);
        iutOlympique.ajouteParticipant(athlete8);
        iutOlympique.ajouteParticipant(athlete9);
        iutOlympique.ajouteParticipant(athlete10);
        iutOlympique.ajouteParticipant(equipe1);
        iutOlympique.ajouteParticipant(equipe2);
        iutOlympique.ajouteParticipant(equipe3);
        iutOlympique.ajouteParticipant(equipe4);
        iutOlympique.ajouteParticipant(equipe5);
        System.out.println(iutOlympique.getParticipants());
        iutOlympique.supprimeParticipant(athlete10);
        iutOlympique.supprimeParticipant(equipe5);
        System.out.println(iutOlympique.getParticipants());
        System.out.println(iutOlympique.rechercheParticipant(athlete1));
        System.out.println(iutOlympique.nbParticipants());

        handballHommes.ajouteParticipantEpreuve(equipe1);
        handballHommes.ajouteParticipantEpreuve(equipe2);
        handballHommes.ajouteParticipantEpreuve(equipe3);
        System.out.println(handballHommes.getParticipants());
        handballHommes.supprimeParticipantEpreuve(equipe3);
        System.out.println(handballHommes.getParticipants());
        System.out.println(handballHommes.getParticipants());

        equipe1.ajouteAthlete(athlete1);
        equipe1.ajouteAthlete(athlete2);
        equipe1.ajouteAthlete(athlete3);
        equipe1.ajouteAthlete(athlete4);
        System.out.println(equipe1.getAthletes());
        equipe1.supprimeAthlete(athlete4);
        System.out.println(equipe1.getAthletes());
        System.out.println(equipe1.rechercheAthlete(athlete1));
        System.out.println(equipe1.nbAthletes());

        System.out.println(athlete1.perfAthlete());
        System.out.println(athlete2.perfAthlete());
        System.out.println(athlete3.perfAthlete());

        List<Athlete> listAthlete = new ArrayList<>();
        listAthlete.add(athlete1);
        listAthlete.add(athlete2);
        listAthlete.add(athlete3);
        listAthlete.add(athlete4);
        listAthlete.add(athlete5);
        System.out.println(listAthlete);
        Athlete.triNomAthlete(listAthlete);
        System.out.println(listAthlete);
        Athlete.triSexeHomme(listAthlete);
        System.out.println(listAthlete);
        Athlete.triSexeFemme(listAthlete);
        System.out.println(listAthlete);
        Athlete.triForceCroissant(listAthlete);
        System.out.println(listAthlete);
        Athlete.triForceDecroissant(listAthlete);
        System.out.println(listAthlete);
        Athlete.triEnduranceCroissant(listAthlete);
        System.out.println(listAthlete);
        Athlete.triEnduranceDecroissant(listAthlete);
        System.out.println(listAthlete);
        Athlete.triAgiliteCroissant(listAthlete);
        System.out.println(listAthlete);
        Athlete.triAgiliteDecroissant(listAthlete);
        System.out.println(listAthlete);
        Athlete.triPerfCroissant(listAthlete);
        System.out.println(listAthlete);
        Athlete.triPerfDecroissant(listAthlete);

        france.ajouteEquipe(equipe1);
        france.ajouteEquipe(equipe2);
        france.ajouteEquipe(equipe3);
        System.out.println(france);
        france.supprimeEquipe(equipe3);
        System.out.println(france);
        System.out.println(france.rechercheEquipe(equipe1));

        france.ajouteAthlete(athlete1);
        france.ajouteAthlete(athlete2);
        france.ajouteAthlete(athlete3);
        System.out.println(france);
        france.supprimeAthlete(athlete3);
        System.out.println(france);
        System.out.println(france.rechercheAthlete(athlete1));

        System.out.println(france.nbAthletes());
        System.out.println(france.nbEquipes());
        System.out.println(france.nbMedaillesTotal());

        List<Pays> listPays = new ArrayList<>();
        listPays.add(france);
        listPays.add(japon);
        listPays.add(coree);
        listPays.add(allemagne);
        listPays.add(maroc);
        System.out.println(listPays);
        Pays.triNomPays(listPays);
        System.out.println(listPays);
        Pays.triMedaillesBronzeCroissant(listPays);
        System.out.println(listPays);
        Pays.triMedaillesBronzeDecroissant(listPays);
        System.out.println(listPays);
        Pays.triMedaillesArgentCroissant(listPays);
        System.out.println(listPays);
        Pays.triMedaillesArgentDecroissant(listPays);
        System.out.println(listPays);
        Pays.triMedaillesOrCroissant(listPays);
        System.out.println(listPays);
        Pays.triMedaillesOrDecroissant(listPays);
        System.out.println(listPays);
        Pays.triMedaillesTotalCroissant(listPays);
        System.out.println(listPays);
        Pays.triMedaillesTotalDecroissant(listPays);
        System.out.println(listPays);

   }

}
