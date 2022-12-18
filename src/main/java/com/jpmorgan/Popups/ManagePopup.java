package com.jpmorgan.Popups;

import com.jpmorgan.model.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.util.List;
import java.util.Objects;

public class ManagePopup extends Popup {

    private static final String IMAGES_DIRECTORY = "/com/jpmorgan/images/";

    private final List<Player> players;

    private Pair<Player, Circle> selectedPlayer;

    public ManagePopup(AnchorPane anchorPane, List<Player> players) {
        super(anchorPane);
        this.players = players;
    }

    @Override
    protected Node createContent() {
        GridPane grid = new GridPane();

        for (Player player : players) {
            createPlayer(grid, player);
        }

        grid.setAlignment(Pos.CENTER);

        Button tradeButton = new Button("TROCAR");
        tradeButton.setMinSize(660, 181);
        tradeButton.setFont(Font.font("Inter", FontWeight.BOLD, 64));
        tradeButton.setTextFill(Color.WHITE);
        tradeButton.setBackground(new Background(new BackgroundFill(
                Color.BLACK,
                new CornerRadii(50),
                Insets.EMPTY
        )));
        tradeButton.setBorder(new Border(new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                new CornerRadii(50),
                new BorderWidths(4)
        )));
        tradeButton.setOnMouseEntered(mouse -> {
            Button node = (Button) mouse.getPickResult().getIntersectedNode();
            node.setTextFill(Color.BLACK);
            node.setBackground(new Background(new BackgroundFill(
                    Color.WHITE,
                    new CornerRadii(50),
                    Insets.EMPTY
            )));
        });
        tradeButton.setOnMouseExited(mouse -> {
            tradeButton.setTextFill(Color.WHITE);
            tradeButton.setBackground(new Background(new BackgroundFill(
                    Color.BLACK,
                    new CornerRadii(50),
                    Insets.EMPTY
            )));
        });
        tradeButton.setOnMousePressed(mouse -> {
            if (selectedPlayer != null) {
                new TradingPopup(getAnchorPane(), selectedPlayer.getKey()).changeContentToSelf(this);
            }
        });

        grid.add(tradeButton, 1, 2);
        grid.setVgap(70);
        grid.setHgap(70);
        GridPane.setMargin(grid, new Insets(0, 10, 0, 10));

        Image closeImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(IMAGES_DIRECTORY + "cross.png")));

        Circle closeButton = new Circle(36);
        closeButton.setFill(new ImagePattern(closeImage));
        closeButton.addEventHandler(MouseEvent.MOUSE_PRESSED, mouse -> closePopup());

        StackPane container = new StackPane(grid, closeButton);
        container.setBackground(new Background(new BackgroundFill(
                Color.BLACK,
                new CornerRadii(50),
                Insets.EMPTY
        )));
        StackPane.setAlignment(container, Pos.BASELINE_CENTER);
        StackPane.setAlignment(closeButton, Pos.TOP_LEFT);
        StackPane.setMargin(closeButton, new Insets(-30, 0, 0, -30));
        container.setMinSize(1500, 1000);
        container.setBorder(new Border(new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                new CornerRadii(50),
                new BorderWidths(4)
        )));

        AnchorPane.setTopAnchor(container, 40d);
        AnchorPane.setLeftAnchor(container, 210d);

        return container;
    }

    private void createPlayer(GridPane popup, Player player) {
        StackPane balanceContainer;
        Circle playerImage;
        AnchorPane playerContainer;
        Rectangle balanceBackground;
        AnchorPane backgroundContainer;
        Rectangle background;
        Text balance;
        background = new Rectangle(610, 181, Color.BLACK);
        background.setStroke(Color.WHITE);
        background.setStrokeWidth(4);
        background.setArcWidth(100);
        background.setArcHeight(100);

        playerImage = new Circle(100, new ImagePattern(player.getIcon()));
        playerImage.setStroke(Color.rgb(242, 242, 242));
        playerImage.setStrokeWidth(10);
        playerImage.setOnMousePressed(mouse -> {
            Circle node = (Circle) mouse.getPickResult().getIntersectedNode();
            if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                if (selectedPlayer != null) {
                    selectedPlayer.getValue().setStroke(Color.rgb(242, 242, 242));
                }

                node.setStroke(Color.rgb(36, 138, 19));
                selectedPlayer = new Pair<>(player, playerImage);
            }
        });

        backgroundContainer = new AnchorPane(background, playerImage);
        AnchorPane.setLeftAnchor(background, 50d);
        AnchorPane.setLeftAnchor(playerImage, 0d);
        AnchorPane.setTopAnchor(playerImage, -12d);

        balanceBackground = new Rectangle(255, 51, Color.WHITE);
        balanceBackground.setArcWidth(25);
        balanceBackground.setArcHeight(25);
        balance = new Text(player.getBalance() + " €");
        balance.setFont(Font.font("Inter", FontWeight.BOLD, 24));
        balance.setFill(Color.BLACK);
        balanceContainer = new StackPane(balanceBackground, balance);

        playerContainer = new AnchorPane(backgroundContainer, playerImage, balanceContainer);
        AnchorPane.setRightAnchor(balanceContainer, 30d);
        AnchorPane.setBottomAnchor(balanceContainer, 35d);
        AnchorPane.setLeftAnchor(playerContainer, 0d);

        int index = players.indexOf(player);

        if (index > 2) {
            popup.add(playerContainer, 1, Math.abs(4 - index));
        } else {
            popup.add(playerContainer, 0, index);
        }
    }
}
