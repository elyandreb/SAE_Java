package main.java.com.cdal;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private Label paysNom; 
    private TextField textPaysNom; 

    @Override
    public void init() {
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
        valider.setOnAction(new ControleurValider(this));
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
        ps = new ImageView(new Image("file:img/pays.png"));
        pays = new Button("PAYS");
        pays.setOnAction(new ControleurPays(this));
        spt = new ImageView(new Image("file:img/sport.png"));
        sport = new Button("SPORT");
        deco = new ImageView(new Image("file:img/deco.png"));
        deconnexion = new Button("DECONNEXION");
        deconnexion.setOnAction(new ControleurDeconnexion(this));
        athleteNom = new Label("Nom de l'athlète");
        textAthleteNom = new TextField();
        athletePrenom = new Label("Prénom de l'athlète");
        textAthletePrenom = new TextField();
        rechercher = new Button("RECHERCHER");
        paysNom = new Label("Nom du pays");
        textPaysNom = new TextField();
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
        contenu.setPadding(new Insets(20, 20, 30, 20));
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
        contenu.setPadding(new Insets(20, 20, 30, 20));
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
