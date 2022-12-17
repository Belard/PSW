package com.jpmorgan.events;

import com.jpmorgan.model.Player;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

import java.util.List;

public class OpenManagePopupEvent implements EventHandler<MouseEvent> {

    private final AnchorPane anchorPane;

    private final List<Player> players;

    public OpenManagePopupEvent(AnchorPane anchorPane, List<Player> players) {
        this.anchorPane = anchorPane;
        this.players = players;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        GridPane popup = new GridPane();
        AnchorPane playerContainer;
        Rectangle background;
        StackPane balanceContainer;
        Text balance;
        Rectangle balanceBackground;
        Circle playerImage;
        AnchorPane backgroundContainer;

        for (Player player : players) {
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
                    node.setStroke(Color.rgb(36, 138, 19));
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

        popup.setAlignment(Pos.CENTER);

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

        popup.add(tradeButton, 1, 2);
        popup.setVgap(70);
        popup.setHgap(70);
        GridPane.setMargin(popup, new Insets(0, 10, 0, 10));

        StackPane container = new StackPane(popup);
        container.setBackground(new Background(new BackgroundFill(
                Color.BLACK,
                new CornerRadii(50),
                Insets.EMPTY
        )));
        container.setAlignment(Pos.BASELINE_CENTER);
        container.setMinSize(1500, 1000);

        anchorPane.getChildren().add(container);
        AnchorPane.setTopAnchor(container, 40d);
        AnchorPane.setLeftAnchor(container, 210d);
    }


}
