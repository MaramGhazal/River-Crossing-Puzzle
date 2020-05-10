package Crossers.Plant;

import Crossers.Crosser;
import Crossers.ICrosser;

import java.awt.image.BufferedImage;

public class Plant extends Crosser implements ICrosser {
    public Plant (){
        setEatingRank(0);
        setPosition(super.getPosition());
    }
    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public BufferedImage[] getImages() {
        return new BufferedImage[0];
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {

    }

    @Override
    public String getLabelToBeShown() {
        return null;
    }

    public void getOn(){

    }
    public void getOff(){

    }


}
