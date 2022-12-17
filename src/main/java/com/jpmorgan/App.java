package com.jpmorgan;

import javafx.application.Application; 
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application { 
   @Override 
   public void start(Stage stage) {
      try {
         GameManager.getInstance().init();
         SceneManager.getInstance().initScene(stage);
      } catch (Exception e) {
         System.err.println(e.getMessage());
         throw new RuntimeException(e);
      }
   }

   public static void main(String args[]){ 
      launch(args); 
   } 
} 