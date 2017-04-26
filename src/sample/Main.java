package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main extends Application {
    //boolean ready = true; //ustaw ready w listenerze buttonow albo metoda check if ready
    final Colors[] code = initializeCode();
    int trials = 0;
    Stage window;
    Button OK;
    GridPane grid;
    Label codes;
    //Label matches;
    Label actualCode;
    Pin active = null;
    List<ColorButton> buttons = new ArrayList<>(8);
    List<Pin> activePins = new ArrayList<>();
    List<List<Pin>> pins = new ArrayList<>(10);
    List<MatchesRow> matches = new ArrayList<>(10);


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


        grid = new GridPane();
        grid.setGridLinesVisible(true);
        //grid.setPadding(new Insets(10, 10, 10, 10));
        //grid.setVgap(8);
        //grid.setHgap(10);
        initializeButtons();
        initializeLayers();
        initializeActualPins();
        initializeOKButton();
        initializePins();
        initializeMatches();


        //GridPane.setConstraints(codes, 0, 0, 4, 9);
        //GridPane.setConstraints(matches, 4, 0, 1, 10);
        // GridPane.setConstraints(actualCodeColors, 0, 1, 2, 1);

        //grid.getChildren().addAll(codes, matches, actualCode);
        //grid.getChildren().addAll(codes, matches);
        // grid.getChildren().addAll(matches);

        //test MOZLIWE  I DZIALA
//        Button but = new Button("P");
//        GridPane.setConstraints(but, 3, 3);
//        grid.getChildren().addAll(but);
        //test

        window.setScene(new Scene(grid, 300, 600));
        window.show();
    }

    private void initializeMatches() {
        for (int i = 0; i < 10; i++) {
            MatchesRow tmp = new MatchesRow(i);
            for (int j = 4; j < 8; j++) {
                SingleMatch tmpPin = new SingleMatch();
                tmpPin.getLabel().setStyle("-fx-background-color:" + tmpPin.getColor() + "; -fx-border: 4px solid; -fx-border-color: black;");
                tmpPin.getLabel().setMinSize(20, 20);
                tmpPin.getLabel().setMaxSize(20, 20);
                tmp.addPin(tmpPin);
                GridPane.setConstraints(tmpPin.getLabel(), j, i);
                grid.getChildren().add(tmpPin.getLabel());
            }
            matches.add(tmp);
        }
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("u sure u wanna exit bruh ?");
        if (answer) window.close();

    }

    private void initializeLayers() {
//        matches = new Label("matches");
//        matches.setMinSize(100, 500);
//        matches.setMaxSize(100, 500);
//        matches.setStyle("-fx-border: 2px solid; -fx-border-color: blue;");
//        codes = new Label("codes");
//        codes.setMinSize(200, 500);
//        codes.setMaxSize(200, 500);
//        codes.setStyle("-fx-border: 2px solid; -fx-border-color: red;");
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
            activePins.add(new Pin(pins[i], Colors.GRAY));
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


        addPinsListener(activePins);

        grid.getChildren().addAll(pin1, pin2, pin3, pin4);
    }

    private void addPinsListener(List<Pin> pins) {

        pins.forEach(pin -> {
            pin.getLabel().setOnMousePressed(e -> {
                setActive(pin);
            });
        });


    }


    public void initializeButtons() {
        int row = 11;
        int cell = 0;
        for (int i = 0; i < 8; i++) {
            if (i == 4) {
                row = 12;
                cell=0;
            }
            ColorButton tmp = new ColorButton(new Button(), Colors.values()[i]);
            buttons.add(tmp);
            tmp.setColorsAndBorder(Colors.values()[i], 1);
            tmp.getButton().setMinSize(30,30);
            GridPane.setConstraints(tmp.getButton(), cell, row);
            grid.getChildren().add(tmp.getButton());
            cell++;
        }

        addButtonsListeners(buttons);
    }

    private void addButtonsListeners(List<ColorButton> buttons) {
        buttons.forEach(button -> {
            button.getButton().setOnAction(e -> {
                if (active != null) {
                    active.getLabel().setStyle("-fx-background-color:" + button.getColor() + "; -fx-border: 8px solid; -fx-border-color: black;");
                    active.setColor(button.getColor());

                    //activePins.set(activePins.indexOf(active),new Pin(active.getLabel(), button.getColor()));
                }
            });
        });

    }

    private void initializeOKButton() {
        OK = new Button("OK");
        OK.setMaxSize(55, 55);
        OK.setMinSize(55, 55);

        addOKButtonListener();

        GridPane.setConstraints(OK, 4, 11, 4, 2);
        grid.getChildren().add(OK);

    }

    private void addOKButtonListener() {
        OK.setOnAction(e -> {
            if (isReady() && trials < 10) {
                System.out.println(activePins.size());
                List<Pin> tmp = new ArrayList<>();
                activePins.forEach(pin -> {
                    tmp.add(new Pin(new Label(), pin.getColor()));
                    System.out.println("    color----------" + pin.getColor() + activePins.size());
                });

                pins.add(tmp);
                movePins();
                resetPins();
                checkMatches();
                trials++;
            } else {

                //------------------------info ze trzeba wypelnic wszystkie pola
            }
        });

    }

    private void resetPins() {
        activePins.forEach(pin -> {
            pin.setColorsAndBorder(Colors.GRAY, 1);

        });
    }

    private void checkMatches() {

    }

    private Colors[] initializeCode() {
        Colors[] result = new Colors[4];
        Colors[] colors = Colors.values();
        int maximum = 7;
        int minimum = 0;
        Random rn = new Random();
        for (int i = 0; i < 4; i++) {
            result[i] = colors[(minimum + (int) (Math.random() * ((maximum - minimum) + 1)))];
            System.out.println("code----------------- " + result[i].toString());
        }

        return result;

    }

    private void movePins() {
        if (pins.size() > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 4; j++) {
                    Pin tmp = pins.get(i).get(j);
                    tmp.setColor(pins.get(i + 1).get(j).getColor());
                    tmp.getLabel().setStyle("-fx-background-color:" + tmp.getColor() + "; -fx-border: 4px solid; -fx-border-color: black;");
                }
            }
            for (int i = 0; i < 4; i++) {
                pins.get(9).get(i).setColor(activePins.get(i).getColor());
                pins.get(9).get(i).getLabel().setStyle("-fx-background-color:" + activePins.get(i).getColor() + "; -fx-border: 4px solid; -fx-border-color: black;");
            }

            active = null;
