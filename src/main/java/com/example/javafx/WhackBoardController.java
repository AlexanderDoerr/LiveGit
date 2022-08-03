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
    private String moleUp = "file:/C:/Users/Alexander%20Doerr/Neumont%20School%20Folder/Q4/CSC180/JavaFX/src/main/resources/com/example/javafx/MoleUp.PNG";
    private String moleDown = "file:/C:/Users/Alexander%20Doerr/Neumont%20School%20Folder/Q4/CSC180/JavaFX/src/main/resources/com/example/javafx/MoleDown.PNG";
    private ImageView imageUp = new ImageView(moleUp);
    private ImageView imageDown = new ImageView(moleDown);


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

    private ImageView[][] images = { {img00, img01, img02}, {img10, img11, img12}, {img20, img21, img22} };
    Random rand = new Random();

    @FXML
    void imgClicked(MouseEvent event) throws FileNotFoundException
    {
        try {
            ImageView source = (ImageView) event.getSource();
            System.out.println(source.getImage().getUrl());// this grabs the image location and maybe able to just compare to see if its up or down


            InputStream stream = new FileInputStream("src\\main\\resources\\com\\example\\javafx\\MoleUp.png");
            Image image = new Image(moleUp);
            img22.setImage(image);
            // compare the image to the source like image up or down
            //You might need to set a path for up and down so everytime you change the picture you change it to the original path
            Random rand = new Random();
            int intRandom = rand.nextInt(3);
            System.out.println("Random num: " + intRandom);


//            System.out.println(event.getTarget());
            //img00.setId("Up");// You might be able to use this so you can always
//            System.out.println(img00.getId());

        } catch (Exception e) {
            e.printStackTrace();
            //event.getSource();
        }

    }

    public void moleMovement(Image up, Image down)
    {
//        int intRandom = rand.nextInt(3);

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
                System.out.println(images[i][j] + "\n");
            }
        }
    }


//    @FXML
//    void img00_Clicked(MouseEvent event) throws FileNotFoundException {
//
//        try {
//            InputStream stream = new FileInputStream("src\\main\\resources\\com\\example\\javafx\\MoleUp.png");
//            Image image = new Image(stream);
//            img00.setImage(image);
//            ImageView source = (ImageView) event.getSource();
//            System.out.println(source.getImage().getUrl());// this grabs the image location and maybe able to just compare to see if its up or down
//            // compare the image to the source like image up or down
//            //You might need to set a path for up and down so everytime you change the picture you change it to the original path
//            Random rand = new Random();
//            int intRandom = rand.nextInt(3);
//            System.out.println("Random num: " + intRandom);
//
//            System.out.println(event.getTarget());
//            //img00.setId("Up");// You might be able to use this so you can always
//            System.out.println(img00.getId());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            //event.getSource();
//        }
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image imageUp = new Image(moleUp);
        Image imageDown = new Image(moleDown);

//        molesDown(imageDown);

        Timer t = new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
//                molesDown(imageDown);
//                moleMovement(imageUp, imageDown);
                //This is where you put your methods to swap the moles for every 2 seconds
                System.out.println("Timer ticked " + new Date() );
            }
        };
        t.schedule(task, new Date(), 2000);

    }

    public void molesDown(Image down)
    {
        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j < images[i].length; j++) {
                //img00.setImage(down); this works just not in the array
                images[i][j].setImage(down);
            }

        }
    }
}
