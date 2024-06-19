package main.java.com.cdal;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class AppIUTO extends Application {

    private ConnexionBD connexionBD;
    private BorderPane pagePrincipale;
    private ImageView logoJO;
    private ImageView logoIUT;
    private Label titreConnexion;
    private ImageView logoUser;
    private TextField user; 
    private ImageView logoPasswd;
    private PasswordField passwdMasquer;
    private TextField passwdVisible;
    private ImageView oeil; 
    private Button valider;
    private Button annuler;
    private ImageView profil;
    private Label titreJournaliste;
    private Region ligneBlanche; 
    private ImageView home; 
    private Button accueil; 
    private ImageView athl;
    private Button athlete;  
    private ImageView eqp; 
    private Button equipe; 
    private ImageView ps; 
    private Button pays; 
    private ImageView spt; 
    private Button sport; 
    private ImageView deco; 
    private Button deconnexion;
    private Label athleteNom; 
    private TextField textAthleteNom; 
    private Label athletePrenom; 
    private TextField textAthletePrenom; 
    private Button rechercher; 
    private Label equipeNom; 
    private TextField textEquipeNom; 
    private Label paysNom; 
    private TextField textPaysNom; 
    private Label sportNom; 
    private ComboBox<Sport> lesSports; 
    private Label titreAdministrateur; 
    private Button ajouterAthl; 
    private Button supprimerAthl; 
    private Label athleteSexe; 
    private RadioButton homme; 
    private RadioButton femme; 
    private Label athleteAgilite; 
    private Label athleteEndurance; 
    private Label athleteForce; 
    private Button ajouteAthlete; 
    private Button retourAthlete; 
    private Button supprimeAthlete;
    private Button ajouteEqp; 
    private Button supprimeEqp;  
    private Button ajouterEquipe; 
    private Button retourEquipe; 
    private Button supprimerEquipe; 
    private Button ajoutePs; 
    private Button supprimePs; 
    private Label nomPaysAjoute; 
    private TextField textPaysAjoute; 
    private Label orPaysAjoute; 
    private Label argentPaysAjoute; 
    private Label bronzePaysAjoute; 
    private Button ajoutePays; 
    private Button retourPays; 
    private Button supprimePays; 
    private Button ajouteSpt; 
    private Button supprimeSpt; 
    private Label nomSport; 
    private TextField textNomSport; 
    private Label nomEpreuve; 
    private TextField textNomEpreuve; 
    private Button ajouteSport; 
    private Button retourSport1; 
    private Button ajouteEpreuve;
    private Button retourSport2;  
    private Button supprimeSport;
    private ComboBox<Epreuve> lesEpreuves;  
    private Button supprimeEpreuve; 

    @Override
    public void init() {
        try {
            this.connexionBD = new ConnexionBD();
            connexionBD.connecter();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver non trouvé :(");
        } catch (SQLException e) {
            System.out.println("Problèmes SQL (mdp?)");
        }
        pagePrincipale = new BorderPane();
        logoJO = new ImageView(new Image("file:img/logoJO.png"));
        logoIUT = new ImageView(new Image("file:img/logoIUT.png"));
        titreConnexion = new Label("Bienvenue aux Jeux IUT'Olympiques ! \n Connectez-vous !");
        logoUser = new ImageView(new Image("file:img/user.png"));
        user = new TextField();
        logoPasswd = new ImageView(new Image("file:img/passwd.png"));
        passwdMasquer = new PasswordField();
        passwdVisible = new TextField();
        oeil = new ImageView(new Image("file:img/oeil.png"));
        oeil.setOnMouseClicked(new ControleurVisibilter(this)); 
        valider = new Button("VALIDER");
        valider.setOnAction(new ControleurConnexion(this));
        annuler = new Button("ANNULER");
        annuler.setOnAction(new ControleurAnnuler(this));
        profil = new ImageView(new Image("file:img/profil.png"));
        titreJournaliste = new Label("JOURNALISTE");
        ligneBlanche = new Region();
        home = new ImageView(new Image("file:img/home.png"));
        accueil = new Button("ACCUEIL");
        athl = new ImageView(new Image("file:img/athlete.png"));
        athlete = new Button("ATHLETE");
        athlete.setOnAction(new ControleurAthlete(this));
        eqp = new ImageView(new Image("file:img/equipe.png"));
        equipe = new Button("EQUIPE");
        equipe.setOnAction(new ControleurEquipe(this));
        ps = new ImageView(new Image("file:img/pays.png"));
        pays = new Button("PAYS");
        pays.setOnAction(new ControleurPays(this));
        spt = new ImageView(new Image("file:img/sport.png"));
        sport = new Button("SPORT");
        sport.setOnAction(new ControleurSport(this));
        deco = new ImageView(new Image("file:img/deco.png"));
        deconnexion = new Button("DECONNEXION");
        deconnexion.setOnAction(new ControleurDeconnexion(this));
        athleteNom = new Label("Nom de l'athlète");
        textAthleteNom = new TextField();
        athletePrenom = new Label("Prénom de l'athlète");
        textAthletePrenom = new TextField();
        rechercher = new Button("RECHERCHER");
        equipeNom = new Label("Nom de l'équipe");
        textEquipeNom = new TextField();
        paysNom = new Label("Nom du pays");
        textPaysNom = new TextField();
        sportNom = new Label("Nom des sports");
        lesSports = new ComboBox<>(); 
        titreAdministrateur = new Label("ADMINISTRATEUR");
        ajouterAthl = new Button("AJOUTER");
        ajouterAthl.setOnAction(new ControleurAjouteAthlete(this));
        supprimerAthl = new Button("SUPPRIMER");
        supprimerAthl.setOnAction(new ControleurSupprimeAthlete(this)); 
        athleteSexe = new Label("Sexe de l'athlète");
        homme = new RadioButton("Homme");
        femme = new RadioButton("Femme");
        athleteAgilite = new Label("Agilité");
        athleteEndurance = new Label("Endurance");
        athleteForce = new Label("Force");
        ajouteAthlete = new Button("AJOUTER");
        retourAthlete = new Button("RETOUR");
        retourAthlete.setOnAction(new ControleurAthlete(this)); 
        supprimeAthlete = new Button("SUPPRIMER"); 
        ajouteEqp = new Button("AJOUTER");
        ajouteEqp.setOnAction(new ControleurAjouteEquipe(this));
        supprimeEqp = new Button("SUPPRIMER");
        supprimeEqp.setOnAction(new ControleurSupprimerEquipe(this)); 
        ajouterEquipe = new Button("AJOUTER");
        retourEquipe = new Button("RETOUR"); 
        retourEquipe.setOnAction(new ControleurEquipe(this)); 
        supprimerEquipe = new Button("SUPPRIMER");
        ajoutePs = new Button("AJOUTER");
        ajoutePs.setOnAction(new ControleurAjoutePays(this));
        supprimePs = new Button("SUPPRIMER");  
        supprimePs.setOnAction(new ControleurSupprimerPays(this));
        nomPaysAjoute = new Label("Nom du pays");
        textPaysAjoute = new TextField(); 
        orPaysAjoute = new Label("Nombre de médailles d'or");
        argentPaysAjoute = new Label("Nombre de médailles d'argent");
        bronzePaysAjoute = new Label("Nombre de médailles de bronze");    
        ajoutePays = new Button("AJOUTER");
        retourPays = new Button("RETOUR");  
        retourPays.setOnAction(new ControleurPays(this));
        supprimePays = new Button("SUPPRIMER"); 
        ajouteSpt = new Button("AJOUTER");
        ajouteSpt.setOnAction(new ControleurAjouteSport(this));
        supprimeSpt = new Button("SUPPRIMER");
        supprimeSpt.setOnAction(new ControleurSupprimerSport(this));
        nomSport = new Label("Nom du sport");
        textNomSport = new TextField();
        nomEpreuve = new Label("Nom de l'épreuve");
        textNomEpreuve = new TextField();   
        ajouteSport = new Button("AJOUTER");
        retourSport1 = new Button("RETOUR"); 
        retourSport1.setOnAction(new ControleurSport(this));
        ajouteEpreuve = new Button("AJOUTER"); 
        retourSport2 = new Button("RETOUR"); 
        retourSport2.setOnAction(new ControleurSport(this));  
        supprimeSport = new Button("SUPPRIMER");
        lesEpreuves = new ComboBox<>(); 
        supprimeEpreuve = new Button("SUPPRIMER");  
    }

    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setCenter(this.pagePrincipale);
        return new Scene(fenetre, 1000, 725);
    }

    public void pageConnexion() {
        pagePrincipale.getChildren().clear();

        logoJO.setFitWidth(350);
        logoJO.setFitHeight(175);

        logoIUT.setFitWidth(350);
        logoIUT.setFitHeight(175);

        VBox gauche = new VBox();
        gauche.setStyle("-fx-background-color : #7a1a64;");
        gauche.setAlignment(Pos.CENTER);
        gauche.setPrefSize(500, 725);

        VBox logos = new VBox(); 
        logos.setAlignment(Pos.CENTER); 
        logos.setSpacing(20); 
        logos.getChildren().addAll(logoJO, logoIUT); 

        gauche.getChildren().add(logos); 

        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreConnexion.setFont(font);
        titreConnexion.setTextFill(Color.web("#7a1a64"));
        titreConnexion.setTextAlignment(TextAlignment.CENTER);

        logoUser.setFitWidth(45);
        logoUser.setFitHeight(45);

        user.setPromptText("Identifiant");
        user.setStyle("-fx-border-color: #7a1a64;"); 
        user.setPrefWidth(300);
        user.setPrefHeight(40);

        HBox userBox = new HBox();
        userBox.setAlignment(Pos.CENTER);
        userBox.setSpacing(20);
        userBox.getChildren().addAll(logoUser, user);

        logoPasswd.setFitWidth(45);
        logoPasswd.setFitHeight(45);

        passwdMasquer.setPromptText("Mot de passe");
        passwdMasquer.setStyle("-fx-border-color: #7a1a64;"); 
        passwdMasquer.setPrefWidth(300);
        passwdMasquer.setPrefHeight(40);

        passwdVisible.setPromptText("Mot de passe");
        passwdVisible.setStyle("-fx-border-color: #7a1a64;");
        passwdVisible.setPrefWidth(300);
        passwdVisible.setPrefHeight(40);
        passwdVisible.setVisible(false); 
        passwdVisible.setManaged(false);

        oeil.setFitWidth(30);
        oeil.setFitHeight(30);

        StackPane passwdPane = new StackPane();
        StackPane.setMargin(oeil, new Insets(0, 0, 0, 260)); 

        passwdPane.getChildren().addAll(passwdMasquer, passwdVisible, oeil);

        HBox passwdBox = new HBox();
        passwdBox.setAlignment(Pos.CENTER);
        passwdBox.setSpacing(20);
        passwdBox.getChildren().addAll(logoPasswd, passwdPane);

        VBox saisiBox = new VBox();
        saisiBox.setAlignment(Pos.CENTER); 
        saisiBox.setSpacing(30);
        saisiBox.getChildren().addAll(userBox, passwdBox);

        valider.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        valider.setPrefWidth(360);
        valider.setPrefHeight(40);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(360);
        annuler.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        valider.setFont(buttonFont);
        annuler.setFont(buttonFont);

        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER); 
        buttonBox.setSpacing(30);
        buttonBox.getChildren().addAll(valider, annuler);

        VBox connexionBox = new VBox();
        connexionBox.setAlignment(Pos.CENTER);
        connexionBox.setSpacing(50);
        connexionBox.getChildren().addAll(saisiBox, buttonBox);

        VBox droite = new VBox();
        droite.setStyle("-fx-background-color : #ffffff;");
        droite.setAlignment(Pos.CENTER);
        droite.setPrefSize(500, 725);
        droite.setSpacing(100);
        droite.getChildren().addAll(titreConnexion, connexionBox);

        HBox connexion = new HBox();
        connexion.getChildren().addAll(gauche, droite);

        pagePrincipale.requestFocus();
        pagePrincipale.setCenter(connexion);
    }

    public void pageAccueilJournaliste() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);

        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreJournaliste.setFont(font);
        titreJournaliste.setTextFill(Color.web("#ffffff"));
        titreJournaliste.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreJournaliste);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setPrefSize(700, 725);
        contenu.setStyle("-fx-background-color : #ffffff;");
        contenu.setSpacing(100);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageAthleteJournaliste() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreJournaliste.setFont(font);
        titreJournaliste.setTextFill(Color.web("#ffffff"));
        titreJournaliste.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreJournaliste);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        athleteNom.setFont(font3);
        athleteNom.setStyle("-fx-text-fill: #7a1a64;");  

        textAthleteNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textAthleteNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(athleteNom, textAthleteNom);

        athletePrenom.setFont(font3);
        athletePrenom.setStyle("-fx-text-fill: #7a1a64;");  

        textAthletePrenom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textAthletePrenom.setPromptText("Saisissez le prénom");

        HBox prenomBox = new HBox();
        prenomBox.setSpacing(20);
        prenomBox.getChildren().addAll(athletePrenom, textAthletePrenom);

        rechercher.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        rechercher.setPrefWidth(215);
        rechercher.setPrefHeight(15);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(215);
        annuler.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        rechercher.setFont(boutonFont);
        annuler.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(rechercher, annuler);

        VBox rechercheBox = new VBox();
        rechercheBox.setSpacing(20);
        rechercheBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        rechercheBox.getChildren().addAll(nomBox, prenomBox, boutonBox);

        TableView<Athlete> tableAthlete = new TableView<>();

        TableColumn<Athlete, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Athlete, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Athlete, String> sexeCol = new TableColumn<>("Sexe");
        sexeCol.setCellValueFactory(new PropertyValueFactory<>("sexe"));

        TableColumn<Athlete, Integer> agiliteCol = new TableColumn<>("Agilité");
        agiliteCol.setCellValueFactory(new PropertyValueFactory<>("agilite"));

        TableColumn<Athlete, Integer> enduranceCol = new TableColumn<>("Endurance");
        enduranceCol.setCellValueFactory(new PropertyValueFactory<>("endurance"));

        TableColumn<Athlete, Integer> forceCol = new TableColumn<>("Force");
        forceCol.setCellValueFactory(new PropertyValueFactory<>("force"));

        TableColumn<Athlete, Integer> resCol = new TableColumn<>("Résultat");
        resCol.setCellValueFactory(new PropertyValueFactory<>("resultat"));

        tableAthlete.getColumns().addAll(nomCol, prenomCol, sexeCol, agiliteCol, enduranceCol, forceCol, resCol);
        tableAthlete.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                    
        contenu.getChildren().addAll(rechercheBox, tableAthlete);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageEquipeJournaliste() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreJournaliste.setFont(font);
        titreJournaliste.setTextFill(Color.web("#ffffff"));
        titreJournaliste.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreJournaliste);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        equipeNom.setFont(font3);
        equipeNom.setStyle("-fx-text-fill: #7a1a64;");  

        textEquipeNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textEquipeNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(equipeNom, textEquipeNom);

        rechercher.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        rechercher.setPrefWidth(215);
        rechercher.setPrefHeight(15);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(215);
        annuler.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        rechercher.setFont(boutonFont);
        annuler.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(rechercher, annuler);

        VBox rechercheBox = new VBox();
        rechercheBox.setSpacing(20);
        rechercheBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        rechercheBox.getChildren().addAll(nomBox, boutonBox);

        TableView<Equipe> tableEquipe = new TableView<>();
        tableEquipe.setPrefHeight(450);

        TableColumn<Equipe, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Equipe, Integer> resCol = new TableColumn<>("Résultat");
        resCol.setCellValueFactory(new PropertyValueFactory<>("resultat"));

        tableEquipe.getColumns().addAll(nomCol, resCol);
        tableEquipe.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                    
        contenu.getChildren().addAll(rechercheBox, tableEquipe);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pagePaysJournaliste() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreJournaliste.setFont(font);
        titreJournaliste.setTextFill(Color.web("#ffffff"));
        titreJournaliste.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreJournaliste);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        paysNom.setFont(font3);
        paysNom.setStyle("-fx-text-fill: #7a1a64;");  

        textPaysNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textPaysNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(paysNom, textPaysNom);

        rechercher.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        rechercher.setPrefWidth(215);
        rechercher.setPrefHeight(15);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(215);
        annuler.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        rechercher.setFont(boutonFont);
        annuler.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(rechercher, annuler);

        VBox rechercheBox = new VBox();
        rechercheBox.setSpacing(20);
        rechercheBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        rechercheBox.getChildren().addAll(nomBox, boutonBox);

        TableView<Pays> tablePays = new TableView<>();
        tablePays.setPrefHeight(450);

        TableColumn<Pays, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Pays, Integer> orCol = new TableColumn<>("Or");
        orCol.setCellValueFactory(new PropertyValueFactory<>("nbMedaillesOr"));

        TableColumn<Pays, Integer> argentCol = new TableColumn<>("Argent");
        argentCol.setCellValueFactory(new PropertyValueFactory<>("nbMedaillesArgent"));

        TableColumn<Pays, Integer> bronzeCol = new TableColumn<>("Bronze");
        bronzeCol.setCellValueFactory(new PropertyValueFactory<>("nbMedaillesBronze"));

        TableColumn<Pays, Integer> totalCol = new TableColumn<>("Total");
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalMedailles"));

        tablePays.getColumns().addAll(nomCol, orCol, argentCol, bronzeCol, totalCol);
        tablePays.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                    
        contenu.getChildren().addAll(rechercheBox, tablePays);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageSportJournaliste() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreJournaliste.setFont(font);
        titreJournaliste.setTextFill(Color.web("#ffffff"));
        titreJournaliste.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreJournaliste);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        sportNom.setFont(font3);
        sportNom.setStyle("-fx-text-fill: #7a1a64;");
        
        lesSports.setPrefWidth(200);
        
        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(sportNom, lesSports);

        rechercher.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        rechercher.setPrefWidth(215);
        rechercher.setPrefHeight(15);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(215);
        annuler.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        rechercher.setFont(boutonFont);
        annuler.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(rechercher, annuler);

        VBox rechercheBox = new VBox();
        rechercheBox.setSpacing(20);
        rechercheBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        rechercheBox.getChildren().addAll(nomBox, boutonBox);

        TableView<Epreuve> tableSport = new TableView<>();
        tableSport.setPrefHeight(450);

        TableColumn<Epreuve, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Epreuve, String> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));

        tableSport.getColumns().addAll(nomCol, genreCol);
        tableSport.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                    
        contenu.getChildren().addAll(rechercheBox, tableSport);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageAccueilAdministrateur() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);

        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setPrefSize(700, 725);
        contenu.setStyle("-fx-background-color : #ffffff;");
        contenu.setSpacing(100);

        HBox administrateur = new HBox();
        administrateur.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(administrateur);
    }

    public void pageAthleteAdministrateur() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        athleteNom.setFont(font3);
        athleteNom.setStyle("-fx-text-fill: #7a1a64;");  

        textAthleteNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textAthleteNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(athleteNom, textAthleteNom);

        athletePrenom.setFont(font3);
        athletePrenom.setStyle("-fx-text-fill: #7a1a64;");  

        textAthletePrenom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textAthletePrenom.setPromptText("Saisissez le prénom");

        HBox prenomBox = new HBox();
        prenomBox.setSpacing(20);
        prenomBox.getChildren().addAll(athletePrenom, textAthletePrenom);

        rechercher.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        rechercher.setPrefWidth(215);
        rechercher.setPrefHeight(15);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(215);
        annuler.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        rechercher.setFont(boutonFont);
        annuler.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(rechercher, annuler);

        VBox rechercheBox = new VBox();
        rechercheBox.setSpacing(20);
        rechercheBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        rechercheBox.getChildren().addAll(nomBox, prenomBox, boutonBox);

        ajouterAthl.setFont(boutonFont);
        supprimerAthl.setFont(boutonFont);

        ajouterAthl.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajouterAthl.setPrefWidth(325);
        ajouterAthl.setPrefHeight(15);

        supprimerAthl.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimerAthl.setPrefWidth(325);
        supprimerAthl.setPrefHeight(15);

        HBox adminBox = new HBox(); 
        adminBox.setSpacing(20);
        adminBox.getChildren().addAll(ajouterAthl, supprimerAthl);

        TableView<Athlete> tableAthlete = new TableView<>();

        TableColumn<Athlete, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Athlete, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Athlete, String> sexeCol = new TableColumn<>("Sexe");
        sexeCol.setCellValueFactory(new PropertyValueFactory<>("sexe"));

        TableColumn<Athlete, Integer> agiliteCol = new TableColumn<>("Agilité");
        agiliteCol.setCellValueFactory(new PropertyValueFactory<>("agilite"));

        TableColumn<Athlete, Integer> enduranceCol = new TableColumn<>("Endurance");
        enduranceCol.setCellValueFactory(new PropertyValueFactory<>("endurance"));

        TableColumn<Athlete, Integer> forceCol = new TableColumn<>("Force");
        forceCol.setCellValueFactory(new PropertyValueFactory<>("force"));

        TableColumn<Athlete, Integer> resCol = new TableColumn<>("Résultat");
        resCol.setCellValueFactory(new PropertyValueFactory<>("resultat"));

        tableAthlete.getColumns().addAll(nomCol, prenomCol, sexeCol, agiliteCol, enduranceCol, forceCol, resCol);
        tableAthlete.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                    
        contenu.getChildren().addAll(rechercheBox, adminBox, tableAthlete);

        HBox administrateur = new HBox();
        administrateur.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(administrateur);
    }

    public void pageAjouteAthlete() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);
        contenu.setAlignment(Pos.CENTER);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        athleteNom.setFont(font3);
        athleteNom.setStyle("-fx-text-fill: #7a1a64;");  

        textAthleteNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textAthleteNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(athleteNom, textAthleteNom);

        athletePrenom.setFont(font3);
        athletePrenom.setStyle("-fx-text-fill: #7a1a64;");  

        textAthletePrenom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textAthletePrenom.setPromptText("Saisissez le prénom");

        HBox prenomBox = new HBox();
        prenomBox.setSpacing(20);
        prenomBox.getChildren().addAll(athletePrenom, textAthletePrenom);

        athleteSexe.setFont(font3);
        athleteSexe.setStyle("-fx-text-fill: #7a1a64;");

        ToggleGroup sexe = new ToggleGroup(); 
        homme.setToggleGroup(sexe);
        femme.setToggleGroup(sexe);
        homme.setStyle("-fx-font-size: 18px;");
        femme.setStyle("-fx-font-size: 18px;");

        HBox sexeBox = new HBox(); 
        sexeBox.setSpacing(20);
        sexeBox.getChildren().addAll(athleteSexe, homme, femme);

        athleteAgilite.setFont(font3);
        athleteAgilite.setStyle("-fx-text-fill: #7a1a64;"); 

        Spinner<Integer> agiliteSpinner = new Spinner<>();
        SpinnerValueFactory<Integer> valeur = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        agiliteSpinner.setValueFactory(valeur);
        agiliteSpinner.setStyle("-fx-font-size: 15px;");  

        HBox agiliteBox = new HBox();
        agiliteBox.setSpacing(20);
        agiliteBox.getChildren().addAll(athleteAgilite, agiliteSpinner);

        athleteEndurance.setFont(font3);
        athleteEndurance.setStyle("-fx-text-fill: #7a1a64;"); 

        Spinner<Integer> enduranceSpinner = new Spinner<>();
        enduranceSpinner.setValueFactory(valeur);
        enduranceSpinner.setStyle("-fx-font-size: 15px;");  

        HBox enduranceBox = new HBox();
        enduranceBox.setSpacing(20);
        enduranceBox.getChildren().addAll(athleteEndurance, enduranceSpinner);

        athleteForce.setFont(font3);
        athleteForce.setStyle("-fx-text-fill: #7a1a64;"); 

        Spinner<Integer> forceSpinner = new Spinner<>();
        forceSpinner.setValueFactory(valeur);
        forceSpinner.setStyle("-fx-font-size: 15px;");  

        HBox forceBox = new HBox();
        forceBox.setSpacing(20);
        forceBox.getChildren().addAll(athleteForce, forceSpinner);

        ajouteAthlete.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajouteAthlete.setPrefWidth(215);
        ajouteAthlete.setPrefHeight(15);

        retourAthlete.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourAthlete.setPrefWidth(215);
        retourAthlete.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        ajouteAthlete.setFont(boutonFont);
        retourAthlete.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(ajouteAthlete, retourAthlete);

        VBox ajouteBox = new VBox();
        ajouteBox.setSpacing(20);
        ajouteBox.getChildren().addAll(nomBox, prenomBox, sexeBox, agiliteBox, enduranceBox, forceBox);

        VBox ajouteAthleteBox = new VBox(); 
        ajouteAthleteBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        ajouteAthleteBox.setSpacing(40);
        ajouteAthleteBox.getChildren().addAll(ajouteBox, boutonBox); 
                    
        contenu.getChildren().addAll(ajouteAthleteBox);

        HBox administrateur = new HBox();
        administrateur.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(administrateur);
    }

    public void pageSupprimeAthlete() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);
        contenu.setAlignment(Pos.CENTER);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        athleteNom.setFont(font3);
        athleteNom.setStyle("-fx-text-fill: #7a1a64;");  

        textAthleteNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textAthleteNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(athleteNom, textAthleteNom);

        athletePrenom.setFont(font3);
        athletePrenom.setStyle("-fx-text-fill: #7a1a64;");  

        textAthletePrenom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textAthletePrenom.setPromptText("Saisissez le prénom");

        HBox prenomBox = new HBox();
        prenomBox.setSpacing(20);
        prenomBox.getChildren().addAll(athletePrenom, textAthletePrenom);

        supprimeAthlete.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimeAthlete.setPrefWidth(215);
        supprimeAthlete.setPrefHeight(15);

        retourAthlete.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourAthlete.setPrefWidth(215);
        retourAthlete.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        supprimeAthlete.setFont(boutonFont);
        retourAthlete.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(supprimeAthlete, retourAthlete);

        VBox supprimeBox = new VBox();
        supprimeBox.setSpacing(20);
        supprimeBox.getChildren().addAll(nomBox, prenomBox);

        VBox supprimeAthleteBox = new VBox(); 
        supprimeAthleteBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        supprimeAthleteBox.setSpacing(40);
        supprimeAthleteBox.getChildren().addAll(supprimeBox, boutonBox); 
                    
        contenu.getChildren().addAll(supprimeAthleteBox);

        HBox administrateur = new HBox();
        administrateur.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(administrateur);
    }

    public void pageEquipeAdministrateur() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        equipeNom.setFont(font3);
        equipeNom.setStyle("-fx-text-fill: #7a1a64;");  

        textEquipeNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textEquipeNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(equipeNom, textEquipeNom);

        rechercher.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        rechercher.setPrefWidth(215);
        rechercher.setPrefHeight(15);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(215);
        annuler.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        rechercher.setFont(boutonFont);
        annuler.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(rechercher, annuler);

        VBox rechercheBox = new VBox();
        rechercheBox.setSpacing(20);
        rechercheBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        rechercheBox.getChildren().addAll(nomBox, boutonBox);

        ajouteEqp.setFont(boutonFont);
        supprimeEqp.setFont(boutonFont);

        ajouteEqp.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajouteEqp.setPrefWidth(325);
        ajouteEqp.setPrefHeight(15);

        supprimeEqp.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimeEqp.setPrefWidth(325);
        supprimeEqp.setPrefHeight(15);

        HBox adminBox = new HBox(); 
        adminBox.setSpacing(20);
        adminBox.getChildren().addAll(ajouteEqp, supprimeEqp);

        TableView<Equipe> tableEquipe = new TableView<>();
        tableEquipe.setPrefHeight(450);

        TableColumn<Equipe, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Equipe, Integer> resCol = new TableColumn<>("Résultat");
        resCol.setCellValueFactory(new PropertyValueFactory<>("resultat"));

        tableEquipe.getColumns().addAll(nomCol, resCol);
        tableEquipe.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                    
        contenu.getChildren().addAll(rechercheBox, adminBox, tableEquipe);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageAjouteEquipe() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 20, 20));
        contenu.setAlignment(Pos.CENTER);
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        equipeNom.setFont(font3);
        equipeNom.setStyle("-fx-text-fill: #7a1a64;");  

        textEquipeNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textEquipeNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(equipeNom, textEquipeNom);

        ajouterEquipe.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajouterEquipe.setPrefWidth(215);
        ajouterEquipe.setPrefHeight(15);

        retourEquipe.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourEquipe.setPrefWidth(215);
        retourEquipe.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        ajouterEquipe.setFont(boutonFont);
        retourEquipe.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(ajouterEquipe, retourEquipe);

        VBox ajouteEquipeBox = new VBox();
        ajouteEquipeBox.setSpacing(20);
        ajouteEquipeBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        ajouteEquipeBox.getChildren().addAll(nomBox, boutonBox);
                    
        contenu.getChildren().addAll(ajouteEquipeBox);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageSupprimeEquipe() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 20, 20));
        contenu.setAlignment(Pos.CENTER);
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        equipeNom.setFont(font3);
        equipeNom.setStyle("-fx-text-fill: #7a1a64;");  

        textEquipeNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textEquipeNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(equipeNom, textEquipeNom);

        supprimerEquipe.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimerEquipe.setPrefWidth(215);
        supprimerEquipe.setPrefHeight(15);

        retourEquipe.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourEquipe.setPrefWidth(215);
        retourEquipe.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        supprimerEquipe.setFont(boutonFont);
        retourEquipe.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(supprimerEquipe, retourEquipe);

        VBox supprimeEquipeBox = new VBox();
        supprimeEquipeBox.setSpacing(20);
        supprimeEquipeBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        supprimeEquipeBox.getChildren().addAll(nomBox, boutonBox);
                    
        contenu.getChildren().addAll(supprimeEquipeBox);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pagePaysAdministrateur() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        paysNom.setFont(font3);
        paysNom.setStyle("-fx-text-fill: #7a1a64;");  

        textPaysNom.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textPaysNom.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(paysNom, textPaysNom);

        rechercher.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        rechercher.setPrefWidth(215);
        rechercher.setPrefHeight(15);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(215);
        annuler.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        rechercher.setFont(boutonFont);
        annuler.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(rechercher, annuler);

        VBox rechercheBox = new VBox();
        rechercheBox.setSpacing(20);
        rechercheBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        rechercheBox.getChildren().addAll(nomBox, boutonBox);

        ajoutePs.setFont(boutonFont);
        supprimePs.setFont(boutonFont);

        ajoutePs.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajoutePs.setPrefWidth(325);
        ajoutePs.setPrefHeight(15);

        supprimePs.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimePs.setPrefWidth(325);
        supprimePs.setPrefHeight(15);

        HBox adminBox = new HBox(); 
        adminBox.setSpacing(20);
        adminBox.getChildren().addAll(ajoutePs, supprimePs);

        TableView<Pays> tablePays = new TableView<>();
        tablePays.setPrefHeight(450);

        TableColumn<Pays, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Pays, Integer> orCol = new TableColumn<>("Or");
        orCol.setCellValueFactory(new PropertyValueFactory<>("nbMedaillesOr"));

        TableColumn<Pays, Integer> argentCol = new TableColumn<>("Argent");
        argentCol.setCellValueFactory(new PropertyValueFactory<>("nbMedaillesArgent"));

        TableColumn<Pays, Integer> bronzeCol = new TableColumn<>("Bronze");
        bronzeCol.setCellValueFactory(new PropertyValueFactory<>("nbMedaillesBronze"));

        TableColumn<Pays, Integer> totalCol = new TableColumn<>("Total");
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalMedailles"));

        tablePays.getColumns().addAll(nomCol, orCol, argentCol, bronzeCol, totalCol);
        tablePays.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                    
        contenu.getChildren().addAll(rechercheBox, adminBox, tablePays);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageAjoutePays() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 20, 20));
        contenu.setAlignment(Pos.CENTER);
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        nomPaysAjoute.setFont(font3);
        nomPaysAjoute.setStyle("-fx-text-fill: #7a1a64;");  

        textPaysAjoute.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textPaysAjoute.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(nomPaysAjoute, textPaysAjoute);

        orPaysAjoute.setFont(font3);
        orPaysAjoute.setStyle("-fx-text-fill: #7a1a64;"); 

        Spinner<Integer> orSpinner = new Spinner<>();
        SpinnerValueFactory<Integer> valeur = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        orSpinner.setValueFactory(valeur);
        orSpinner.setStyle("-fx-font-size: 15px;");  

        HBox orBox = new HBox();
        orBox.setSpacing(20);
        orBox.getChildren().addAll(orPaysAjoute, orSpinner);

        argentPaysAjoute.setFont(font3);
        argentPaysAjoute.setStyle("-fx-text-fill: #7a1a64;"); 

        Spinner<Integer> argentSpinner = new Spinner<>();
        argentSpinner.setValueFactory(valeur);
        argentSpinner.setStyle("-fx-font-size: 15px;");  

        HBox argentBox = new HBox();
        argentBox.setSpacing(20);
        argentBox.getChildren().addAll(argentPaysAjoute, argentSpinner);

        bronzePaysAjoute.setFont(font3);
        bronzePaysAjoute.setStyle("-fx-text-fill: #7a1a64;"); 

        Spinner<Integer> bronzeSpinner = new Spinner<>();
        bronzeSpinner.setValueFactory(valeur);
        bronzeSpinner.setStyle("-fx-font-size: 15px;");  

        HBox bronzeBox = new HBox();
        bronzeBox.setSpacing(20);
        bronzeBox.getChildren().addAll(bronzePaysAjoute, bronzeSpinner);

        ajoutePays.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajoutePays.setPrefWidth(215);
        ajoutePays.setPrefHeight(15);

        retourPays.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourPays.setPrefWidth(215);
        retourPays.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        ajoutePays.setFont(boutonFont);
        retourPays.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(ajoutePays, retourPays);

        VBox ajouteBox = new VBox();
        ajouteBox.setSpacing(20);
        ajouteBox.getChildren().addAll(nomBox, orBox, argentBox, bronzeBox);

        VBox ajoutePaysBox = new VBox(); 
        ajoutePaysBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        ajoutePaysBox.setSpacing(40);
        ajoutePaysBox.getChildren().addAll(ajouteBox, boutonBox); 
                    
        contenu.getChildren().addAll(ajoutePaysBox);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageSupprimePays() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 20, 20));
        contenu.setAlignment(Pos.CENTER);
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        nomPaysAjoute.setFont(font3);
        nomPaysAjoute.setStyle("-fx-text-fill: #7a1a64;");  

        textPaysAjoute.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textPaysAjoute.setPromptText("Saisissez le nom");

        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(nomPaysAjoute, textPaysAjoute);

        supprimePays.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimePays.setPrefWidth(215);
        supprimePays.setPrefHeight(15);

        retourPays.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourPays.setPrefWidth(215);
        retourPays.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        supprimePays.setFont(boutonFont);
        retourPays.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(supprimePays, retourPays);

        VBox supprimeBox = new VBox();
        supprimeBox.setSpacing(20);
        supprimeBox.getChildren().addAll(nomBox);

        VBox supprimePaysBox = new VBox(); 
        supprimePaysBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        supprimePaysBox.setSpacing(40);
        supprimePaysBox.getChildren().addAll(supprimeBox, boutonBox); 
                    
        contenu.getChildren().addAll(supprimePaysBox);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageSportAdministrateur() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 40, 20));
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        sportNom.setFont(font3);
        sportNom.setStyle("-fx-text-fill: #7a1a64;");
        
        lesSports.setPrefWidth(200);
        
        HBox nomBox = new HBox();
        nomBox.setSpacing(20);
        nomBox.getChildren().addAll(sportNom, lesSports);

        rechercher.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        rechercher.setPrefWidth(215);
        rechercher.setPrefHeight(15);

        annuler.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        annuler.setPrefWidth(215);
        annuler.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        rechercher.setFont(boutonFont);
        annuler.setFont(boutonFont);

        HBox boutonBox = new HBox();
        boutonBox.setSpacing(20);
        boutonBox.getChildren().addAll(rechercher, annuler);

        VBox rechercheBox = new VBox();
        rechercheBox.setSpacing(20);
        rechercheBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        rechercheBox.getChildren().addAll(nomBox, boutonBox);

        ajouteSpt.setFont(boutonFont);
        supprimeSpt.setFont(boutonFont);

        ajouteSpt.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajouteSpt.setPrefWidth(325);
        ajouteSpt.setPrefHeight(15);

        supprimeSpt.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimeSpt.setPrefWidth(325);
        supprimeSpt.setPrefHeight(15);

        HBox adminBox = new HBox(); 
        adminBox.setSpacing(20);
        adminBox.getChildren().addAll(ajouteSpt, supprimeSpt);

        TableView<Epreuve> tableSport = new TableView<>();
        tableSport.setPrefHeight(450);

        TableColumn<Epreuve, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Epreuve, String> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));

        tableSport.getColumns().addAll(nomCol, genreCol);
        tableSport.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                    
        contenu.getChildren().addAll(rechercheBox, adminBox, tableSport);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageAjouteSport() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 20, 20));
        contenu.setAlignment(Pos.CENTER);
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        nomSport.setFont(font3);
        nomSport.setStyle("-fx-text-fill: #7a1a64;");  

        textNomSport.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textNomSport.setPromptText("Saisissez le nom");

        HBox nomSportBox = new HBox();
        nomSportBox.setSpacing(20);
        nomSportBox.getChildren().addAll(nomSport, textNomSport);

        ajouteSport.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajouteSport.setPrefWidth(215);
        ajouteSport.setPrefHeight(15);

        retourSport1.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourSport1.setPrefWidth(215);
        retourSport1.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        ajouteSport.setFont(boutonFont);
        retourSport1.setFont(boutonFont);

        HBox boutonSportBox = new HBox();
        boutonSportBox.setSpacing(20);
        boutonSportBox.getChildren().addAll(ajouteSport, retourSport1);

        VBox ajouteSportBox = new VBox();
        ajouteSportBox.setSpacing(20);
        ajouteSportBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        ajouteSportBox.getChildren().addAll(nomSportBox, boutonSportBox);

        nomEpreuve.setFont(font3);
        nomEpreuve.setStyle("-fx-text-fill: #7a1a64;");  

        textNomEpreuve.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 1px; -fx-padding: 5px;");
        textNomEpreuve.setPromptText("Saisissez le nom");

        HBox nomEpreuveBox = new HBox();
        nomEpreuveBox.setSpacing(20);
        nomEpreuveBox.getChildren().addAll(nomEpreuve, textNomEpreuve);

        ajouteEpreuve.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        ajouteEpreuve.setPrefWidth(215);
        ajouteEpreuve.setPrefHeight(15);

        retourSport2.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourSport2.setPrefWidth(215);
        retourSport2.setPrefHeight(15);

        ajouteEpreuve.setFont(boutonFont);
        retourSport2.setFont(boutonFont); 

        HBox boutonEpreuveBox = new HBox();
        boutonEpreuveBox.setSpacing(20);
        boutonEpreuveBox.getChildren().addAll(ajouteEpreuve, retourSport2);

        VBox ajouteEpreuveBox = new VBox();
        ajouteEpreuveBox.setSpacing(20);
        ajouteEpreuveBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        ajouteEpreuveBox.getChildren().addAll(nomEpreuveBox, boutonEpreuveBox);

        VBox ajouteEpreuveSportBox = new VBox(); 
        ajouteEpreuveSportBox.setSpacing(60);
        ajouteEpreuveSportBox.getChildren().addAll(ajouteSportBox, ajouteEpreuveBox); 
        contenu.getChildren().addAll(ajouteEpreuveSportBox);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void pageSupprimeSport() {
        pagePrincipale.getChildren().clear();

        profil.setFitWidth(150);
        profil.setFitHeight(150);
        
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAdministrateur.setFont(font);
        titreAdministrateur.setTextFill(Color.web("#ffffff"));
        titreAdministrateur.setTextAlignment(TextAlignment.CENTER);

        ligneBlanche.setPrefWidth(50);
        ligneBlanche.setPrefHeight(5); 
        ligneBlanche.setStyle("-fx-background-color: white;");

        VBox haut = new VBox();
        haut.setAlignment(Pos.CENTER);
        haut.setSpacing(10);
        haut.getChildren().addAll(profil, titreAdministrateur);

        home.setFitWidth(40);
        home.setFitHeight(40);

        accueil.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        accueil.setPrefWidth(200);
        accueil.setPrefHeight(40);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        accueil.setFont(buttonFont);

        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        homeBox.setSpacing(20);
        homeBox.getChildren().addAll(home, accueil);

        athl.setFitWidth(40);
        athl.setFitHeight(40);

        athlete.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        athlete.setPrefWidth(200);
        athlete.setPrefHeight(40);
        athlete.setFont(buttonFont);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(20);
        athleteBox.getChildren().addAll(athl, athlete);

        eqp.setFitWidth(40);
        eqp.setFitHeight(40);

        equipe.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        equipe.setPrefWidth(200);
        equipe.setPrefHeight(40);
        equipe.setFont(buttonFont);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(20);
        equipeBox.getChildren().addAll(eqp, equipe);

        ps.setFitWidth(40);
        ps.setFitHeight(40);

        pays.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        pays.setPrefWidth(200);
        pays.setPrefHeight(40);
        pays.setFont(buttonFont);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(20);
        paysBox.getChildren().addAll(ps, pays);

        spt.setFitWidth(40);
        spt.setFitHeight(40);

        sport.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        sport.setPrefWidth(200);
        sport.setPrefHeight(40);
        sport.setFont(buttonFont);

        HBox sportBox = new HBox();
        sportBox.setAlignment(Pos.CENTER);
        sportBox.setSpacing(20);
        sportBox.getChildren().addAll(spt, sport);

        deco.setFitWidth(40);
        deco.setFitHeight(40);

        deconnexion.setStyle("-fx-background-color : white; -fx-text-fill: #7a1a64;");
        deconnexion.setPrefWidth(200);
        deconnexion.setPrefHeight(40);
        deconnexion.setFont(buttonFont);

        HBox decoBox = new HBox();
        decoBox.setAlignment(Pos.CENTER);
        decoBox.setSpacing(20);
        decoBox.getChildren().addAll(deco, deconnexion);

        VBox menu = new VBox();
        menu.setStyle("-fx-background-color : #7a1a64;");
        menu.setSpacing(30);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setPrefSize(300, 725);
        menu.getChildren().addAll(haut, ligneBlanche, homeBox, athleteBox, equipeBox, paysBox, sportBox, decoBox);

        VBox contenu = new VBox();
        contenu.setStyle("-fx-background-color: #ffffff");
        contenu.setPadding(new Insets(20, 20, 20, 20));
        contenu.setAlignment(Pos.CENTER);
        contenu.setSpacing(30);
        contenu.setPrefSize(700, 725);

        Font font3 = Font.font("Arial", FontWeight.BOLD, 20);

        nomSport.setFont(font3);
        nomSport.setStyle("-fx-text-fill: #7a1a64;");  

        HBox nomSportBox = new HBox();
        nomSportBox.setSpacing(20);
        nomSportBox.getChildren().addAll(nomSport, lesSports);

        supprimeSport.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimeSport.setPrefWidth(215);
        supprimeSport.setPrefHeight(15);

        retourSport1.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourSport1.setPrefWidth(215);
        retourSport1.setPrefHeight(15);

        Font boutonFont = Font.font("Arial", FontWeight.BOLD, 20);
        supprimeSport.setFont(boutonFont);
        retourSport1.setFont(boutonFont);

        HBox boutonSportBox = new HBox();
        boutonSportBox.setSpacing(20);
        boutonSportBox.getChildren().addAll(supprimeSport, retourSport1);

        VBox ajouteSportBox = new VBox();
        ajouteSportBox.setSpacing(20);
        ajouteSportBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        ajouteSportBox.getChildren().addAll(nomSportBox, boutonSportBox);

        nomEpreuve.setFont(font3);
        nomEpreuve.setStyle("-fx-text-fill: #7a1a64;");  

        lesEpreuves.setPrefWidth(200);

        HBox nomEpreuveBox = new HBox();
        nomEpreuveBox.setSpacing(20);
        nomEpreuveBox.getChildren().addAll(nomEpreuve, lesEpreuves);

        supprimeEpreuve.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        supprimeEpreuve.setPrefWidth(215);
        supprimeEpreuve.setPrefHeight(15);

        retourSport2.setStyle("-fx-background-color : #7a1a64; -fx-text-fill: white;");
        retourSport2.setPrefWidth(215);
        retourSport2.setPrefHeight(15);

        supprimeEpreuve.setFont(boutonFont);
        retourSport2.setFont(boutonFont); 

        HBox boutonEpreuveBox = new HBox();
        boutonEpreuveBox.setSpacing(20);
        boutonEpreuveBox.getChildren().addAll(supprimeEpreuve, retourSport2);

        VBox ajouteEpreuveBox = new VBox();
        ajouteEpreuveBox.setSpacing(20);
        ajouteEpreuveBox.setStyle("-fx-border-color: #7a1a64; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-padding: 40px;");
        ajouteEpreuveBox.getChildren().addAll(nomEpreuveBox, boutonEpreuveBox);

        VBox ajouteEpreuveSportBox = new VBox(); 
        ajouteEpreuveSportBox.setSpacing(60);
        ajouteEpreuveSportBox.getChildren().addAll(ajouteSportBox, ajouteEpreuveBox); 
        contenu.getChildren().addAll(ajouteEpreuveSportBox);

        HBox journaliste = new HBox();
        journaliste.getChildren().addAll(menu, contenu);

        pagePrincipale.setCenter(journaliste);
    }

    public void mdpVisible() {
        if (passwdMasquer.isVisible()) {
            passwdVisible.setText(passwdMasquer.getText());
            passwdMasquer.setVisible(false);
            passwdMasquer.setManaged(false);
            passwdVisible.setVisible(true);
            passwdVisible.setManaged(true);
        } else {
            passwdMasquer.setText(passwdVisible.getText());
            passwdVisible.setVisible(false);
            passwdVisible.setManaged(false);
            passwdMasquer.setVisible(true);
            passwdMasquer.setManaged(true);
        }
    }

    public void effacerText() {
        user.setText("");
        passwdMasquer.setText("");
        passwdVisible.setText("");
        textAthleteNom.setText("");
        textAthletePrenom.setText("");
        textPaysNom.setText("");
    }

    public String getMotDePasse() {
        return this.passwdMasquer.getText();
    }

    public String getLogin() {
        return this.user.getText();
    }

    public ConnexionBD getConnexionBD(){
        return this.connexionBD;
    }

    public void deconnexionReussie(){
        pageConnexion();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("JEUX IUT'OLYMPIQUES");
        stage.setScene(this.laScene());
        pageConnexion();
        stage.setMinWidth(1000);
        stage.setMinHeight(725);
        stage.setMaxWidth(1000);
        stage.setMaxHeight(725);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
