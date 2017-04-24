package sample;

import javafx.application.Application;


import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import sample.Colors;

import java.util.*;

import static java.util.Map.*;


public class Main extends Application {
    Stage window;
    Button OK;
    GridPane grid;
    Label codes;
    Label matches;
    Label actualCode;
    Colors[] actualCodeColors;
    TableView<Colors> colorsTable;
    Label active = null;
    Hashtable<Button, Colors> buttons = new Hashtable<>();
    Hashtable<Label, Colors> actualPins = new Hashtable<>();


    private List<VBox> oldCodes = new ArrayList<>(10);

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window = primaryStage;
        window.setTitle("Master-Mind");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        //initialize table of colors


        OK = new Button();
        OK.setText("OK");
        OK.setOnAction(e -> {
            System.out.println("dupa");
        });

        grid = new GridPane();
        //grid.setPadding(new Insets(10, 10, 10, 10));
        //grid.setVgap(8);
        //grid.setHgap(10);
        //grid.getChildren().add(OK);
        initializeButtons();
        initializeLayers();
        initializeColorsTable();
        initializeActualPins();
        // Node colors = new

        GridPane.setConstraints(codes, 0, 0, 6, 9);
        GridPane.setConstraints(matches, 6, 0, 1, 9);
        // GridPane.setConstraints(actualCodeColors, 0, 1, 2, 1);

        //grid.getChildren().addAll(codes, matches, actualCode);
        grid.getChildren().addAll(codes, matches);

        //test MOZLIWE  I DZIALA
        Button but = new Button("P");
        GridPane.setConstraints(but, 3, 3);
        grid.getChildren().addAll(but);
        //test

        window.setScene(new Scene(grid, 300, 600));


        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("u sure u wanna exit bruh ?");
        if (answer) window.close();

    }

    private void initializeLayers() {
        matches = new Label("matches");
        matches.setMinSize(100, 500);
        matches.setMaxSize(100, 500);
        matches.setStyle("-fx-border: 2px solid; -fx-border-color: blue;");
        codes = new Label("codes");
        codes.setMinSize(200, 500);
        codes.setMaxSize(200, 500);
        codes.setStyle("-fx-border: 2px solid; -fx-border-color: red;");
        actualCode = new Label("actualCode");
        actualCode.setMinSize(300, 100);
        actualCode.setMaxSize(300, 100);
        actualCode.setStyle("-fx-border: 2px solid; -fx-border-color: green;");


    }

    public void initializeActualPins() {
        Label pin1 = new Label();
        Label pin2 = new Label();
        Label pin3 = new Label();
        Label pin4 = new Label();

        Label[] pins = new Label[]{pin1, pin2, pin3, pin4};
        for (int i = 0; i < pins.length; i++) {
            actualPins.put(pins[i], Colors.GRAY);
        }

        GridPane.setConstraints(pin1, 0, 10);
        GridPane.setConstraints(pin2, 1, 10);
        GridPane.setConstraints(pin3, 2, 10);
        GridPane.setConstraints(pin4, 3, 10);

        pin1.setMinSize(40, 40);
        pin2.setMinSize(40, 40);
        pin3.setMinSize(40, 40);
        pin4.setMinSize(40, 40);

        pin1.setStyle("-fx-background-color:gray; -fx-border: 2px solid; -fx-border-color: DimGray ;");
        pin2.setStyle("-fx-background-color:gray; -fx-border: 2px solid; -fx-border-color: DimGray ;");
        pin3.setStyle("-fx-background-color:gray; -fx-border: 2px solid; -fx-border-color: DimGray ;");
        pin4.setStyle("-fx-background-color:gray; -fx-border: 2px solid; -fx-border-color: DimGray ;");


        addPinsListener(actualPins);

        grid.getChildren().addAll(pin1, pin2, pin3, pin4);
    }

    private void addPinsListener(Hashtable<Label, Colors> pins) {

        pins.forEach((key, value) -> {
            key.setOnMousePressed(e -> {
                active = key;
                key.setStyle("-fx-background-color:" + value + "; -fx-border: 4px solid; -fx-border-color: black;"); //to zmienia kolor pino w na niebieski!!!!!!!!!!!!!!!!!!!
            });
        });


    }



    public void initializeButtonsMap(Button[] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            this.buttons.put(buttons[i], Colors.values()[i]);
        }

    }


    public void initializeButtons() {
        Button red = new Button("RED");
        Button blue = new Button("BLUE");
        Button green = new Button("GREEN");
        Button yellow = new Button("YELLOW");
        Button black = new Button("BLACK");
        Button white = new Button("WHITE");

        Button[] tmpButtons = new Button[]{red, blue, green, yellow, black, white};
        initializeButtonsMap(tmpButtons);
        addButtonsListeners(buttons);

        GridPane.setConstraints(red, 0, 11);
        GridPane.setConstraints(blue, 1, 11);
        GridPane.setConstraints(green, 2, 11);
        GridPane.setConstraints(yellow, 3, 11);
        GridPane.setConstraints(black, 4, 11);
        GridPane.setConstraints(white, 5, 11);


        grid.getChildren().addAll(red, blue, green, yellow, black, white);


    }

    private void addButtonsListeners(Hashtable<Button, Colors> buttons) {
        buttons.forEach((key, value) -> {
            key.setOnAction(e -> {
                if (active != null) {
                    active.setStyle("-fx-background-color:" + value + "; -fx-border: 4px solid; -fx-border-color: black;");
                    actualPins.put(active,value);
                }
            });
        });

    }

    private void initializeColorsTable() {

        actualCodeColors = new Colors[]{Colors.RED, Colors.BLUE, Colors.GREEN, Colors.YELLOW, Colors.BLACK, Colors.WHITE};
    }


    public static void main(String[] args) {
        launch(args);
    }


}
