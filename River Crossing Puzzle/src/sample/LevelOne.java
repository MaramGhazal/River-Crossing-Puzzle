package sample;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.omg.CORBA.TRANSIENT;
import sun.plugin2.message.EventMessage;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.awt.*;
import java.io.File;
import java.util.List;

public class LevelOne{
    Stage stage;
    Group root = new Group();
    Scene levelOneScene = new Scene(root, 1400, 800);
    Canvas canvas = new Canvas(1400, 800);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Button FarmerLeftButton;
    ImageView FarmerLeftView;
    Button FarmerRightButton;
    ImageView FarmerRightView;
    Button WolfLeftButton;

    public LevelOne() {

    }

    public void setFarmerOnBoard(Boolean farmerOnBoard) {
        FarmerOnBoard = farmerOnBoard;
    }

    public Button getFarmerLeftButton() {
        return FarmerLeftButton;
    }

    public Button getFarmerRightButton() {
        return FarmerRightButton;
    }

    public Button getWolfLeftButton() {
        return WolfLeftButton;
    }

    public Button getWolfRightButton() {
        return WolfRightButton;
    }

    public Button getCabbageLeftButton() {
        return CabbageLeftButton;
    }

    public Button getCabbageRightButton() {
        return CabbageRightButton;
    }

    public Button getSheepLeftButton() {
        return SheepLeftButton;
    }

    public Button getSheepRightButton() {
        return SheepRightButton;
    }

    public Button getReadysail() {
        return Readysail;
    }

    public Button getPlay() {
        return play;
    }

    public void setWolfOnBoard(Boolean wolfOnBoard) {
        WolfOnBoard = wolfOnBoard;
    }

    public void setCabbageOnBoard(Boolean cabbageOnBoard) {
        CabbageOnBoard = cabbageOnBoard;
    }

    public void setSheepOnBoard(Boolean sheepOnBoard) {
        SheepOnBoard = sheepOnBoard;
    }

    public void setBoatOnRight(Boolean boatOnRight) {
        this.boatOnRight = boatOnRight;
    }

    ImageView WolfLeftView;
    Button WolfRightButton;
    ImageView WolfRightView;
    Button CabbageLeftButton;
    public Boolean getFarmerOnBoard() {
        return FarmerOnBoard;
    }

    public Boolean getWolfOnBoard() {
        return WolfOnBoard;
    }

    public Boolean getCabbageOnBoard() {
        return CabbageOnBoard;
    }

    public Boolean getSheepOnBoard() {
        return SheepOnBoard;
    }

    public Boolean getBoatOnRight() {
        return boatOnRight;
    }

    ImageView CabbageLeftView;
    Button CabbageRightButton;
    ImageView CabbageRightView;
    Button SheepLeftButton;
    ImageView SheepLeftView;
    Button SheepRightButton;
    ImageView SheepRightView;
    ImageView BoatView;
    Boolean FarmerOnBoard=false;
    Boolean WolfOnBoard=false;
    Boolean CabbageOnBoard=false;
    Boolean SheepOnBoard=false;
    Button Readysail;
    Button play;
    ImageView Sail;
    Boolean boatOnRight=false;
    ImageView readysail;
    public LevelOne(Stage stage) {
        this.stage = stage;
    }







