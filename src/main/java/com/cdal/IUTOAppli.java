
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
        this.scene= new Scene(500,500);
        primaryStage.setScene(this.scene);
        primaryStage.setTitle("Jeux IUTO");
        primaryStage.show();
    }

    public Pane fenetreConnexion(){

    }

    public Pane titre(){
        Hbox titre = new Hbox();
        titre.setBackGround(new Background(new BackgroundFill(Color.GREY)));
        this.logoIUT = new ImageView(new Image("file:img/logoIUT.png"));
        this.logoIUTO = new ImageView(new Image("file:img/logoIUTO.png"));
        this.connexion = new Button("Connexion");
        titre.getChildren().addAll(this.logoIUT, this.logoIUTO, this.connexion);

    }

    public Pane connexion(){
        Label titre = new Label("Jeux IUT'Olympiques");
        VBox connexion = new VBox();
        connexion.setBackGround(new Background(new BackgroundFill(Color.GREY)));
        Label titre = new Label("Connexion");
        titre.setFont(new Font("Arial", 20));

        this.login = new TextField();
        this.login.setPromptText("Nom d'utilisateur");
        this.password = new TextField();
        this.password.setPromptText("Mot de passe");

        Hbox hbBouton = new Hbox();
        Button annuler = new Button("Annuler");
        Button connexion = new Button(" Se connecter");
        hbBouton.getChildren().addAll(annuler, connexion);
        
        connexion.getChildren().addAll(titre, this.login, this.password, hbBouton);
    }




}