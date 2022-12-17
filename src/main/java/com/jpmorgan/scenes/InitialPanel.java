package com.jpmorgan.scenes;

import java.io.InputStream;

import com.jpmorgan.SceneManager;


import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.application.Platform;


public class InitialPanel {

    public AnchorPane start() {
      //creating label email 
      Label text1 = new Label("J P Morgan");       
             
      //Creating Buttons 
      Button button1 = new Button("START"); 
      Button button2 = new Button("EXIT");  
      
      //Creating a Grid Pane 
      AnchorPane anchorPane = new AnchorPane(); 
      
      //Setting size for the pane 
      anchorPane.setMinSize(1920, 1080);

      //Setting the padding              

      AnchorPane.setTopAnchor(text1, 95.0);
      AnchorPane.setLeftAnchor(text1, 620.0);
      AnchorPane.setTopAnchor(button1, 471.0);
      AnchorPane.setLeftAnchor(button1, 505.0);
      AnchorPane.setTopAnchor(button2, 846.0);
      AnchorPane.setLeftAnchor(button2, 748.0);
      

      button1.setMinSize(910, 225);
      button2.setMinSize(424, 151);
      

      //Arranging all the nodes in the grid 
      anchorPane.getChildren().add(text1);
      anchorPane.getChildren().add(button1); 
      anchorPane.getChildren().add(button2);

 
       
      //Styling nodes  
      button1.getStyleClass().add("rectangle28"); 
      button2.getStyleClass().add("rectangle29");

      button1.setOnAction(e -> display());
      button2.setOnAction((ActionEvent event) -> {Platform.exit();});
       
      text1.getStyleClass().add("jPMorgan"); 
      anchorPane.getStyleClass().add("root"); 
       
     
      return anchorPane;
    }
    
    public void display() {
        Popup pp = new Popup();
        pp.setAutoHide(true);
        pp.setAutoFix(true);

        AnchorPane anchorPane = new AnchorPane();
        
        //Map<String, Node> nodes = new HashMap<>();

        anchorPane.setMinWidth(728);
        anchorPane.setMinHeight(1000);

        //Creating Label
        Label players = new Label("Jogadores:");
        players.setAlignment(Pos.CENTER);
        Label rules = new Label("Regras:");
        rules.setAlignment(Pos.CENTER);
        Label privatee = new Label("AI Player:");
        privatee.setAlignment(Pos.CENTER);

        //Creating Options
        TextField playersInsert = new TextField();
        playersInsert.setAlignment(Pos.CENTER);
        playersInsert.setMinSize(167, 86);
        playersInsert.setMaxSize(167, 86);
        final ComboBox<String> ruleComboBox = new ComboBox<>();
        ruleComboBox.getItems().addAll(
            "Regra 1",
            "Regra 2",
            "Regra 3",
            "Regra 4",
            "Regra Burro"  
        );
        ruleComboBox.setMinSize(350, 86);
        SwitchButton switchButton = new SwitchButton();

        //Creating Start Button
        Button startButton = new Button("START");
        startButton.setMinSize(151, 80);
        Button exitButton = new Button();
        exitButton.setMinSize(72, 72);
        InputStream imageISExitBtn = getClass().getResourceAsStream("/com/jpmorgan/images/cross.png");
        Image imageExitBtn = new Image(imageISExitBtn);
        ImageView imageExitBtnView = new ImageView(imageExitBtn);
        imageExitBtnView.setFitHeight(72);
        imageExitBtnView.setFitWidth(72);
        exitButton.setGraphic(imageExitBtnView);


        anchorPane.getStyleClass().add("rectangle36");
        players.getStyleClass().add("jogadores");
        rules.getStyleClass().add("regras");
        privatee.getStyleClass().add("privadoPOP");
        playersInsert.getStyleClass().add("rectangle32");
        ruleComboBox.getStyleClass().add("comboBox");
        startButton.getStyleClass().add("rectangle33");
        exitButton.getStyleClass().add("ellipse8");


        AnchorPane.setTopAnchor(players, 50.0);
        AnchorPane.setLeftAnchor(players, 60.0);
        AnchorPane.setTopAnchor(playersInsert, 60.0);
        AnchorPane.setLeftAnchor(playersInsert, 450.0);
        AnchorPane.setTopAnchor(rules, 300.0);
        AnchorPane.setLeftAnchor(rules, 60.0);
        AnchorPane.setTopAnchor(privatee, 550.0);
        AnchorPane.setLeftAnchor(privatee, 60.0);
        AnchorPane.setTopAnchor(ruleComboBox, 305.0);
        AnchorPane.setLeftAnchor(ruleComboBox, 320.0);
        AnchorPane.setTopAnchor(switchButton, 537.0);
        AnchorPane.setLeftAnchor(switchButton, 390.0);
        AnchorPane.setTopAnchor(startButton, 870.0);
        AnchorPane.setLeftAnchor(startButton, 530.0);
        AnchorPane.setTopAnchor(exitButton, -30.0);
        AnchorPane.setLeftAnchor(exitButton, -40.0);


        anchorPane.getChildren().add(players);
        anchorPane.getChildren().add(rules);
        anchorPane.getChildren().add(privatee);
        anchorPane.getChildren().add(playersInsert);
        anchorPane.getChildren().add(ruleComboBox);
        anchorPane.getChildren().add(switchButton);
        anchorPane.getChildren().add(startButton);
        anchorPane.getChildren().add(exitButton);

        exitButton.setOnAction(e -> pp.hide());
        startButton.setOnAction(e -> startGame(pp));


        pp.getContent().add(anchorPane);


        pp.show(SceneManager.getInstance().getPrimaryStage());
    
    }
    
    private void startGame(Popup pp) {
    	//verificar dados inseridos
    	pp.hide();
    	SceneManager.getInstance().changeScene("gamePanel");
    };
    
    static public class SwitchButton extends StackPane {
        private final Rectangle back = new Rectangle(258, 86, Color.RED);
        private final Button button = new Button();
        private String buttonStyleOff = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 0.2, 0.0, 0.0, 2); -fx-background-color: WHITE;";
        private String buttonStyleOn = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 0.2, 0.0, 0.0, 2); -fx-background-color: #00893d;";
        private boolean state;

        private void init() {
            getChildren().addAll(back, button);
            setMinSize(258, 126);
            back.maxWidth(258);
            back.minWidth(258);
            back.maxHeight(86);
            back.minHeight(86);
            back.setArcHeight(back.getHeight());
            back.setArcWidth(back.getHeight());
            back.setFill(Color.valueOf("#ced5da"));
            Double r = 2.0;
            button.setShape(new Circle(r));
            setAlignment(button, Pos.CENTER_LEFT);
            button.setMaxSize(86, 86);
            button.setMinSize(86, 86);
            button.setStyle(buttonStyleOff);
        }

        public SwitchButton() {
            init();
            EventHandler<Event> click = new EventHandler<Event>() {
                @Override
                public void handle(Event e) {
                    if (state) {
                        button.setStyle(buttonStyleOff);
                        back.setFill(Color.valueOf("#ced5da"));
                        setAlignment(button, Pos.CENTER_LEFT);
                        state = false;
                    } else {
                        button.setStyle(buttonStyleOn);
                        back.setFill(Color.valueOf("#80C49E"));
                        setAlignment(button, Pos.CENTER_RIGHT);
                        state = true;
                    }
                }
            };

            button.setFocusTraversable(false);
            setOnMouseClicked(click);
            button.setOnMouseClicked(click);
        }

        }
        

}