    public void PrepareLeftFarmer(){
         FarmerLeftButton = new Button();
         FarmerLeftView= new ImageView("file:paintleftfarmer_burned.png");
         FarmerLeftButton.setGraphic(FarmerLeftView);
         FarmerLeftButton.setStyle("-fx-background-color: transparent;");
         FarmerLeftButton.setLayoutX(110);
         FarmerLeftButton.setLayoutY(350);
        root.getChildren().add(FarmerLeftButton);
        FarmerLeftButton.setVisible(true);
        //Move();

    }
    public void PrepareRightFarmer(){
        FarmerRightButton= new Button();
        FarmerRightView = new ImageView("file:paintrighttfarmer_burned.png");
        FarmerRightButton.setGraphic(FarmerRightView);
        FarmerRightButton.setStyle("-fx-background-color: transparent;");
        FarmerRightButton.setLayoutX(1075);
        FarmerRightButton.setLayoutY(430);
        root.getChildren().add(FarmerRightButton);
        FarmerRightButton.setVisible(true);



    }
    public void PrepareLeftWolf(){
        WolfLeftButton = new Button();
        WolfLeftView = new ImageView("file:leftwolfpaint_burned.png");
        WolfLeftButton.setGraphic(WolfLeftView);
        WolfLeftButton.setStyle("-fx-background-color: transparent;");
        WolfLeftButton.setLayoutX(180);
        WolfLeftButton.setLayoutY(380);
        root.getChildren().add(WolfLeftButton);
        WolfLeftButton.setVisible(true);
    }
    public void PrepareRightWolf(){
        WolfRightButton = new Button();
        WolfRightView = new ImageView("file:rightwolfpaint_burned.png");
        WolfRightButton.setGraphic(WolfRightView);
        WolfRightButton.setStyle("-fx-background-color: transparent;");
        WolfRightButton.setLayoutX(1075);
        WolfRightButton.setLayoutY(550);
        root.getChildren().add(WolfRightButton);
        WolfRightButton.setVisible(true);
    }
    public void PrepareLeftCabbage(){
        CabbageLeftButton = new Button();
        CabbageLeftView = new ImageView("file:leftcabbage1.png");
        CabbageLeftButton.setGraphic(CabbageLeftView);
        CabbageLeftButton.setStyle("-fx-background-color: transparent;");
        CabbageLeftButton.setLayoutX(280);
        CabbageLeftButton.setLayoutY(420);
        root.getChildren().add(CabbageLeftButton);
        CabbageLeftButton.setVisible(true);
       // Move();

    }
    public void PrepareRightCabbage(){
        CabbageRightButton= new Button();
        CabbageRightView =  new ImageView("file:leftcabbage1.png");
        CabbageRightButton.setGraphic(CabbageRightView);
        CabbageRightButton.setStyle("-fx-background-color: transparent;");
        CabbageRightButton.setLayoutX(1200);
        CabbageRightButton.setLayoutY(620);
        root.getChildren().add(CabbageRightButton);
        CabbageRightButton.setVisible(true);
        //Move();
    }
    public void PrepareLeftSheep(){
        SheepLeftButton = new Button();
        SheepLeftView= new ImageView("file:leftpaintsheep_burned.png");
        SheepLeftButton.setGraphic(SheepLeftView);
        SheepLeftButton.setStyle("-fx-background-color: transparent;");
        SheepLeftButton.setLayoutX(360);
        SheepLeftButton.setLayoutY(380);
        root.getChildren().add(SheepLeftButton);
        SheepLeftButton.setVisible(true);
       // Move();
    }
    public void PrepareRightSheep(){
        SheepRightButton= new Button();
        SheepRightView = new ImageView("file:rightpaintsheep_burned.png");
        SheepRightButton.setGraphic(SheepRightView);
        SheepRightButton.setStyle("-fx-background-color: transparent;");
        SheepRightButton.setLayoutX(1150);
        SheepRightButton.setLayoutY(520);
        root.getChildren().add(SheepRightButton);
        SheepRightButton.setVisible(true);
       // Move();

    }
    public void PrepareBoat(){
        BoatView = new ImageView("file:raft.png");
        BoatView.setLayoutX(320);
        BoatView.setLayoutY(400);
        root.getChildren().add(BoatView);
    }
    public void PrepareScene(){
        Image river = new Image("file:riverBanks.jpg");
        ImageView riverBanks = new ImageView(river);
        riverBanks.setFitWidth(1400);
        riverBanks.setFitHeight(800);
        root.getChildren().add(riverBanks);

        Image sail = new Image("file:sail.png");
        readysail = new ImageView(sail);
        readysail.setLayoutX(1200);
        readysail.setLayoutY(50);
      //  readysail.setFitWidth(20);
      //  readysail.setFitHeight(20);
        play= new Button();
        //play.setShape(new Circle(20));
        play.setGraphic(readysail);



        stage.setScene(levelOneScene);
        stage.show();
        root.getChildren().add(canvas);
        PrepareBoat();
        BoatView.setVisible(true);
        PrepareLeftFarmer();
        PrepareRightFarmer();
        FarmerRightButton.setVisible(false);
        PrepareLeftWolf();
        PrepareRightWolf();
        WolfRightButton.setVisible(false);
        PrepareLeftCabbage();
        PrepareRightCabbage();
        CabbageRightButton.setVisible(false);
        PrepareLeftSheep();
        PrepareRightSheep();
        SheepRightButton.setVisible(false);
        root.getChildren().add(play);
    }




    //  >>>>>>   Start of Left Farmer Button    <<<<<<<<<<<<<<<<<



