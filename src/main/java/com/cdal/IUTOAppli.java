import main.java.com.cdal.database.ConnexionBD;


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
import javax.swing.text.html.ImageView;


public class IUTOAppli extends Application {
    private Scene scene;
    private Button connexion;
    private ImageView logoIUT;
    private ImageView logoIUTO;
    private ImageView logoJO;
    private TextField login;
    private TextField password;
    private ConnexionBD connexionBD;

    public static void main(String[] args) {
        launch(args);
    }

    public void init(){
        
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
        HBox titre = new HBox();
        titre.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
        this.logoIUT = new ImageView(new Image("file:img/logoIUT.png"));
        this.logoIUTO = new ImageView(new Image("file:img/logoIUTO.png"));
        this.connexion = new Button("Connexion");
        titre.getChildren().addAll(this.logoIUT, this.logoIUTO, this.connexion);
        return titre;
    }

    public Pane connexion() {
        HBox titre = new HBox();
        this.logoJO = new ImageView(new Image("file:img/logoJO.png"));
        this.logoJO.setFitHeight(30); 
        this.logoJO.setFitWidth(30); 
        Label titre1 = new Label("Jeux IUT'Olympiques");
        titre1.setFont(new Font("Arial", 30));
        titre.getChildren().addAll(this.logoJO, titre1);
        
        
        VBox VBConnexion = new VBox();
        VBConnexion.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        Label titre2 = new Label("Connexion");
        titre2.setFont(new Font("Arial", 20));

        this.login = new TextField();
        this.login.setPromptText("Nom d'utilisateur");
        this.password = new PasswordField();
        this.password.setPromptText("Mot de passe");
        this.password.setPrefWidth(10);
        

        HBox hbBouton = new HBox();
        Button annuler = new Button("Annuler");
        annuler.setStyle("-fx-background-color: #A9A9A9; -fx-text-fill: white; -fx-font-size: 14px;");
        
        
        Button seConnecter = new Button("Se connecter");
        seConnecter.setStyle("-fx-background-color: #000000; -fx-text-fill: white; -fx-font-size: 14px;");
        
        hbBouton.setSpacing(50);
        hbBouton.setAlignment(Pos.CENTER);
        hbBouton.getChildren().addAll(annuler, seConnecter);

        VBConnexion.getChildren().addAll(titre1, titre2, this.login, this.password, hbBouton);
        return VBConnexion;
    }

    public void pageConnexion() {
        this.borderP.setCenter(connexion());
        //this.borderP.setTop(titre());
    }
}
