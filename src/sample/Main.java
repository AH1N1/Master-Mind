package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main extends Application {
    List<Colors> code;
    int trials = 0;
    Stage window;
    Button OK;
    GridPane grid;
    Label actualCode;
    Pin active = null;
    List<ColorButton> buttons;
    List<Pin> activePins;
    List<List<Pin>> pins;
    List<MatchesRow> matches;

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
        startGame();

        window.setScene(new Scene(grid, 300, 600));
        window.show();
    }

    private void startGame() {
        active = null;
        trials = 0;
        code = initializeCode();
        initializeButtons();
        initializeLayers();
        initializeActivePins();
        initializeOKButton();
        initializePins();
        initializeMatches();
    }

    private void restartGame() {
        grid.getChildren().clear();
        startGame();
    }

    private void initializeMatches() {
        matches = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            MatchesRow tmp = new MatchesRow(i);
            for (int j = 4; j < 8; j++) {
                SingleMatch tmpPin = new SingleMatch();
                tmpPin.getLabel().setStyle("-fx-background-color:" + tmpPin.getColor() + "; -fx-border-width: 4px solid; -fx-border-color: black;");
                tmpPin.getLabel().setMinSize(20, 20);
                tmpPin.getLabel().setMaxSize(20, 20);
                tmp.addMatch(tmpPin);
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

    public void initializeActivePins() {
        activePins = new ArrayList<>();

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
        buttons = new ArrayList<>(8);
        int row = 11;
        int cell = 0;
        for (int i = 0; i < 8; i++) {
            if (i == 4) {
                row = 12;
                cell = 0;
            }
            ColorButton tmp = new ColorButton(new Button(), Colors.values()[i]);
            buttons.add(tmp);
            tmp.setColorsAndBorder(Colors.values()[i], 1);
            tmp.getButton().setMinSize(30, 30);
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
                    System.out.println(active.getColor() + "click");
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
                trials++;
                System.out.println("trials przed" + trials);
                pins.add(tmp);
                checkMatches();//uzaleznic checka mtches. move pins od trials
                movePins();  // uzaleznic move pins od trials
                resetPins();

                //trials++;
            }
            if (trials >= 10) {
                //checkMatches();  //jesli wygram w ostatniej wyskocza oba
                //movePins();
                //resetPins();
                gameLost();

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
        moveMatches();
        ArrayList<Colors> possibleColors = new ArrayList<>(4);
        Colors[] tmpMatches = new Colors[4];
        int correct = 0;
        int color = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(activePins.get(i).getColor() + "a");
            System.out.println(code.get(i) + "c");
            System.out.println((activePins.get(i).getColor().equals(code.get(i))));
            if (activePins.get(i).getColor().equals(code.get(i))) {
                tmpMatches[i] = activePins.get(i).getColor();
                correct++;
                continue;
            } else {
                possibleColors.add(activePins.get(i).getColor());
            }
        }
        System.out.println("  possiblecolors size " + possibleColors.size() + " correct:   " + correct);
        for (int i = 0; i < 4; i++) {
            System.out.println("null " + (null == tmpMatches[i]));
            System.out.println("coint " + possibleColors.contains(code.get(i)));
            if (null == tmpMatches[i] && possibleColors.contains(code.get(i))) { //lub odwrotnie
                possibleColors.remove(code.get(i));
                color++;
            }
        }
        System.out.println("color:   " + color + "  possiblecolors size " + possibleColors.size());
        System.out.println("correct:   " + correct);
        for (int i = 0; i < correct; i++) {
            matches.get(9).getMatch(i).setColorsAndBorder(Colors.BLACK, 1);
        }
        for (int i = correct; i < correct + color; i++) {
            matches.get(9).getMatch(i).setColorsAndBorder(Colors.WHITE, 1);
        }
        if (correct == 4) {
            movePins();  // uzaleznic move pins od trials
            resetPins();
            gameWon();
        }


    }

    private void gameWon() {
        InfoBox.display("You won motherfucker!!!!");
        restartGame();
    }

    private void moveMatches() {
        if (matches.size() > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 4; j++) {
                    SingleMatch tmp = matches.get(i).getMatch(j);
                    tmp.setColor(matches.get(i + 1).getMatch(j).getColor());
                    tmp.getLabel().setStyle("-fx-background-color:" + tmp.getColor() + "; -fx-border-color: black;");
                }
            }
            for (int i = 0; i < 4; i++) {
                matches.get(9).getMatch(i).setColorsAndBorder(Colors.GRAY, 1);
                //pins.get(9).get(i).getLabel().setStyle("-fx-background-color:" + activePins.get(i).getColor() + "; -fx-border: 4px solid; -fx-border-color: black;");
            }
        }
    }

    private List<Colors> initializeCode() {
        List<Colors> result = new ArrayList<>();
        Colors[] colors = Colors.values();
        int maximum = 7;
        int minimum = 0;
        Random rn = new Random();
        for (int i = 0; i < 4; i++) {
            result.add(colors[(minimum + (int) (Math.random() * ((maximum - minimum) + 1)))]);
            System.out.println("code----------------- " + result.get(i).toString());
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
        pins = new ArrayList<>();
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
            pin1.getLabel().setStyle("-fx-background-color:" + pin1.getColor() + ";-fx-border-width: 1px; -fx-border-color: DimGray;");
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

    public void gameLost() {
        StringBuilder answer = new StringBuilder();
        code.forEach(color -> answer.append(color + " \n"));
        InfoBox.display("HA! You lost GAIIIIII!!!!!", "The correct answer was: " + answer);
        restartGame();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