    public Timeline setPathLF() {
        Line line = new Line();
        line.setStartX(50);
        line.setStartY(100);
        line.setEndX(400);
        line.setEndY(120);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerLeftButton);
        transition.setDuration(Duration.seconds(6));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);
        timeline.play();
        return timeline;
    }
    public void FLB(EventHandler<ActionEvent> leftFarmer){
        FarmerLeftButton.setOnAction(leftFarmer);
    }




    //   >>>>>>>>>>>>>>>>>>>>>>>  End of left Farmer Button   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<














    //    >>>>>>>>>>>>>>>>>>>>>>>>>>> Start of Right Farmer Button    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    public Timeline setPathRF(){
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(120);
        line.setEndX(-280);
        line.setEndY(210);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerRightButton);
        transition.setDuration(Duration.seconds(6));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);
        return timeline;
    }

    public void FRB(EventHandler<ActionEvent> rightFarmer){
        FarmerRightButton.setOnAction(rightFarmer);
    }




    // >>>>>>>>>>>>>>>>>>>>>>>> End of Right Farmer Button  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<






    //>>>>>>>>>>>>>>>>>>>>>>>>Start of right wolf button<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public Timeline setPathLW() {
                    Line line = new Line();
                    line.setStartX(80);
                    line.setStartY(50);
                    line.setEndX(200);
                    line.setEndY(110);
                    PathTransition transition = new PathTransition();
                    transition.setNode(WolfLeftButton);
                    transition.setDuration(Duration.seconds(6));
                    transition.setPath(line);
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
                    transition.setCycleCount(1);

                return timeline;
    }

    public void LWB(EventHandler<ActionEvent> wolfLeft){
        WolfLeftButton.setOnAction(wolfLeft);
    }





public Timeline onAndOffRW() {
                Line line = new Line();
                line.setStartX(0);
                line.setStartY(20);
                line.setEndX(-350);
                line.setEndY(120);
                PathTransition transition = new PathTransition();
                transition.setNode(WolfRightButton);
                transition.setDuration(Duration.seconds(6));
                transition.setPath(line);
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
                transition.setCycleCount(1);

return timeline;
}

public void RWB(EventHandler<ActionEvent> rightWolf){
        WolfRightButton.setOnAction(rightWolf);
}




public Timeline setPathLS() {
                Line line = new Line();
                line.setStartX(80);
                line.setStartY(50);
                line.setEndX(150);
                line.setEndY(150);
                PathTransition transition = new PathTransition();
                transition.setNode(SheepLeftButton);
                transition.setDuration(Duration.seconds(6));
                transition.setPath(line);
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
                transition.setCycleCount(1);

return timeline;
}

public void LSB(EventHandler<ActionEvent> leftSheep){
        SheepLeftButton.setOnAction(leftSheep);
}




public Timeline setPathRS(){
             Line line = new Line();
                line.setStartX(0);
                line.setStartY(50);
                line.setEndX(-400);
                line.setEndY(165);
                PathTransition transition = new PathTransition();
                transition.setNode(SheepRightButton);
                transition.setDuration(Duration.seconds(6));
                transition.setPath(line);
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
                transition.setCycleCount(1);

        return timeline;
}

public void RSB(EventHandler<ActionEvent> rightSheep){
        SheepRightButton.setOnAction(rightSheep);
}





public Timeline setPathLP() {

                Line line = new Line();
                line.setStartX(80);
                line.setStartY(50);
                line.setEndX(200);
                line.setEndY(110);
                PathTransition transition = new PathTransition();
                transition.setNode(CabbageLeftButton);
                transition.setDuration(Duration.seconds(6));
                transition.setPath(line);
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
                transition.setCycleCount(1);
    return timeline;
}

public void LPB(EventHandler<ActionEvent> leftPlant){
        CabbageLeftButton.setOnAction(leftPlant);
}


public Timeline setPathRP() {
                Line line = new Line();
                line.setStartX(0);
                line.setStartY(10);
                line.setEndX(-480);
                line.setEndY(55);
                PathTransition transition = new PathTransition();
                transition.setNode(CabbageRightButton);
                transition.setDuration(Duration.seconds(6));
                transition.setPath(line);
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
                transition.setCycleCount(1);

return timeline;
}

