package main.java.com.cdal;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private Label titreAccueil;
    private ImageView logoUser;
    private TextField user; 
    private ImageView logoPasswd;
    private PasswordField passwdMasquer;
    private TextField passwdVisible;
    private ImageView oeil; 
    private Button valider;
    private Button annuler;
    private ImageView profil;
    private Label idProfil;
    private ImageView accueilImg;
    private ImageView athleteImg;
    private ImageView equipeImg;
    private ImageView paysImg;
    private ImageView quitterImg;
    private Label accueilTxt;
    private Label athleteTxt;
    private Label equipeTxt;
    private Label paysTxt;
    private Label quitterTxt;
    private ConnexionBD connexionBD;


    @Override
    public void init() {
        try {
            this.connexionBD = new ConnexionBD();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver non trouvé :(");
        }
        pagePrincipale = new BorderPane();
        logoJO = new ImageView(new Image("file:img/logoJO.png"));
        logoIUT = new ImageView(new Image("file:img/logoIUT.png"));
        titreConnexion = new Label("Bienvenue aux Jeux IUT'Olympiques ! \n Connectez-vous !");
        titreAccueil = new Label("Bienvenue aux Jeux IUT'Olympiques ! \n Connecté en tant que :");
        logoUser = new ImageView(new Image("file:img/user.png"));
        user = new TextField();
        logoPasswd = new ImageView(new Image("file:img/passwd.png"));
        passwdMasquer = new PasswordField();
        passwdVisible = new TextField();
        oeil = new ImageView(new Image("file:img/oeil.png"));
        profil = new ImageView(new Image("file:img/profil.png"));
        idProfil = new Label("Identifiant");
        accueilImg = new ImageView(new Image("file:img/accueil.png"));
        athleteImg = new ImageView(new Image("file:img/athlete.png"));
        equipeImg = new ImageView(new Image("file:img/equipe.png"));
        paysImg = new ImageView(new Image("file:img/pays.png"));
        quitterImg = new ImageView(new Image("file:img/quitter.png"));
        accueilTxt = new Label("Accueil");
        athleteTxt = new Label("Athlètes");
        equipeTxt = new Label("Equipes");
        paysTxt = new Label("Pays");
        quitterTxt = new Label("Quitter");
        valider = new Button("VALIDER");
        annuler = new Button("ANNULER");
        annuler.setOnAction(new ControleurAnnuler(this));
        valider.setOnAction(new ControleurConnexion(this));
    }

    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setCenter(this.pagePrincipale);
        return new Scene(fenetre, 1000, 600);
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
        gauche.setPrefSize(500, 600);

        VBox logos = new VBox(); 
        logos.setAlignment(Pos.CENTER); 
        logos.setSpacing(20); 
        logos.getChildren().addAll(logoJO, logoIUT); 

        gauche.getChildren().add(logos); 

        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreConnexion.setFont(font);
        titreConnexion.setTextFill(Color.web("#7a1a64"));
        titreConnexion.setTextAlignment(TextAlignment.CENTER);

        logoUser.setFitWidth(40);
        logoUser.setFitHeight(40);

        user.setPromptText("Identifiant");
        user.setStyle("-fx-border-color: #7a1a64;"); 
        user.setPrefWidth(300);
        user.setPrefHeight(40);

        HBox userBox = new HBox();
        userBox.setAlignment(Pos.CENTER);
        userBox.setSpacing(20);
        userBox.getChildren().addAll(logoUser, user);

        logoPasswd.setFitWidth(40);
        logoPasswd.setFitHeight(40);

        passwdMasquer.setPromptText("Mot de passe");
        passwdMasquer.setStyle("-fx-border-color: #7a1a64;"); 
        passwdMasquer.setPrefWidth(300);
        passwdMasquer.setPrefHeight(40);

        passwdVisible.setStyle("-fx-border-color: #7a1a64;");
        passwdVisible.setPrefWidth(300);
        passwdVisible.setPrefHeight(40);
        passwdVisible.setVisible(false); 
        passwdVisible.setManaged(false);

        oeil.setFitWidth(30);
        oeil.setFitHeight(30);

        StackPane passwdPane = new StackPane();
        StackPane.setAlignment(oeil, Pos.CENTER_LEFT);
        StackPane.setMargin(oeil, new Insets(0, 0, 0, 265)); 

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
        droite.setPrefSize(500, 600);
        droite.setSpacing(100);
        droite.getChildren().addAll(titreConnexion, connexionBox);

        HBox connexion = new HBox();
        connexion.getChildren().addAll(gauche, droite);

        pagePrincipale.setCenter(connexion);
    }

    public void pageAccueil() {
        pagePrincipale.getChildren().clear();

        logoJO.setFitWidth(350);
        logoJO.setFitHeight(175);

        logoIUT.setFitWidth(350);
        logoIUT.setFitHeight(175);

        VBox gauche = new VBox();
        gauche.setStyle("-fx-background-color : #7a1a64;");
        gauche.setAlignment(Pos.CENTER); 
        gauche.setPrefSize(200, 600);

        VBox identifiant = new VBox();
        identifiant.setAlignment(Pos.TOP_CENTER);
        identifiant.setPrefSize(100, 150);
        identifiant.setStyle("-fx-background-color : #303030;");
        this.profil.setFitWidth(150);
        this.profil.setFitHeight(150);

        identifiant.getChildren().addAll(this.profil, this.idProfil);
        gauche.getChildren().addAll(identifiant);

        VBox menu = new VBox();
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(20);
        menu.setPrefSize(200, 450);
        this.accueilImg.setFitWidth(50);
        this.accueilImg.setFitHeight(50);
        this.athleteImg.setFitWidth(50);
        this.athleteImg.setFitHeight(50);
        this.equipeImg.setFitWidth(50);
        this.equipeImg.setFitHeight(50);
        this.paysImg.setFitWidth(50);
        this.paysImg.setFitHeight(50);
        this.quitterImg.setFitWidth(50);
        this.quitterImg.setFitHeight(50);

        HBox accueilBox = new HBox();
        this.accueilTxt.setFont(new Font("Arial", 16));
        accueilBox.setAlignment(Pos.CENTER);
        accueilBox.setSpacing(10);
        accueilBox.getChildren().addAll(this.accueilImg, new Label("Accueil"));

        Button buttonAccueil = new Button();
        buttonAccueil.setGraphic(accueilBox);
        buttonAccueil.setPrefWidth(140);

        HBox athleteBox = new HBox();
        athleteBox.setAlignment(Pos.CENTER);
        athleteBox.setSpacing(10);
        athleteBox.getChildren().addAll(this.athleteImg, new Label("Athlètes"));

        Button buttonAthlete = new Button();
        buttonAthlete.setGraphic(athleteBox);
        buttonAthlete.setPrefWidth(140);

        HBox equipeBox = new HBox();
        equipeBox.setAlignment(Pos.CENTER);
        equipeBox.setSpacing(10);
        equipeBox.getChildren().addAll(this.equipeImg, new Label("Equipes"));

        Button buttonEquipe = new Button();
        buttonEquipe.setGraphic(equipeBox);
        buttonEquipe.setPrefWidth(140);

        HBox paysBox = new HBox();
        paysBox.setAlignment(Pos.CENTER);
        paysBox.setSpacing(10);
        paysBox.getChildren().addAll(this.paysImg, new Label("Pays"));

        Button buttonPays = new Button();
        buttonPays.setGraphic(paysBox);
        buttonPays.setPrefWidth(140);

        HBox quitterBox = new HBox();
        quitterBox.setAlignment(Pos.CENTER);
        quitterBox.setSpacing(10);
        quitterBox.getChildren().addAll(this.quitterImg, new Label("Quitter"));

        Button buttonQuitter = new Button();
        buttonQuitter.setGraphic(quitterBox);
        buttonQuitter.setPrefWidth(140);

        menu.getChildren().addAll(buttonAccueil, buttonAthlete, buttonEquipe, buttonPays, buttonQuitter);
        
        gauche.getChildren().add(menu);
         

        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        titreAccueil.setFont(font);
        titreAccueil.setTextFill(Color.web("#7a1a64"));
        titreAccueil.setTextAlignment(TextAlignment.CENTER);

        VBox droite = new VBox();
        droite.setStyle("-fx-background-color : #ffffff;");
        droite.setAlignment(Pos.TOP_CENTER);
        droite.setPrefSize(800, 600);
        droite.setSpacing(100);
        droite.getChildren().addAll(titreAccueil);

        HBox connexion = new HBox();
        connexion.getChildren().addAll(gauche, droite);

        pagePrincipale.setCenter(connexion);
    }
    public void mdpVisible() {
        if (passwdMasquer.isVisible()) {
            passwdVisible.setText(passwdMasquer.getText());
            passwdMasquer.setVisible(true);
            passwdMasquer.setManaged(true);
            passwdVisible.setVisible(false);
            passwdVisible.setManaged(false);
        } else {
            passwdMasquer.setText(passwdVisible.getText());
            passwdVisible.setVisible(true);
            passwdVisible.setManaged(true);
            passwdMasquer.setVisible(false);
            passwdMasquer.setManaged(false);
        }
    }

    public void effacerText() {
        user.setText("");
        passwdMasquer.setText("");
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("JEUX IUT'OLYMPIQUES");
        stage.setScene(this.laScene());
        pageAccueil();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public String getMotDePasse() {
        return this.passwdVisible.getText();
    }
    
    public String getLogin() {
        return this.user.getText();
    }
    
    public void connexionReussie(){
        
    }
    
    public void deconnexionReussie(){
        pageConnexion();
    }
    
    public ConnexionBD getConnexionBD(){
        return connexionBD;
    }
}