//              ready=false;


//            //--------proba // przerzucic przypisanie kolorow gdzie indziej lub dodac usuwanie poprzednich labeli
//            for (int i = 0; i < 4; i++) {
//                Pin tmp= pins.get(0).get(i);
//                tmp.getLabel().setStyle("-fx-background-color:" + tmp.getColor() + "; -fx-border: 4px solid; -fx-border-color: black;");
//                tmp.getLabel().setMinSize(40,40);
//                tmp.getLabel().setMaxSize(40,40);
//                GridPane.setConstraints (tmp.getLabel(), i, 10-pins.size());
//                grid.getChildren().add(tmp.getLabel());
//            }

            //-------proba
        }
    }

    public void initializePins() {
        for (int i = 0; i < 10; i++) {
            List<Pin> tmp = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Pin tmpPin = new Pin();
                tmpPin.getLabel().setStyle("-fx-background-color:" + tmpPin.getColor() + "; -fx-border: 4px solid; -fx-border-color: black;");
                tmpPin.getLabel().setMinSize(30, 30);
                tmpPin.getLabel().setMaxSize(30, 30);
                tmp.add(tmpPin);
                GridPane.setConstraints(tmpPin.getLabel(), j, i);
                grid.getChildren().add(tmpPin.getLabel());
            }
            pins.add(tmp);
        }

    }

    private void setActive(Pin pin) {
        for (Pin pin1 : activePins) {
            pin1.getLabel().setStyle("-fx-background-color:" + pin1.getColor() + ";");
        }
        pin.getLabel().setStyle("-fx-background-color:" + pin.getColor() + "; -fx-border-width: 2px; -fx-border-color: black;");
        active = pin;
    }

    private boolean isReady() {
        boolean ready = true;
        for (Pin pin : activePins) {
            if (pin.getColor().equals(Colors.GRAY)) ready = false;
        }
        return ready;
    }

    public static void main(String[] args) {
        launch(args);
    }


}