public void RPB(EventHandler<ActionEvent> rightPlant){
        CabbageRightButton.setOnAction(rightPlant);
}













    public ParallelTransition setPathBoatLeft(){
        Line line = new Line();
        line.setStartX(350);
        line.setStartY(110);
        line.setEndX(640);
        line.setEndY(280);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerLeftButton);
        transition.setDuration(Duration.seconds(6));
        transition.setPath(line);
        PathTransition transition2 = new PathTransition();
        Line line2 = new Line();
        line2.setStartX(150);
        line2.setStartY(140);
        line2.setEndX(450);
        line2.setEndY(310);
        transition2.setNode(BoatView);
        transition2.setDuration(Duration.seconds(6));
        transition2.setPath(line2);
        PathTransition transition3 = new PathTransition();
        Line line3 = new Line();
        line3.setStartX(150);
        line3.setStartY(140);
        line3.setEndX(450);
        line3.setEndY(310);
        transition3.setNode(SheepLeftButton);
        transition3.setDuration(Duration.seconds(6));
        transition3.setPath(line3);
        PathTransition transition4 = new PathTransition();
        Line line4 = new Line();
        line4.setStartX(250);
        line4.setStartY(140);
        line4.setEndX(580);
        line4.setEndY(310);
        transition4.setNode(WolfLeftButton);
        transition4.setDuration(Duration.seconds(6));
        transition4.setPath(line4);
        PathTransition transition5 = new PathTransition();
        Line line5 = new Line();
        line5.setStartX(60);
        line5.setStartY(60);
        line5.setEndX(360);
        line5.setEndY(200);
        transition5.setNode(CabbageLeftView);
        transition5.setDuration(Duration.seconds(6));
        transition5.setPath(line5);
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().add(transition2);
        parallelTransition.getChildren().add(transition);
        parallelTransition.setCycleCount(1);
        if (SheepOnBoard == true)
            parallelTransition.getChildren().add(transition3);
            if (WolfOnBoard==true)
              parallelTransition.getChildren().add(transition4);
            if (CabbageOnBoard == true)
                parallelTransition.getChildren().add(transition5);
        return parallelTransition;
    }

    public ParallelTransition setPathBoatRight(){
        Line line = new Line();
        line.setStartX(-350);
        line.setStartY(210);
        line.setEndX(-540);
        line.setEndY(50);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerRightButton);
        transition.setDuration(Duration.seconds(6));
        transition.setPath(line);
        PathTransition transition2 = new PathTransition();
        Line line2 = new Line();
        line2.setStartX(450);
        line2.setStartY(310);
        line2.setEndX(170);
        line2.setEndY(150);
        transition2.setNode(BoatView);
        transition2.setDuration(Duration.seconds(6));
        transition2.setPath(line2);
        PathTransition transition3 = new PathTransition();
        Line line3 = new Line();
        line3.setStartX(-350);
        line3.setStartY(150);
        line3.setEndX(-670);
        line3.setEndY(0);
        transition3.setNode(SheepRightButton);
        transition3.setDuration(Duration.seconds(6));
        transition3.setPath(line3);
        PathTransition transition4 = new PathTransition();
        Line line4 = new Line();
        line4.setStartX(-360);
        line4.setStartY(140);
        line4.setEndX(-600);
        line4.setEndY(-40);
        transition4.setNode(WolfRightButton);
        transition4.setDuration(Duration.seconds(6));
        transition4.setPath(line4);
        PathTransition transition5 = new PathTransition();
        Line line5 = new Line();
        line5.setStartX(-350);
        line5.setStartY(80);
        line5.setEndX(-700);
        line5.setEndY(-100);
        transition5.setNode(CabbageRightButton);
        transition5.setDuration(Duration.seconds(6));
        transition5.setPath(line5);
        ParallelTransition parallelTransition = new ParallelTransition();
        if (SheepOnBoard == true)
            parallelTransition.getChildren().addAll(transition, transition2, transition3);
        if (WolfOnBoard == true)
            parallelTransition.getChildren().addAll(transition, transition2, transition4);
        if (CabbageOnBoard == true)
            parallelTransition.getChildren().addAll(transition, transition2, transition5);
        //if(SheepOnBoard==false && WolfOnBoard==false && CabbageOnBoard==false)
        //  parallelTransition.getChildren().addAll(transition, transition2);
        parallelTransition.setCycleCount(1);
        boatOnRight=false;
        return parallelTransition;
    }

public void playSet(EventHandler<MouseEvent> playButton){
        play.setOnMouseClicked(playButton);
}

}