package main.java.com.cdal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataManager {
    public final Set<Pays> pays;
    public final Set<Athlete> athletes;
    public final Set<Equipe> equipes;
    public final Set<Epreuve> epreuves;
    public final Set<Sport> sports;
    

    public DataManager() {
        pays = new HashSet<Pays>();
        athletes = new HashSet<Athlete>();
        equipes = new HashSet<Equipe>();
        epreuves = new HashSet<Epreuve>();
        sports = new HashSet<Sport>();
    }

    public Set<Pays> getPays() {
        return pays;
    }

    public Set<Athlete> getAthletes() {
        return athletes;
    }

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public Set<Epreuve> getEpreuves() {
        return epreuves;
    }

    public Set<Sport> getSports() {
        return sports;
    }


    public Pays addPays(Pays pays) {
        this.pays.add(pays);
        return pays;
    }

    public Athlete addAthlete(Athlete athlete) {
        this.athletes.add(athlete);
        return athlete;
    }

    public Equipe addEquipe(Equipe equipe) {
        this.equipes.add(equipe);
        return equipe;
    }

    public Sport addSport(Sport sport) {
        this.sports.add(sport);
        return sport;
    }

   

    public Epreuve createEpreuve(String nom, List<Athlete> athletes, Sport sport){
        String genre = athletes.get(0).obtenirSexe();
        Epreuve e = new Epreuve(nom, genre, sport);
        for(Athlete a : athletes){e.ajouteParticipantEpreuve(a);;}
        epreuves.add(e);
        return e;
    }

    public Epreuve createEpreuve(List<Athlete> athletes, Sport sport){
        return createEpreuve(sport.getNom(), athletes, sport);
    }

    public Epreuve createEpreuve(Athlete athlete, Sport sport){
        return createEpreuve(Arrays.asList(athlete), sport);
    }

    public void removePays(Pays pays) {
        this.pays.remove(pays);
    }

    public void removeAthlete(Athlete athlete) {
        this.athletes.remove(athlete);
    }

    public void removeEquipe(Equipe equipe) {
        this.equipes.remove(equipe);
    }

    public void removeSport(Sport sport) {
        this.sports.remove(sport);
    }

    

    public Pays getPays(String nom) {
        for (Pays pays : this.pays) {
            if (pays.getNom().equals(nom)) {
                return pays;
            }
        }
        return null;
    }

    public Athlete getAthlete(String nom, String prenom, String pays){
        List<Athlete> athletepays = new ArrayList<>();
        for(Pays p: this.pays){
            if(p.getNom().equals(pays)){
                athletepays = p.getAthletes();
                for(Athlete a:athletepays){
                    if(a.getPrenom().equals(prenom) && a.obtenirNom().equals(nom)){
                        return a;
                    }
                }
            }

        }
        return null;
    }

    public Athlete getAthlete(String nom, String prenom, Pays pays){
        return this.getAthlete(nom, prenom, pays.getNom());
    }
    public Sport getSport(String sport){
        for(Sport s : sports){
            if(s.getNom().equals(sport)){
                return s;
            }
        }
        return null;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if(!(obj instanceof DataManager)) return false;
        DataManager other = (DataManager) obj;
        return this.pays.equals(other.pays) 
        && this.athletes.equals(other.athletes) 
        && this.equipes.equals(other.equipes) 
        && this.epreuves.equals(other.epreuves) 
        && this.sports.equals(other.sports) 
        ;
    }
}
