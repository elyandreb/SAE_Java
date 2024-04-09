public abstract class Sport {
    protected String nom;
    protected String categorie;
    protected int nbjoueur;

    public Sport(String nom,String categorie,int nbjoueur){
        this.nom = nom;
        if(bonFormatCate(categorie)==true){
        this.categorie = categorie;}
        else{System.out.println("Mauvais format de catégorie");}
        this.nbjoueur = nbjoueur;
    }

    public String getNom(){return this.nom;}

    public String getCate(){return this.categorie;}

    public int getNbJoueur(){return this.nbjoueur;}

    public boolean bonFormatCate(String categorie){
        if(!(categorie.equals("M")||!(categorie.equals("F")))){
            return false;}
        else{return true;}
    }

    public String toString(){
        String cat = " ";
        if(getCate().equals("M")){cat="masculin";}
        else{cat="féminin";}
        return this.getNom()+" est un sport "+cat+" avec"+this.getNbJoueur()+" joueur(s)";
    }
}
