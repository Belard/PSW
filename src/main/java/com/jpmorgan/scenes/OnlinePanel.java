package com.jpmorgan.scenes;

import com.jpmorgan.SceneManager;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Modality;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import scala.util.Random;




public class OnlinePanel {
	
    public AnchorPane start() {
      //creating label email 
      TextField insertName = new TextField();
      insertName.setAlignment(Pos.CENTER);
      TextField insertCode = new TextField();
      insertCode.setAlignment(Pos.CENTER);       

      //Creating Buttons
      Button createGameButton = new Button("Criar jogo");
      Button searchGameButton = new Button("Procurar jogo");
      Button privateGameButton = new Button();
      Button backButton = new Button("BACK"); 
      
      //Creating Rectangles
      Rectangle hostRect = new Rectangle();
      Rectangle privateRect = new Rectangle();
      Rectangle publicRect = new Rectangle();


      //Creating Label
      Label hostLabel = new Label("Anfitrião");
      hostLabel.setAlignment(Pos.CENTER);
      Label privateLabel = new Label("Publico");
      privateLabel.setAlignment(Pos.CENTER); 
      Label publicLabel = new Label("Privado");
      publicLabel.setAlignment(Pos.CENTER);
      
      //Creating Circle
      Circle hostCircle = new Circle();
      InputStream imageISHostCircle = getClass().getResourceAsStream("/com/jpmorgan/images/nounMonopolyShoe3315162.png");
      Image imageHostCircle = new Image(imageISHostCircle);
      hostCircle.setFill(new ImagePattern(imageHostCircle));
      Circle privateCircle = new Circle();
      InputStream imageISPrivateCircle = getClass().getResourceAsStream("/com/jpmorgan/images/nounMonopolyShoe3315163.png");
      Image imagePrivateCircle = new Image(imageISPrivateCircle);
      privateCircle.setFill(new ImagePattern(imagePrivateCircle));
      Circle publicCircle = new Circle();
      InputStream imageISPublicCircle = getClass().getResourceAsStream("/com/jpmorgan/images/nounMonopolyShoe33151622.png");
      Image imagePublicCircle = new Image(imageISPublicCircle);
      publicCircle.setFill(new ImagePattern(imagePublicCircle));

      //Creating a Grid Pane 
      AnchorPane anchorPane = new AnchorPane(); 
      
      //Setting size for the pane 
      anchorPane.setMinSize(1920, 1080);

      //Setting the padding              

      AnchorPane.setTopAnchor(backButton, 979.0);
      AnchorPane.setLeftAnchor(backButton, 12.0);
      AnchorPane.setTopAnchor(insertName, 23.0);
      AnchorPane.setLeftAnchor(insertName, 614.0);
      //Host
      AnchorPane.setTopAnchor(hostRect, 322.0);
      AnchorPane.setLeftAnchor(hostRect, 751.0);
      AnchorPane.setTopAnchor(hostLabel, 264.0);
      AnchorPane.setLeftAnchor(hostLabel, 840.0);
      AnchorPane.setTopAnchor(hostCircle, 220.0);
      AnchorPane.setLeftAnchor(hostCircle, 609.0);
      AnchorPane.setTopAnchor(createGameButton, 336.0);
      AnchorPane.setLeftAnchor(createGameButton, 1039.0);       
      //Private
      AnchorPane.setTopAnchor(privateRect, 590.0);
      AnchorPane.setLeftAnchor(privateRect, 751.0);
      AnchorPane.setTopAnchor(privateLabel, 532.0);
      AnchorPane.setLeftAnchor(privateLabel, 840.0);
      AnchorPane.setTopAnchor(privateCircle, 488.0);
      AnchorPane.setLeftAnchor(privateCircle, 609.0);
      AnchorPane.setTopAnchor(searchGameButton, 604.0);
      AnchorPane.setLeftAnchor(searchGameButton, 1039.0);    
      //Public
      AnchorPane.setTopAnchor(publicRect, 879.0);
      AnchorPane.setLeftAnchor(publicRect, 751.0);
      AnchorPane.setTopAnchor(publicLabel, 821.0);
      AnchorPane.setLeftAnchor(publicLabel, 840.0);
      AnchorPane.setTopAnchor(publicCircle, 777.0);
      AnchorPane.setLeftAnchor(publicCircle, 609.0);
      AnchorPane.setTopAnchor(privateGameButton, 894.0);
      AnchorPane.setLeftAnchor(privateGameButton, 1236.0);
      AnchorPane.setTopAnchor(insertCode, 893.0);
      AnchorPane.setLeftAnchor(insertCode, 877.0);   
      

      backButton.setMinSize(151, 80);
      insertName.setMinSize(751, 132);
      //Host
      hostRect.setWidth(553);
      hostRect.setHeight(27);
      hostRect.setArcWidth(30.0); 
      hostRect.setArcHeight(30.0);
      hostLabel.setMinSize(184, 58);
      hostCircle.setRadius(102);
      insertCode.setMinSize(268, 58);
      insertCode.setMaxSize(268, 58);
      createGameButton.setMinSize(265,58);
      //Private
      privateRect.setWidth(553);
      privateRect.setHeight(27);
      privateRect.setArcWidth(30.0); 
      privateRect.setArcHeight(30.0);
      privateLabel.setMinSize(184, 58);
      privateCircle.setRadius(102);
      searchGameButton.setMinSize(265,58);

      //Public
      publicRect.setWidth(553);
      publicRect.setHeight(27);
      publicRect.setArcWidth(30.0); 
      publicRect.setArcHeight(30.0);
      publicLabel.setMinSize(184, 58);
      publicCircle.setRadius(102);
      privateGameButton.setMinSize(66,58);
      InputStream imageISPrivateBtn = getClass().getResourceAsStream("/com/jpmorgan/images/nounArrow23357251.png");
      Image imagePrivateBtn = new Image(imageISPrivateBtn);
      ImageView imagePrivateBtnView = new ImageView(imagePrivateBtn);
      privateGameButton.setGraphic(imagePrivateBtnView);


      //Arranging all the nodes in the grid 
      anchorPane.getChildren().add(backButton); 
      anchorPane.getChildren().add(insertName);
      anchorPane.getChildren().add(hostRect);
      anchorPane.getChildren().add(hostLabel);
      anchorPane.getChildren().add(hostCircle);
      anchorPane.getChildren().add(privateRect);
      anchorPane.getChildren().add(privateLabel);
      anchorPane.getChildren().add(privateCircle);
      anchorPane.getChildren().add(publicRect);
      anchorPane.getChildren().add(publicLabel);
      anchorPane.getChildren().add(publicCircle);
      anchorPane.getChildren().add(createGameButton);
      anchorPane.getChildren().add(searchGameButton);
      anchorPane.getChildren().add(privateGameButton);
      anchorPane.getChildren().add(insertCode);
      
      //Styling nodes
      createGameButton.getStyleClass().add("rectangle5");  
      searchGameButton.getStyleClass().add("rectangle8");  
      privateGameButton.getStyleClass().add("rectangle11");  
      backButton.getStyleClass().add("rectangle31");
      insertName.getStyleClass().add("rectangle30");
      hostLabel.getStyleClass().add("anfitriao");
      hostCircle.getStyleClass().add("ellipse2");
      privateLabel.getStyleClass().add("privado");
      publicLabel.getStyleClass().add("publico");
      anchorPane.getStyleClass().add("root");
      insertCode.getStyleClass().add("rectangle13");
      
      backButton.setOnAction(e -> SceneManager.getInstance().changeScene("initialPanel"));
      createGameButton.setOnAction(e -> display()); 

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
      Label privatee = new Label("Privado:");
      privatee.setAlignment(Pos.CENTER);

      //Creating Options
      TextField playersInsert = new TextField();
      playersInsert.setAlignment(Pos.CENTER);
      playersInsert.setMinSize(167, 86);
      playersInsert.setMaxSize(167, 86);
      TextField codeInsert = new TextField();
      codeInsert.setAlignment(Pos.CENTER);
      codeInsert.setMinSize(345, 86);
      codeInsert.setMaxSize(345, 86);
      codeInsert.setText(connectionString());
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
      codeInsert.getStyleClass().add("rectangle37");
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
      AnchorPane.setLeftAnchor(switchButton, 380.0);
      AnchorPane.setTopAnchor(codeInsert, 700.0);
      AnchorPane.setLeftAnchor(codeInsert, 200.0);
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
      anchorPane.getChildren().add(codeInsert);
      anchorPane.getChildren().add(exitButton);

      exitButton.setOnAction(e -> pp.hide()); 


      pp.getContent().add(anchorPane);


      pp.show(SceneManager.getInstance().getPrimaryStage());
        
  }

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
    public String connectionString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
    
        return generatedString;
    }

}
