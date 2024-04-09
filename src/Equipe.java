import java.util.ArrayList;
import java.util.List;

public class Equipe implements Participant{
    private String nom;
    private List<Athlète> listAthlètes;

    public Equipe(String nom, List<Athlète> listAthlètes){
        this.nom = nom;
        this.listAthlètes = new ArrayList<>();
    }

    public String getNom(){
        return this.nom;
    }

    public List<Athlète> getMembres(){
        return this.listAthlètes;
    }

    @Override
    public void participer(Epreuve epreuve){
        
    }

    @Override
    public String toString(){
        return ("nom de l'équipe : " + this.getNom() + "; liste des athlètes de l'équipe : " + this.getMembres());
    }

}

