package com.example.lykkehjulgui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LykkehjulGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    //Deklarer alle variabler her
    private BorderPane hovedPane = new BorderPane();
    //Label og tekstfelt for navn, telefon, epost
    private Label navn = new Label();
    private Label tlf = new Label();
    private Label epost = new Label();

    private TextField txtNavn = new TextField();
    private TextField txtTlf = new TextField();
    private TextField txtEpost = new TextField();

    VBox vBox = new VBox();
    VBox knapper = new VBox();
    HBox hBox = new HBox();
    //Knapper for grafisk og fil og logg innn
    Button grafisk = new Button("Grafisk");
    Button fil = new Button("Fil");
    Button loggInn = new Button("Logg inn");

    //tekstfelt
    TextArea txtInfo = new TextArea();
    TextArea txtRekker = new TextArea();

    //Vindusstørrelse
    protected static final int VINDU_HØYDE = 400;
    protected static final int VINDU_BREDDE = 800;


    @Override
    public void start(Stage primaryStage) {
        //Starter
        //Henter labelen og tekstfelt
        navn = new Label("Navn");
        txtNavn = new TextField();
        txtNavn.setMaxWidth(210);

        tlf = new Label("Telefonnummer");
        txtTlf = new TextField();
        txtTlf.setMaxWidth(210);

        epost = new Label("Epost");
        txtEpost = new TextField();
        txtEpost.setMaxWidth(210);


        //Legger vbox til venstre i borderpanet, og legger inn diverse informasjon
        vBox = new VBox(navn, txtNavn, tlf, txtTlf, epost, txtEpost, loggInn);
        vBox.setPadding(new Insets(VINDU_HØYDE/100, VINDU_HØYDE/100, VINDU_BREDDE/100, VINDU_BREDDE/100));
        vBox.setSpacing(10);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(0,191,255), CornerRadii.EMPTY, Insets.EMPTY)));

        //vBox knapp nederst til venstre
        knapper = new VBox(grafisk, fil);
        knapper.setPadding(new Insets(VINDU_HØYDE/100, VINDU_HØYDE/200, VINDU_BREDDE/200, VINDU_BREDDE/100));
        knapper.setSpacing(25);
        grafisk.setFont(new Font(12));
        knapper.setBackground(new Background(new BackgroundFill(Color.rgb(0,191,255), CornerRadii.EMPTY, Insets.EMPTY)));

        //Tekstfelt for info og rekker nederst i pane
        txtInfo = new TextArea("Info:");
        txtInfo.setPrefColumnCount(15);
        txtInfo.setPrefRowCount(6);

        txtRekker = new TextArea("Rekker:");
        txtRekker.setPrefColumnCount(15);
        txtRekker.setPrefRowCount(6);

        //legger til hbox nederst i borderpanet og legger til det som hører til der
        hBox = new HBox(knapper,txtInfo, txtRekker);
        hBox.setSpacing(98);
        hBox.setBackground(new Background(new BackgroundFill(Color.rgb(0,191,255), CornerRadii.EMPTY, Insets.EMPTY)));
        //hBox.setPadding(new Insets(VINDU_HØYDE/90, VINDU_HØYDE/90, VINDU_BREDDE/5, VINDU_BREDDE/5));

        //Lager nytt pane og setter dem til venstre og nederst
        BorderPane nyttPane = new BorderPane();
        nyttPane.setLeft(vBox);
        nyttPane.setBottom(hBox);
        hovedPane.setCenter(nyttPane);

        Scene scene = new Scene(hovedPane, VINDU_BREDDE, VINDU_HØYDE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void lagRekkeKnapper() {
        Button[] tabell = new Button[34];

        for (int i = 0; i<= tabell.length; i++) {
            tabell[i] = new Button("Tall" + (i+1));
        }
        HBox knappBox = new HBox();
        knappBox.getChildren().addAll(tabell);

        BorderPane knappPane = new BorderPane();
        knappPane.setCenter(knappBox);
    }
}
