package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class WhackBoardController implements Initializable {

    //private boolean[][] aryUp= {{false, false, false}, {false, false, false,}, {false, false, false}};
    private final String moleUp = "file:/C:/Users/Alexander%20Doerr/Neumont%20School%20Folder/Q4/CSC180/JavaFX/src/main/resources/com/example/javafx/MoleUp.PNG";
    private final String moleDown = "file:/C:/Users/Alexander%20Doerr/Neumont%20School%20Folder/Q4/CSC180/JavaFX/src/main/resources/com/example/javafx/MoleDown.PNG";
    private final String moleWhack = "file:/C:/Users/Alexander%20Doerr/Neumont%20School%20Folder/Q4/CSC180/JavaFX/src/main/resources/com/example/javafx/MoleWhack.jpg";

    @FXML
    private ImageView img00;

    @FXML
    private ImageView img01;

    @FXML
    private ImageView img02;

    @FXML
    private ImageView img10;

    @FXML
    private ImageView img11;

    @FXML
    private ImageView img12;

    @FXML
    private ImageView img20;

    @FXML
    private ImageView img21;

    @FXML
    private ImageView img22;


    Random rand = new Random();

    @FXML
    void imgClicked(MouseEvent event) throws FileNotFoundException
    {
        try {
            ImageView source = (ImageView) event.getSource();
            ImageView tempImg = (ImageView) event.getTarget();
            System.out.println(source.getImage().getUrl());// this grabs the image location and maybe able to just compare to see if its up or down

            Image image = new Image(moleWhack);

            if (moleUp.equals(source.getImage().getUrl()))
            {
                (tempImg).setImage(image);
            }
        } catch (Exception e)
            {
                e.printStackTrace();
            }
    }

    public void moleMovement(ImageView[][] images, Image up, Image down)
    {
        for (int i = 0; i < images.length; i++)
        {

            for (int j = 0; j < images[i].length; j++) {
                int intRandom = rand.nextInt(2);
                switch (intRandom)
                {
                    case 0: images[i][j].setImage(up);
                    break;
                    case 1: images[i][j].setImage(down);
                    break;
                    default:
                        System.out.println("Somthing went wrong at moleMovement");
                }
                //System.out.println(images[i][j] + "\n");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView[][] images = { {this.img00, this.img01, this.img02}, {this.img10, this.img11, this.img12}, {this.img20, this.img21, this.img22} };

        Image imageUp = new Image(moleUp);
        Image imageDown = new Image(moleDown);

        Timer t = new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                moleMovement(images, imageUp, imageDown);
                //System.out.println("Timer ticked " + new Date() );
            }
        };
        t.schedule(task, new Date(), 1000);

    }
}
