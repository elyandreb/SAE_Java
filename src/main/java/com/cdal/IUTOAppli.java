package main.java.com.cdal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class IUTOAppli extends Application{
    private Scene scene;
    private Button connexion;
    private ImageView logoIUT;
    private ImageView logoIUTO;
    private TextField login;
    private TextField password;

    public static void main(String[] args) {
        launch(args);
    }

    public void init(){

    }

    @Override
    public void start(Stage primaryStage) {
        this.scene= new Scene(connexion, 500,500);
        primaryStage.setScene(this.scene);
        primaryStage.setTitle("Jeux IUTO");
        primaryStage.show();
    }

    public Pane titre(){
        HBox titre = new HBox();
        titre.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
        this.logoIUT = new ImageView(new Image("file:img/logoIUT.png"));
        this.logoIUTO = new ImageView(new Image("file:img/logoIUTO.png"));
        this.connexion = new Button("Connexion");
        titre.getChildren().addAll(this.logoIUT, this.logoIUTO, this.connexion);
        return titre;

    }

    public Pane connexion(){
        Label titre1 = new Label("Jeux IUT'Olympiques");
        VBox VBConnexion = new VBox();
        connexion.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
        Label titre2 = new Label("Connexion");
        titre2.setFont(new Font("Arial", 20));

        this.login = new TextField();
        this.login.setPromptText("Nom d'utilisateur");
        this.password = new TextField();
        this.password.setPromptText("Mot de passe");

        HBox hbBouton = new HBox();
        Button annuler = new Button("Annuler");
        Button connexion = new Button(" Se connecter");
        hbBouton.getChildren().addAll(annuler, connexion);
        
        VBConnexion.getChildren().addAll(titre1,titre2, this.login, this.password, hbBouton);
        return VBConnexion;
    }




}
