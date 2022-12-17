package com.jpmorgan.scenes;

import com.jpmorgan.GameManager;
import com.jpmorgan.SceneManager;
import com.jpmorgan.model.Player2; // para retirar
import com.jpmorgan.events.OpenManagePopupEvent;
import com.jpmorgan.model.Player;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.application.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel {

    private static final String IMAGES_DIRECTORY = "/com/jpmorgan/images/";

    private final Color[] propertiesBorderColors = {
            Color.rgb(143,46,18),
            Color.rgb(159,15,194),
            Color.rgb(244,31,31),
            Color.rgb(15,170,88),
            Color.rgb(56,56,56),
            Color.rgb(120,195,250),
            Color.rgb(255,106,22),
            Color.rgb(255,232,27),
            Color.rgb(24,20,248),
            Color.rgb(196,196,196),
    };

    private final String[] propertyGroups = { "brown", "purple", "red", "green", "station", "light_blue", "orange",
        "yellow", "blue", "company" };

    private final GridPane propertiesGrid = new GridPane();

    private final VBox leftPanel = new VBox();

    Map<String, Node> nodes = new HashMap<>();

    public AnchorPane start() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getStyleClass().add("root");

        nodes.put("anchorPane", anchorPane);

        Player playerSelf = GameManager.getInstance().getPlayerSelf();
        List<Player> otherPlayers = GameManager.getInstance().getPlayers();

        VBox rightPanel = createRightPanel(playerSelf, otherPlayers);
        createLeftPanel(otherPlayers);
        ImageView board = createBoard();

        GridPane gridPane = new GridPane();
        gridPane.add(leftPanel, 0, 0);
        gridPane.add(board, 1, 0);
        gridPane.add(rightPanel, 2, 0);
        gridPane.setHgap(30);
        GridPane.setMargin(leftPanel, new Insets(0, 0, 0, 20));

        anchorPane.getChildren().add(gridPane);

        return anchorPane;
    }

    private ImageView createBoard() {
        InputStream image = getClass().getResourceAsStream(IMAGES_DIRECTORY + "board.png");

        if (image == null) {
            System.err.println("Could not load board image");
        }

        assert image != null;

        return new ImageView(new Image(image));
    }

    private void createLeftPanel(List<Player> players) {
        leftPanel.setAlignment(Pos.CENTER);
        leftPanel.setSpacing(20);
        AnchorPane otherPlayer;
        StackPane balance;
        Circle otherPlayerImage;
        Rectangle background, balanceBackground;
        Text balanceText;

        for (Player player : players) {
            otherPlayerImage = new Circle(63, new ImagePattern(player.getIcon()));

            background = new Rectangle(371, 116, Color.BLACK);
            background.setStroke(Color.WHITE);
            background.setStrokeWidth(4);
            background.setArcWidth(100);
            background.setArcHeight(100);

            balanceBackground = new Rectangle(178, 36, Color.WHITE);
            balanceBackground.setArcWidth(25);
            balanceBackground.setArcHeight(25);
            balanceText = new Text(player.getBalance() + " €");
            balanceText.setFont(Font.font("Inter", FontWeight.BOLD, 24));
            balance = new StackPane(balanceBackground, balanceText);


            otherPlayer = new AnchorPane(background, balance, otherPlayerImage);
            otherPlayer.setId(player.getName());
            AnchorPane.setTopAnchor(background, 60d);
            AnchorPane.setTopAnchor(otherPlayerImage, 0d);
            AnchorPane.setLeftAnchor(otherPlayerImage, 40d);
            AnchorPane.setRightAnchor(balance, 30d);
            AnchorPane.setBottomAnchor(balance, 15d);
            leftPanel.getChildren().add(otherPlayer);
        }
    }

    private VBox createRightPanel(Player playerObj, List<Player> otherPlayers) {
        Circle player = new Circle(117.5, new ImagePattern(playerObj.getIcon()));
        player.setStroke(Color.BLACK);
        player.setStrokeWidth(4);

        propertiesGrid.setMinSize(324, 530);

        for (int i = 0; i < 5; i++) {
            createPropertyRectangle(i, 0, i, propertiesGrid);
        }

        for (int i = 0; i < 5; i++) {
            createPropertyRectangle(i + 5, 1, i, propertiesGrid);
        }

        Rectangle propertyBackground = new Rectangle(230, 67, Color.WHITE);
        propertyBackground.setArcHeight(50);
        propertyBackground.setArcWidth(50);
        GridPane.setHalignment(propertyBackground, HPos.CENTER);

        Text playerSelfBalance = new Text(playerObj.getBalance() + " €");
        playerSelfBalance.setFont(Font.font(
                "Inter",
                FontWeight.BOLD,
                24
        ));

        StackPane property = new StackPane(propertyBackground, playerSelfBalance);
        propertiesGrid.add(property, 0, 6, 2, 2);

        propertiesGrid.setBorder(new Border(new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                new CornerRadii(50),
                new BorderWidths(4)
        )));
        propertiesGrid.setBackground(new Background(new BackgroundFill(
                Color.BLACK,
                new CornerRadii(50),
                Insets.EMPTY
        )));
        propertiesGrid.setAlignment(Pos.CENTER);
        propertiesGrid.setHgap(10);
        propertiesGrid.setVgap(10);

        Button buttonManage = new Button("GERIR");
        Button buttonTrades = new Button("TROCAS");
        Button buttonBankrupt = new Button("FALÊNCIA");
        Button buttonAdvance = new Button("AVANÇAR");

        buttonManage.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new OpenManagePopupEvent((AnchorPane) nodes.get("anchorPane"), otherPlayers));
        
        buttonAdvance.setOnAction(e -> dicesPopUpHandler());

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setHgap(20);
        buttonsGrid.setVgap(10);

        buttonsGrid.add(buttonManage, 0, 0);
        buttonsGrid.add(buttonTrades, 1, 0);
        buttonsGrid.add(buttonBankrupt, 0, 1);
        buttonsGrid.add(buttonAdvance, 1, 1);

        for (Node node : buttonsGrid.getChildren()) {
            Button button = (Button) node;

            button.setMinSize(148, 112);
            button.setBorder(new Border(new BorderStroke(
                    Color.WHITE,
                    BorderStrokeStyle.SOLID,
                    new CornerRadii(50),
                    new BorderWidths(4)
            )));
            button.setBackground(new Background(new BackgroundFill(
                    Color.BLACK,
                    new CornerRadii(50),
                    Insets.EMPTY
            )));
            button.setTextFill(Color.WHITE);
            button.setFont(Font.font(
                    "Inter",
                    FontWeight.BOLD,
                    24
            ));
            button.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
                button.setBackground(new Background(new BackgroundFill(
                        Color.WHITE,
                        new CornerRadii(50),
                        Insets.EMPTY
                )));
                if (!Objects.equals(button.getTextFill(), Color.rgb(236, 27, 27))) {
                    button.setTextFill(Color.BLACK);
                }
            });
            button.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
                button.setBackground(new Background(new BackgroundFill(
                        Color.BLACK,
                        new CornerRadii(50),
                        Insets.EMPTY
                )));
                if (!Objects.equals(button.getTextFill(), Color.rgb(236, 27, 27))) {
                    button.setTextFill(Color.WHITE);
                }
            });
        }

        buttonBankrupt.setTextFill(Color.rgb(236, 27, 27));

        VBox rightPanel = new VBox(player, propertiesGrid, buttonsGrid);
        rightPanel.setAlignment(Pos.CENTER);
        rightPanel.setSpacing(20);
        return rightPanel;
    }

    private void createPropertyRectangle(int imageIndex, int columnIndex, int rowIndex, GridPane propertiesGrid) {
        Rectangle propertyBackground = new Rectangle(129, 67, Color.WHITE);
        propertyBackground.setStrokeWidth(7);
        propertyBackground.setStroke(propertiesBorderColors[imageIndex]);
        propertyBackground.setArcHeight(75);
        propertyBackground.setArcWidth(75);

        HBox properties = new HBox();
        properties.setAlignment(Pos.CENTER_LEFT);
        properties.setSpacing(8);
        properties.setMinWidth(propertyBackground.getWidth() - 21);
        StackPane.setMargin(properties, new Insets(0, 0, 0, 21));

        StackPane property = new StackPane(propertyBackground, properties);
        property.setId(propertyGroups[imageIndex]);
        property.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                ImageView propertyImage = getImageByPropertyGroup(property.getId());
                HBox propertiesEvent = (HBox) property.getChildren().get(1);
                propertiesEvent.getChildren().add(propertyImage);
            } else if (mouseEvent.isSecondaryButtonDown()) {
                HBox propertiesEvent = (HBox) property.getChildren().get(1);

                if (!propertiesEvent.getChildren().isEmpty()) {
                    propertiesEvent.getChildren().remove(propertiesEvent.getChildren().size() - 1);
                }
            }
        });
        propertiesGrid.add(property, columnIndex, rowIndex);
    }

    private ImageView getImageByPropertyGroup(String propertyGroup) {
        InputStream inputStream = getClass().getResourceAsStream(IMAGES_DIRECTORY + "properties/" + propertyGroup + "_small.png");

        return new ImageView(new Image(inputStream));
    }

    public void dicesPopUpHandler() {
        Popup pp = new Popup();
        pp.setAutoHide(false);
        pp.setAutoFix(true);

        AnchorPane anchorPane = new AnchorPane();
        
        anchorPane.setMinWidth(238);
        anchorPane.setMinHeight(120);
        anchorPane.setMaxWidth(238);
        anchorPane.setMaxHeight(120);

        Player2 dice = Player2.getInstance();

        ImageView firstDice = getImageByDice15(dice.roll_dice());
        ImageView secondDice = getImageByDice30(dice.roll_dice());

        AnchorPane.setTopAnchor(firstDice, 10.0);
        AnchorPane.setLeftAnchor(firstDice, 10.0);
        AnchorPane.setTopAnchor(secondDice, 10.0);
        AnchorPane.setLeftAnchor(secondDice, 115.0);
        
        anchorPane.getStyleClass().add("rectangle33");

        anchorPane.getChildren().add(firstDice);
        anchorPane.getChildren().add(secondDice);


        pp.getContent().add(anchorPane);
        
        pp.show(SceneManager.getInstance().getPrimaryStage());
        
        Timer timer = new Timer(true);
        TimerTask tt = new TimerTask() {
        	
            public void run() {
                Platform.runLater(() -> {
                    pp.hide();
                });

                //my Logic
            };
        };
        timer.schedule(tt, 2000);	    
    }

    private ImageView getImageByDice15(int dice) {
        InputStream inputStream = getClass().getResourceAsStream(IMAGES_DIRECTORY + "dices/" + String.valueOf(dice) + "_15.png");
        return new ImageView(new Image(inputStream));
    }

    private ImageView getImageByDice30(int dice) {
        InputStream inputStream = getClass().getResourceAsStream(IMAGES_DIRECTORY + "dices/" + String.valueOf(dice) + "_-30.png");
        return new ImageView(new Image(inputStream));
    }
}
