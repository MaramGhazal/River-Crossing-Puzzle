package Events;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.LevelOne;
import sample.S1Controller;

public class S1Events {
    public S1Controller getController() {
        return controller;
    }

    public void setController(S1Controller controller) {
        this.controller = controller;
    }


    private S1Controller controller;
    private LevelOne levelOne;

    public S1Events(LevelOne l){
        this.levelOne=l;
        //Events();
    }
    public LevelOne getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(LevelOne levelOne) {
        this.levelOne = levelOne;
    }


   public void prepare(){
        levelOne.PrepareScene();
   }

    public EventHandler<ActionEvent> farmerLeft_Boat(){
        EventHandler<ActionEvent> farmerLeft = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelOne.getFarmerOnBoard() == false) {
                    levelOne.setPathLF().play();
                    levelOne.setFarmerOnBoard(true);
                    controller.onAndOffFarmer();

                } else {
                    levelOne.getFarmerLeftButton().setVisible(false);
                    levelOne.PrepareRightFarmer();
                    levelOne.setFarmerOnBoard(false);
                    levelOne.setBoatOnRight(true);
                    controller.onAndOffFarmer();
                    controller.setEvents();
                }
            }
        };
        return farmerLeft;
    }
 public EventHandler<ActionEvent> farmerRight_Boat(){
     EventHandler<ActionEvent> farmerRight=new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
             if(levelOne.getFarmerOnBoard()==false){
                 levelOne.setPathRF().play();
                 levelOne.setFarmerOnBoard(true);
                 controller.onAndOffFarmer();

             }
             else{
                 levelOne.getFarmerRightButton().setVisible(false);
                 levelOne.PrepareLeftFarmer();
                 levelOne.setFarmerOnBoard(false);
                 levelOne.setBoatOnRight(false);
                 controller.onAndOffFarmer();
                 controller.setEvents();

             }

         }
     };
return farmerRight;
 }







// >>>>>>>>>>>>>>>>> Moving the boat <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 //
 //
 //
 //
 public EventHandler<MouseEvent> move(){
        EventHandler<MouseEvent> move_;
        if(controller.isBoatOnTheLeftBank()) {
            move_ = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.canMove(controller.getBoatRiders(),true)) {
                        System.out.println("yala");
                        levelOne.setPathBoatLeft().play();
                        controller.doMove(controller.getBoatRiders(), true);
                    }
                    }
            };

        }
        else {
            move_ = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println(controller.getBoatRiders().size());
                    System.out.println("wslna right");
                    if (controller.canMove(controller.getBoatRiders(),false)) {
                        levelOne.setPathBoatRight().play();
                        controller.doMove(controller.getBoatRiders(), false);
                    }
                }
            };

        }
        return move_;

    }


 //>>>>>>>>>>>>>>>>>>>>>>...End of Movement of Boat...<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<









//>>>>>>>>>>>>>>>>>>>>>>>>>>Start of Wolf Events<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public EventHandler<ActionEvent> wolfLeft(){
        EventHandler<ActionEvent> leftWolf=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.onAndOffWolf();
                if (levelOne.getWolfOnBoard()==false){
                    levelOne.setPathLW().play();
                    levelOne.setWolfOnBoard(true);
                }else{
                    levelOne.getWolfLeftButton().setVisible(false);
                    levelOne.PrepareRightWolf();
                    levelOne.setWolfOnBoard(false);
                   levelOne.setBoatOnRight(true);
                    controller.setEvents();
                }
            }
        };
        return leftWolf;
    }



public EventHandler<ActionEvent> wolfRight(){
        EventHandler<ActionEvent> rightWolf=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.onAndOffWolf();
                if(levelOne.getWolfOnBoard()==false){
                    levelOne.onAndOffRW().play();
                    levelOne.setWolfOnBoard(true);
                }else{
                   levelOne.getWolfRightButton().setVisible(false);
                    levelOne.PrepareLeftWolf();
                   levelOne.setWolfOnBoard(false);
                    levelOne.setBoatOnRight(false);
                    controller.setEvents();
                }
            }
        };

return rightWolf;
    }

    public EventHandler<ActionEvent> sheepLeft(){
        EventHandler<ActionEvent> leftSheep=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.onAndOffSheep();
                if(levelOne.getSheepOnBoard()==false){
                    levelOne.setPathLS().play();
                    levelOne.setSheepOnBoard(true);
                }else{
                    levelOne.getSheepLeftButton().setVisible(false);
                    levelOne.PrepareRightSheep();
                    levelOne.setSheepOnBoard(false);
                    levelOne.setBoatOnRight(true);
                    controller.onAndOffSheep();
                    controller.setEvents();
                }
            }
        };
        return leftSheep;
    }




    public EventHandler<ActionEvent> sheepRight(){
        EventHandler<ActionEvent> rightSheep=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(levelOne.getSheepOnBoard()==false){
                    levelOne.setPathRS().play();
                    levelOne.setSheepOnBoard(true);
                    controller.onAndOffSheep();

                }else{

                    levelOne.getSheepRightButton().setVisible(false);
                    levelOne.PrepareLeftSheep();
                    levelOne.setSheepOnBoard(false);
                    levelOne.setBoatOnRight(false);
                    controller.onAndOffSheep();
                    controller.setEvents();
                }
            }
        };
        return rightSheep;
    }




public EventHandler<ActionEvent> plantLeft(){
        EventHandler<ActionEvent> leftPlant=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(levelOne.getCabbageOnBoard()==false){
                    levelOne.setPathLP().play();
                    levelOne.setCabbageOnBoard(true);
                    controller.onAndOffPlant();
                }else{
                    levelOne.getCabbageLeftButton().setVisible(false);
                    levelOne.PrepareRightCabbage();
                    levelOne.setCabbageOnBoard(false);
                    levelOne.setBoatOnRight(true);
                    controller.setEvents();
                    controller.onAndOffPlant();
                }
            }
        };
        return leftPlant;
}


    public EventHandler<ActionEvent> plantRight(){
        EventHandler<ActionEvent> rightPlant=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(levelOne.getCabbageOnBoard()==false){
                    levelOne.setPathRP().play();
                    levelOne.setCabbageOnBoard(true);
                    controller.onAndOffPlant();
                }else{
                    levelOne.setCabbageOnBoard(false);
                    levelOne.setBoatOnRight(false);
                    levelOne.getCabbageRightButton().setVisible(false);
                    controller.setEvents();
                    controller.onAndOffPlant();
                    levelOne.PrepareLeftCabbage();
                }
            }
        };
        return rightPlant;
    }








}
