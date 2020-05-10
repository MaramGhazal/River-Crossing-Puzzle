package sample;

import Events.S1Events;
import Strategy.StoryOne;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       LevelOne x=new LevelOne(new Stage());
       x.PrepareScene();
        S1Events y=new S1Events(x);
       // y.Events();
        S1Controller z=new S1Controller(y);
        y.setController(z);
        //z.newGame(new StoryOne());
        z.loadGame();
for(int i=0;i<3;i++){
    for(int j=0;j<z.getVergu().get(i).size();j++){
        System.out.println(z.getVergu().get(i).get(j).getEatingRank());
    }
}
/*for(int i=0;i<z.getCrossersOnLeftBank().size();i++) {
    System.out.println("ana fl main   "+z.getCrossersOnLeftBank().size());
    System.out.println(z.getCrossersOnLeftBank().get(i).getEatingRank());

}*/
       /* for(int i=0;i<z.getCrossersOnRightBank().size();i++) {
            System.out.println("ana fl main   "+z.getCrossersOnRightBank().size());
            System.out.println(z.getCrossersOnRightBank().get(i).getEatingRank());

        }*/
    }



    public static void main(String[] args) {
        launch(args);

    }
}
