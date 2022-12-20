package com.jpmorgan.Popups;

import com.jpmorgan.GameManager;
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

import java.io.InputStream;
import java.util.Objects;

public class TradingPopup extends Popup {

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

    private final Player selectedPlayer;

    public TradingPopup(AnchorPane anchorPane, Player selectedPlayer) {
        super(anchorPane);
        this.selectedPlayer = selectedPlayer;
    }

    @Override
    protected Node createContent() {
        Image closeImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(IMAGES_DIRECTORY + "cross.png")));

        Circle closeButton = new Circle(36);
        closeButton.setFill(new ImagePattern(closeImage));
        closeButton.addEventHandler(MouseEvent.MOUSE_PRESSED, mouse -> closePopup());

        Player playerSelf = GameManager.getInstance().getPlayerSelf();

        GridPane playerSelfProperties = createPropertiesForPlayer(playerSelf, new Insets(-15, 95, 0, 0),
                new Insets(15, 95, 0, 0), Pos.TOP_RIGHT);
        GridPane otherPlayerProperties = createPropertiesForPlayer(selectedPlayer, new Insets(-15, 0, 0, 95),
                new Insets(15, 0, 0, 95), Pos.TOP_LEFT);

        Button proposeButton = createProposeButton();

        StackPane propertyDisplay = createPropertyDisplay();

        StackPane container = new StackPane(playerSelfProperties, otherPlayerProperties, proposeButton,
                propertyDisplay, closeButton);
        container.setBackground(new Background(new BackgroundFill(
                Color.BLACK,
                new CornerRadii(50),
                Insets.EMPTY
        )));
        StackPane.setAlignment(container, Pos.BASELINE_CENTER);
        StackPane.setAlignment(proposeButton, Pos.CENTER);
        StackPane.setMargin(proposeButton, new Insets(80, 0, 0, 0));
        StackPane.setAlignment(propertyDisplay, Pos.TOP_CENTER);
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

    private StackPane createPropertyDisplay() {
        Rectangle background = new Rectangle(290, 290, Color.rgb(242, 242, 242));
        background.setArcHeight(50);
        background.setArcWidth(50);

        StackPane container = new StackPane(background);
        container.setMaxSize(300, 300);
        StackPane.setAlignment(background, Pos.TOP_CENTER);
        StackPane.setMargin(background, new Insets(90, 0, 0, 0));

        return container;
    }

    private Button createProposeButton() {
        Button proposeButton = new Button("PROPOR");
        proposeButton.setMinSize(340, 125);
        proposeButton.setTextFill(Color.WHITE);
        proposeButton.setFont(Font.font(
                "Inter",
                FontWeight.BOLD,
                48
        ));
        proposeButton.setBackground(new Background(new BackgroundFill(
                Color.BLACK,
                new CornerRadii(50),
                Insets.EMPTY
        )));
        proposeButton.setBorder(new Border(new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                new CornerRadii(50),
                new BorderWidths(4)
        )));
        proposeButton.setOnMouseEntered(mouseEvent -> {
            proposeButton.setTextFill(Color.BLACK);
            proposeButton.setBackground(new Background(new BackgroundFill(
                    Color.WHITE,
                    new CornerRadii(50),
                    Insets.EMPTY
            )));
        });
        proposeButton.setOnMouseExited(mouseEvent -> {
            proposeButton.setTextFill(Color.WHITE);
            proposeButton.setBackground(new Background(new BackgroundFill(
                    Color.BLACK,
                    new CornerRadii(50),
                    Insets.EMPTY
            )));
        });
        return proposeButton;
    }

    private GridPane createPropertiesForPlayer(Player player, Insets propertiesInsets, Insets playerInsets,
                                               Pos containerPos) {
        GridPane propertiesGrid = new GridPane();

        for (int i = 0; i < 5; i++) {
            createPropertyRectangle(i, 0, i, propertiesGrid);
        }

        for (int i = 0; i < 5; i++) {
            createPropertyRectangle(i + 5, 1, i, propertiesGrid);
        }

        Rectangle propertyBackground = new Rectangle(195, 56, Color.WHITE);
        propertyBackground.setArcHeight(60);
        propertyBackground.setArcWidth(60);
        GridPane.setHalignment(propertyBackground, HPos.CENTER);

        Text playerSelfBalance = new Text(player.getBalance() + " €");
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
        propertiesGrid.setMinSize(290, 465);
        propertiesGrid.setMaxSize(290, 465);

        Circle playerCircle = new Circle(45, new ImagePattern(player.getIcon()));

        GridPane container = new GridPane();
        container.add(propertiesGrid, 0, 1);
        container.add(playerCircle, 0, 0);
        container.setAlignment(containerPos);
        GridPane.setHalignment(playerCircle, HPos.CENTER);
        GridPane.setMargin(propertiesGrid, propertiesInsets);
        GridPane.setMargin(playerCircle, playerInsets);

        return container;
    }

    private void createPropertyRectangle(int imageIndex, int columnIndex, int rowIndex, GridPane propertiesGrid) {
        Rectangle propertyBackground = new Rectangle(109, 56, Color.WHITE);
        propertyBackground.setStrokeWidth(7);
        propertyBackground.setStroke(propertiesBorderColors[imageIndex]);
        propertyBackground.setArcHeight(50);
        propertyBackground.setArcWidth(50);

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
}
