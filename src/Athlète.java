public class Athlète {
    private String nom;
    private String prenom;
    private String sexe;
    private int force;
    private int agilite;
    private int endurance;

    public Athlète(String nom,String prenom,String sexe,int force, int agilite, int endurance){
        this.nom=nom;
        this.prenom=prenom;
        this.sexe=sexe;
        this.force=force;
        this.agilite=agilite;
        this.endurance=endurance;
    }

    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public String getSexe(){
        return this.sexe;
    }
    public int getForce(){
        return this.force;
    }
    public int getAgilite(){
        return this.agilite;
    }
    public int getEndurance(){
        return this.endurance;
    }
    public void setNom(String n1){
        this.nom=n1;
    }
    public void setPrenom(String p1){
        this.prenom=p1;
    }
    public void setSexe(String s1){
        this.sexe=s1;
    }
    public void setForce(int f1){
        this.force=f1;
    }
    public void setAgilite(int a1){
        this.agilite=a1;
    }
    public void setEndurance(int e1){
        this.endurance=e1;
    }

    @Override

    public String toString(){
        return ("Nom de l'Athlete : " +this.getNom()+"Prenom de l'Athlete : "+this.getPrenom()+ "Sexe de l'Athlete : "+this.getSexe()+
        "Force de l'Athlete : "+this.getForce()+ "Agilite de l'Athlete : "+this.getAgilite()+"Endurance de l'Athlete : "+this.getEndurance());

    }
}
