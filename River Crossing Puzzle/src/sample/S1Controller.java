package sample;
import Command.*;
import Crossers.Boat.Boat;
import Crossers.Carn.Wolf;
import Crossers.Farmer.Farmer;
import Crossers.Herb.Sheep;
import Crossers.ICrosser;
import Crossers.Plant.Plant;
import Events.S1Events;
import Strategy.ICrossingStrategy;
import Strategy.StoryOne;
import Strategy.StoryTwo;
import XML_Factories.ReadXMLFile;
import XML_Factories.XMLWriterDOM;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S1Controller implements IRiverCrossingController{
    public S1Controller(){

    }
    LevelOne levelOne=null;
    S1Events s1Events;
    private ICrossingStrategy strategy;
    private  List<ICrosser> rightBank=null;
    private  List<ICrosser> leftBank=null;
    private  List<ICrosser> boatRiders=null;
    private Boat boat=new Boat();
    private  List<List> pattern=new ArrayList<>();
    private List<List<ICrosser>> vergu=null;

    public List<List<ICrosser>> getVergu() {
        return vergu;
    }

    public void setVergu(List<List<ICrosser>> vergu) {
        this.vergu = vergu;
    }



    public List<ICrosser> getBoatRiders() {
        return boatRiders;
    }

    Stack<List> stackUndo=new Stack<>();
    Stack<List> stackRedo=new Stack<>();

    public S1Controller( S1Events s1Events) {
        this.s1Events=s1Events;
        levelOne=this.s1Events.getLevelOne();

    }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        strategy=gameStrategy;
        leftBank=strategy.getInitialCrossers();
        rightBank=new ArrayList<>();
        boatRiders=new ArrayList<>();
        boat.setNo_of_sails(0);
        boat.setPos(0);
        pattern.add(leftBank);
        pattern.add(boatRiders);
        pattern.add(rightBank);
       setEvents();

    }
