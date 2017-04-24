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

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    Stage window;
    Button OK;
    GridPane grid;
    Label codes;
    Label matches;
    Label actualCode;
    Colors[] actualCodeColors;
    TableView<Colors> colorsTable;


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
        initializeLayers();
        initializeColorsTable();
       // Node colors = new

        GridPane.setConstraints(codes, 0, 0);
        GridPane.setConstraints(matches, 1, 0);
        GridPane.setConstraints(actualCodeColors, 0, 1, 2, 1);

        grid.getChildren().addAll(codes, matches, actualCode);

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

    private void initializeColorsTable() {

        actualCodeColors = new Colors[]{Colors.RED, Colors.BLUE, Colors.GREEN, Colors.YELLOW, Colors.BLACK, Colors.WHITE};
    }


    public static void main(String[] args) {
        launch(args);
    }


}
