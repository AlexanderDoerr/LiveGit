package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button btnHello;
    @FXML
    private Button btnClickCount;
    int counter = 0;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        btnHello.setText("Done!");
    }

    @FXML
    protected void onClickCounter(){
        btnClickCount.setText("" + counter++);
    }
}