public void setEvents(){
    levelOne.FLB(s1Events.farmerLeft_Boat());
    levelOne.FRB(s1Events.farmerRight_Boat());
    levelOne.LWB(s1Events.wolfLeft());
    levelOne.RWB(s1Events.wolfRight());
    levelOne.LSB(s1Events.sheepLeft());
    levelOne.RSB(s1Events.sheepRight());
    levelOne.playSet(s1Events.move());
    levelOne.LPB(s1Events.plantLeft());
    levelOne.RPB(s1Events.plantRight());
    }
    @Override
    public void resetGame() {
        if (strategy instanceof StoryOne)
        newGame(new StoryOne());
        else
            newGame(new StoryTwo());
    }

    @Override
    public String[] getInstructions() {
        return strategy.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rightBank;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return leftBank;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        //view.getFlag lw zero return true else return false;
        //hnb3t l getOn w off mkanha 3shan lma tnady 3la canMove tb3tlha boolean
        if(levelOne.boatOnRight)
        return false;
        else
            return true;
    }

    @Override
    public int getNumberOfSails() {
        return 0;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

        if(fromLeftToRightBank){
            for(int i=0;i<crossers.size();i++) {
                getCrossersOnLeftBank().remove(crossers.get(i));
                if(strategy.isValid(getCrossersOnRightBank(),getCrossersOnLeftBank(),crossers)) {
                    return true;

                }
                else
                    return false;
            }

        }else {
            for (int i = 0; i < crossers.size(); i++) {
                getCrossersOnRightBank().remove(crossers.get(i));
                if (strategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers))
                    return true;
                else
                    return false;
            }

        }
     return  false;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        crossers=boatRiders;
        boat.setNo_of_sails(boat.getNo_of_sails() + 1);
        boat.setPos(boat.getNo_of_sails() % 2);
        if(fromLeftToRightBank) {
            levelOne.boatOnRight=true;
        }else {
            levelOne.boatOnRight=false;
        }

    }

    @Override
    public boolean canUndo() {
        if(stackUndo.isEmpty())
        return false;
        else
            return true;
    }

    @Override
    public boolean canRedo() {
        if(stackRedo.isEmpty())
        return false;
        else
            return true;
    }

    @Override
    public void undo() {
        List<List> list;
    if(canUndo()) {
        list = stackUndo.pop();
        stackRedo.push(list);
        leftBank=(ArrayList)list.get(0);
        boatRiders=(ArrayList)list.get(1);
        rightBank=(ArrayList)list.get(2);
    }

    }

    @Override
    public void redo() {
    List <List>list;
    if(canRedo()){
        list=stackRedo.pop();
        stackUndo.push(list);
        leftBank=(ArrayList)list.get(0);
        boatRiders=(ArrayList)list.get(1);
        rightBank=(ArrayList)list.get(2);

    }
    }

    @Override
    public void saveGame() {
        XMLWriterDOM x=new XMLWriterDOM();
        x.write();
    }

    @Override
    public void loadGame() {
        ReadXMLFile x=new ReadXMLFile();
        setVergu(x.Read());
       leftBank= vergu.get(0);
        boatRiders= vergu.get(1);
        rightBank= vergu.get(2);

    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    ButtonMover button=new ButtonMover();
    Move move=new Move();
    public ICrossingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ICrossingStrategy strategy) {
        this.strategy = strategy;
    }


    // >>>>>>>>>>>>>>>>>>>>>>Event handler of Movement<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



    // >>>>>>>>>>>>>>>Event handler of Farmer<<<<<<<<<<<<<<<<<<<<<<<<

       public   void onAndOffFarmer() {
           ICrosser crosser = null;
           int flag = 1;
           for (ICrosser x : leftBank) {
               if (x instanceof Farmer) {
                   crosser = x;
                   flag = 0;
               }
           }
           if (flag == 1) {
               for (ICrosser x : rightBank) {
                   if (x instanceof Farmer) {
                       crosser = x;
                       flag = 2;
                   }
               }
           }
           if (flag == 1) {
               for (ICrosser x : boatRiders) {
                   if (x instanceof Farmer)
                       crosser = x;
               }
           }

           if (flag == 0 && isBoatOnTheLeftBank()) {
               Command getOn = new GetOnBoard(move, crosser);
               button.setCommand(getOn);
               boatRiders = button.pressButton();
               leftBank.remove(crosser);
               //System.out.println(leftBank.size());
               //System.out.println(boatRiders.get(0).getEatingRank());
               if (levelOne.getFarmerOnBoard() == true)
                   setEvents();
           }else if(flag==2){
               Command getOn = new GetOnBoard(move, crosser);
               button.setCommand(getOn);
               boatRiders = button.pressButton();
               rightBank.remove(crosser);

           } else if (flag == 1) {
               Command getOff = new GetOffBoard(move, crosser);
               button.setCommand(getOff);
               boatRiders = button.pressButton();
               if (boat.getPos() == 0)
                   leftBank.add(crosser);
               else {
                   rightBank.add(crosser);
                   if (levelOne.getFarmerOnBoard() == true)
                       setEvents();
               }
               }
           stackUndo.push(pattern);
       }

    // >>>>>>>>>>>>>>>Event handler of Wolf<<<<<<<<<<<<<<<<<<<<<<<<


    public void onAndOffWolf() {

        ICrosser crosser = null;
        int flag = 1;
        for (ICrosser x : leftBank) {
            if (x instanceof Wolf) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x instanceof Wolf) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 1) {
            for (ICrosser x : boatRiders) {
                if (x instanceof Wolf)
                    crosser = x;
            }
        }

        if (flag == 0 && boat.getPos() == 0) {
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            leftBank.remove(crosser);
            // levelOne.setWolfPath().play();
            //levelOne.setWolfonboard(true);
        }else if(flag==2){
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            rightBank.remove(crosser);
        } else if (flag == 1) {
            Command getOff = new GetOffBoard(move, crosser);
            button.setCommand(getOff);
            boatRiders = button.pressButton();
            if (boat.getPos() == 0)
                leftBank.add(crosser);
            else
                rightBank.add(crosser);
        }

        stackUndo.push(pattern);
    }








    public void onAndOffSheep() {

        ICrosser crosser = null;
        int flag = 1;
        for (ICrosser x : leftBank) {
            if (x instanceof Sheep) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x instanceof Sheep) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 1) {
            for (ICrosser x : boatRiders) {
                if (x instanceof Sheep)
                    crosser = x;
            }
        }

        if (flag == 0 && boat.getPos() == 0) {
            System.out.println("sheep inside");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            leftBank.remove(crosser);
            // levelOne.setWolfPath().play();
            //levelOne.setWolfonboard(true);
        }else if(flag==2){
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            rightBank.remove(crosser);
        } else if (flag == 1) {
            Command getOff = new GetOffBoard(move, crosser);
            button.setCommand(getOff);
            boatRiders = button.pressButton();
            if (isBoatOnTheLeftBank())
                leftBank.add(crosser);
            else
                rightBank.add(crosser);
        }

        stackUndo.push(pattern);
    }




    public void onAndOffPlant() {

        ICrosser crosser = null;
        int flag = 1;
        for (ICrosser x : leftBank) {
            if (x instanceof Plant) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x instanceof Plant) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 1) {
            for (ICrosser x : boatRiders) {
                if (x instanceof Plant)
                    crosser = x;
            }
        }

        if (flag == 0 && boat.getPos() == 0) {
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            leftBank.remove(crosser);
            // levelOne.setWolfPath().play();
            //levelOne.setWolfonboard(true);
        }else if(flag==2){
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            rightBank.remove(crosser);
        } else if (flag == 1) {
            Command getOff = new GetOffBoard(move, crosser);
            button.setCommand(getOff);
            boatRiders = button.pressButton();
            if (boat.getPos() == 0)
                leftBank.add(crosser);
            else
                rightBank.add(crosser);
        }

        stackUndo.push(pattern);
    }










}

