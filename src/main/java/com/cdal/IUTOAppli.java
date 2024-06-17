package main.java.com.cdal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class IUTOAppli extends Application {
    private Scene scene;
    private Button connexion;
    private ImageView logoIUT;
    private ImageView logoIUTO;
    private TextField login;
    private PasswordField password;
    private BorderPane borderP;

    public static void main(String[] args) {
        launch(args);
    }

    public void init() {
        // Initialisation si nécessaire
    }

    @Override
    public void start(Stage primaryStage) {
        this.borderP = new BorderPane();
        this.scene = new Scene(borderP, 500, 500);
        primaryStage.setScene(this.scene);
        primaryStage.setTitle("Jeux IUTO");
        this.pageConnexion();
        primaryStage.show();
    }

    public Pane titre() {
        HBox titre = new HBox(10); 
        titre.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
        
        titre.setPadding(new Insets(10)); 

        this.logoIUT = new ImageView(new Image("file:img/logoIUT.png"));
        this.logoIUTO = new ImageView(new Image("file:img/logoIUTO.png"));
        this.connexion = new Button("Connexion");
        
        titre.getChildren().addAll(this.logoIUT, this.logoIUTO, this.connexion);
        return titre;
    }

    public Pane connexion() {
        VBox VBConnexion = new VBox(10); 
        VBConnexion.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
         
        VBConnexion.setPadding(new Insets(20)); 

        Label titre1 = new Label("Jeux IUT'Olympiques");
        titre1.setFont(new Font("Arial", 30));
        
        
        Label titre2 = new Label("Connexion");
        titre2.setFont(new Font("Arial", 20));
        

        this.login = new TextField();
        this.login.setPromptText("Nom d'utilisateur");
        this.password = new PasswordField();
        this.password.setPromptText("Mot de passe");

        HBox hbBouton = new HBox(10); 
         

        Button annuler = new Button("Annuler");
        Button seConnecter = new Button("Se connecter");

        hbBouton.getChildren().addAll(annuler, seConnecter);

        VBConnexion.getChildren().addAll(titre1, titre2, this.login, this.password, hbBouton);
        return VBConnexion;
    }

    public void pageConnexion() {
        this.borderP.setCenter(connexion());
        this.borderP.setTop(titre());
    }
}
