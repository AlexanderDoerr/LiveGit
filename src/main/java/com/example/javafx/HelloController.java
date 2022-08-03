package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    //This is me adding in a new line of code for the github assignment!

    @FXML
    private Button btnHello;
//    @FXML
//    private Button btnClickCount;
//    int counter = 0;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");
        btnHello.setText("Done!");
        ChangeScene.changeScene(event, "whackmole-view.fxml");
    }

//    @FXML
//    protected void onClickCounter(){
//        btnClickCount.setText("" + counter++);
//    }
}