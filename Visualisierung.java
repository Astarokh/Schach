import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.ColumnConstraints;

public class Visualisierung extends Application {

    public int clickzaehler = 0;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {                                //throws FileNotFoundException      noetig in Kombination mit dem import der import java.io.FileNotFoundException;

        GridPane root = new GridPane();

        root.setVgap(2);
        root.setHgap(2);
        //root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(1, 1, 1, 1));            //padding
        root.setMinSize(800, 800);
        //root.setGridLinesVisible(true);
        root.setStyle("-fx-background-color: grey");

        Rectangle[] schachfeld = new Rectangle[64];

        TextField startFeld = new TextField("Start-Koordinaten eingeben");
        TextField zielFeld = new TextField("Ziel-Koordinaten eingeben");
        Button bestaetigen = new Button("Eingabe bestaetigen");
        Button testButton = new Button("Move it!");
        Button testButton2 = new Button("and back!");


        //Rectangle feldBuchstabeA = new Rectangle(100, 100);
        //feldBuchstabeA.setFill(Color.WHITE);
        //Rectangle feldBuchstabeB = new Rectangle(100, 100);
        //feldBuchstabeB.setFill(Color.BLACK);
        //Rectangle buchstabeA2 = RectangleBuilder.create().height(100).width(100).styleClass("Koordinaten").build();


        Text buchstabeA = new Text();
        buchstabeA.setText("A");
        //buchstabeA.setFont(Font.font("Courier", 45));
        buchstabeA.setFill(Color.BLACK);
        //buchstabeA.getStyleClass().add("buchstaben");
        buchstabeA.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        //buchstabeA.setTextAlignment(TextAlignment.CENTER);
        //buchstabeA.setTextOrigin(VPos.CENTER);
        buchstabeA.setWrappingWidth(100);


        Text buchstabeB = new Text();
        buchstabeB.setText("B");
        buchstabeB.setFill(Color.BLACK);
        buchstabeB.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        //buchstabeA.setTextAlignment(TextAlignment.CENTER);
        buchstabeB.setWrappingWidth(100);

        Text buchstabeC = new Text();
        buchstabeC.setText("C");
        buchstabeC.setFill(Color.BLACK);
        buchstabeC.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeC.setWrappingWidth(100);

        Text buchstabeD = new Text();
        buchstabeD.setText("D");
        buchstabeD.setFill(Color.BLACK);
        buchstabeD.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeD.setWrappingWidth(100);

        Text buchstabeE = new Text();
        buchstabeE.setText("E");
        buchstabeE.setFill(Color.BLACK);
        buchstabeE.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeE.setWrappingWidth(100);

        Text buchstabeF = new Text();
        buchstabeF.setText("F");
        buchstabeF.setFill(Color.BLACK);
        buchstabeF.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeF.setWrappingWidth(100);

        Text buchstabeG = new Text();
        buchstabeG.setText("G");
        buchstabeG.setFill(Color.BLACK);
        buchstabeG.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeG.setWrappingWidth(100);

        Text buchstabeH = new Text();
        buchstabeH.setText("H");
        buchstabeH.setFill(Color.BLACK);
        buchstabeH.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeH.setWrappingWidth(100);

        //root.add(feldBuchstabeA, 1, 0);
        //root.add(feldBuchstabeB, 2, 0);

        root.add(buchstabeA, 1, 0);
        root.add(buchstabeB, 2, 0);
        root.add(buchstabeC, 3, 0);
        root.add(buchstabeD, 4, 0);
        root.add(buchstabeE, 5, 0);
        root.add(buchstabeF, 6, 0);
        root.add(buchstabeG, 7, 0);
        root.add(buchstabeH, 8, 0);

        Text buchstabeA1 = new Text();
        buchstabeA1.setText("A");
        buchstabeA1.setFill(Color.BLACK);
        buchstabeA1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeA1.setWrappingWidth(100);

        Text buchstabeB1 = new Text();
        buchstabeB1.setText("B");
        buchstabeB1.setFill(Color.BLACK);
        buchstabeB1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeB1.setWrappingWidth(100);

        Text buchstabeC1 = new Text();
        buchstabeC1.setText("C");
        buchstabeC1.setFill(Color.BLACK);
        buchstabeC1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeC1.setWrappingWidth(100);

        Text buchstabeD1 = new Text();
        buchstabeD1.setText("D");
        buchstabeD1.setFill(Color.BLACK);
        buchstabeD1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeD1.setWrappingWidth(100);

        Text buchstabeE1 = new Text();
        buchstabeE1.setText("E");
        buchstabeE1.setFill(Color.BLACK);
        buchstabeE1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeE1.setWrappingWidth(100);

        Text buchstabeF1 = new Text();
        buchstabeF1.setText("F");
        buchstabeF1.setFill(Color.BLACK);
        buchstabeF1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeF1.setWrappingWidth(100);

        Text buchstabeG1 = new Text();
        buchstabeG1.setText("G");
        buchstabeG1.setFill(Color.BLACK);
        buchstabeG1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeG1.setWrappingWidth(100);

        Text buchstabeH1 = new Text();
        buchstabeH1.setText("H");
        buchstabeH1.setFill(Color.BLACK);
        buchstabeH1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        buchstabeH1.setWrappingWidth(100);

        root.add(buchstabeA1, 1, 9);
        root.add(buchstabeB1, 2, 9);
        root.add(buchstabeC1, 3, 9);
        root.add(buchstabeD1, 4, 9);
        root.add(buchstabeE1, 5, 9);
        root.add(buchstabeF1, 6, 9);
        root.add(buchstabeG1, 7, 9);
        root.add(buchstabeH1, 8, 9);

        Text zahl1 = new Text();
        zahl1.setText("1");
        zahl1.setFill(Color.BLACK);
        zahl1.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl1.setWrappingWidth(80);

        Text zahl2 = new Text();
        zahl2.setText("2");
        zahl2.setFill(Color.BLACK);
        zahl2.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl2.setWrappingWidth(80);

        Text zahl3 = new Text();
        zahl3.setText("3");
        zahl3.setFill(Color.BLACK);
        zahl3.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl3.setWrappingWidth(80);

        Text zahl4 = new Text();
        zahl4.setText("4");
        zahl4.setFill(Color.BLACK);
        zahl4.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl4.setWrappingWidth(80);

        Text zahl5 = new Text();
        zahl5.setText("5");
        zahl5.setFill(Color.BLACK);
        zahl5.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl5.setWrappingWidth(80);

        Text zahl6 = new Text();
        zahl6.setText("6");
        zahl6.setFill(Color.BLACK);
        zahl6.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl6.setWrappingWidth(80);

        Text zahl7 = new Text();
        zahl7.setText("7");
        zahl7.setFill(Color.BLACK);
        zahl7.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl7.setWrappingWidth(80);

        Text zahl8 = new Text();
        zahl8.setText("8");
        zahl8.setFill(Color.BLACK);
        zahl8.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl8.setWrappingWidth(80);

        root.add(zahl1, 0, 1);
        root.add(zahl2, 0, 2);
        root.add(zahl3, 0, 3);
        root.add(zahl4, 0, 4);
        root.add(zahl5, 0, 5);
        root.add(zahl6, 0, 6);
        root.add(zahl7, 0, 7);
        root.add(zahl8, 0, 8);

        Text zahl11 = new Text();
        zahl11.setText("1");
        zahl11.setFill(Color.BLACK);
        zahl11.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl11.setWrappingWidth(80);

        Text zahl21 = new Text();
        zahl21.setText("2");
        zahl21.setFill(Color.BLACK);
        zahl21.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl21.setWrappingWidth(80);

        Text zahl31 = new Text();
        zahl31.setText("3");
        zahl31.setFill(Color.BLACK);
        zahl31.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl31.setWrappingWidth(80);

        Text zahl41 = new Text();
        zahl41.setText("4");
        zahl41.setFill(Color.BLACK);
        zahl41.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl41.setWrappingWidth(80);

        Text zahl51 = new Text();
        zahl51.setText("5");
        zahl51.setFill(Color.BLACK);
        zahl51.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl51.setWrappingWidth(80);

        Text zahl61 = new Text();
        zahl61.setText("6");
        zahl61.setFill(Color.BLACK);
        zahl61.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl61.setWrappingWidth(80);

        Text zahl71 = new Text();
        zahl71.setText("7");
        zahl71.setFill(Color.BLACK);
        zahl71.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl71.setWrappingWidth(80);

        Text zahl81 = new Text();
        zahl81.setText("8");
        zahl81.setFill(Color.BLACK);
        zahl81.setStyle("-fx-font-family: Courier; -fx-font-size: 50pt; -fx-stroke: white; -fx-stroke-width: 2");
        zahl81.setWrappingWidth(80);

        root.add(zahl11, 9, 1);
        root.add(zahl21, 9, 2);
        root.add(zahl31, 9, 3);
        root.add(zahl41, 9, 4);
        root.add(zahl51, 9, 5);
        root.add(zahl61, 9, 6);
        root.add(zahl71, 9, 7);
        root.add(zahl81, 9, 8);

        root.add(startFeld, 15, 4);
        root.add(zielFeld, 15, 5);
        root.add(bestaetigen, 15, 6);
        root.add(testButton, 15, 8);
        root.add(testButton2, 15, 9);


        Image image = new Image(new FileInputStream("C:\\Users\\Administrator\\Pictures\\YinYang.jpeg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);

        Image image2 = new Image(new FileInputStream("C:\\Users\\Administrator\\Pictures\\YinYang.jpeg"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(80);
        imageView2.setFitWidth(80);

        Image image3 = new Image(new FileInputStream("C:\\Users\\Administrator\\Pictures\\YinYang.jpeg"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(80);
        imageView3.setFitWidth(80);

        Image image4 = new Image(new FileInputStream("C:\\Users\\Administrator\\Pictures\\YinYang.jpeg"));
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitHeight(80);
        imageView4.setFitWidth(80);

        //Image image5 = new Image(new FileInputStream("C:\\Users\\Administrator\\Pictures\\Pferd.jpeg"));
        //ImageView imageView5 = new ImageView(image5);
        //imageView5.setFitHeight(80);
        //imageView5.setFitWidth(80);

        root.add(imageView, 0, 0);
        root.add(imageView2, 9, 0);
        root.add(imageView3, 0, 9);
        root.add(imageView4, 9, 9);


        for (int i = 0; i < 64;) {
            for (int j = 1; j < 9; j++) {
                for (int k = 1; k < 9; k++) {

                    //if (j == 0 || j == 9) {
                    //    root.add(imageView, k, j);
                    //}
                    //else {

                    schachfeld[i] = new Rectangle(100, 100);

                    if ((j + k) % 2 == 0) {
                        schachfeld[i].setFill(Color.BLACK);
                    }
                    else {
                        schachfeld[i].setFill(Color.WHITE);
                    }
                    schachfeld[i].setStyle("-fx-border: 1");
                    root.add(schachfeld[i], k, j);
                    i++;
                    //}
                }
            }
        }

        //root.setAlignment(Pos.CENTER);

        buchstabeA.setTextAlignment(TextAlignment.CENTER);
        buchstabeB.setTextAlignment(TextAlignment.CENTER);
        buchstabeC.setTextAlignment(TextAlignment.CENTER);
        buchstabeD.setTextAlignment(TextAlignment.CENTER);
        buchstabeE.setTextAlignment(TextAlignment.CENTER);
        buchstabeF.setTextAlignment(TextAlignment.CENTER);
        buchstabeG.setTextAlignment(TextAlignment.CENTER);
        buchstabeH.setTextAlignment(TextAlignment.CENTER);

        buchstabeA1.setTextAlignment(TextAlignment.CENTER);
        buchstabeB1.setTextAlignment(TextAlignment.CENTER);
        buchstabeC1.setTextAlignment(TextAlignment.CENTER);
        buchstabeD1.setTextAlignment(TextAlignment.CENTER);
        buchstabeE1.setTextAlignment(TextAlignment.CENTER);
        buchstabeF1.setTextAlignment(TextAlignment.CENTER);
        buchstabeG1.setTextAlignment(TextAlignment.CENTER);
        buchstabeH1.setTextAlignment(TextAlignment.CENTER);

        zahl1.setTextAlignment(TextAlignment.CENTER);
        zahl2.setTextAlignment(TextAlignment.CENTER);
        zahl3.setTextAlignment(TextAlignment.CENTER);
        zahl4.setTextAlignment(TextAlignment.CENTER);
        zahl5.setTextAlignment(TextAlignment.CENTER);
        zahl6.setTextAlignment(TextAlignment.CENTER);
        zahl7.setTextAlignment(TextAlignment.CENTER);
        zahl8.setTextAlignment(TextAlignment.CENTER);

        zahl11.setTextAlignment(TextAlignment.CENTER);
        zahl21.setTextAlignment(TextAlignment.CENTER);
        zahl31.setTextAlignment(TextAlignment.CENTER);
        zahl41.setTextAlignment(TextAlignment.CENTER);
        zahl51.setTextAlignment(TextAlignment.CENTER);
        zahl61.setTextAlignment(TextAlignment.CENTER);
        zahl71.setTextAlignment(TextAlignment.CENTER);
        zahl81.setTextAlignment(TextAlignment.CENTER);

        bestaetigen.setOnMouseClicked (new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {

                if(clickzaehler%2 == 0) {
                    root.setStyle("-fx-background-color: blue");
                    clickzaehler++;
                }
                else  {
                    root.setStyle("-fx-background-color: grey");
                    clickzaehler++;
                }
            }
        });

        Image imageTest = new Image (new FileInputStream("C:\\Users\\Administrator\\Pictures\\Turm.jpeg"));
        ImageView ImageViewTest = new ImageView(imageTest);
        ImageViewTest.setFitHeight(50);
        ImageViewTest.setFitWidth(50);

        root.add(ImageViewTest, 5,1);

        testButton.setOnMouseClicked (new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
               root.getChildren().remove(ImageViewTest);
               root.add(ImageViewTest, 5, 3);
               startFeld.setText("Koordinaten: " + Integer.toString(GridPane.getColumnIndex(ImageViewTest)) + Integer.toString(GridPane.getRowIndex(ImageViewTest)));
            }
        });

        testButton2.setOnMouseClicked ( new EventHandler<MouseEvent>() {
           @Override
           public void handle(javafx.scene.input.MouseEvent e) {
               root.getChildren().remove(ImageViewTest);
               root.add(ImageViewTest, 5, 1);
               startFeld.setText("Koordinaten: " + Integer.toString(GridPane.getColumnIndex(ImageViewTest)) + Integer.toString(GridPane.getRowIndex(ImageViewTest)));

           }
        });


        //root.setHalignment(buchstabeA, HPos.CENTER);
        //root.setValignment(buchstabeA, VPos.CENTER);

        Scene scene = new Scene(root, 1200, 1000);

        primaryStage.setTitle("SchachbrettVersuch");
        primaryStage.setScene(scene);
        //primaryStage.getScene().getStylesheets().add("board.css");
        primaryStage.show();

    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public static void main (String[]args){
        launch(args);


    }
}
