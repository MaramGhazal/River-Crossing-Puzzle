package Crossers.Farmer;

import Crossers.Crosser;
import Crossers.ICrosser;

import java.awt.image.BufferedImage;

public class Farmer extends Crosser implements ICrosser {
    public Farmer(double weight){
        setWeight(weight);
        setEatingRank(4);

    }
    public Farmer() {
        setEatingRank(4);
        setPosition(super.getPosition());
    }

    @Override
    public boolean canSail() {
        return true;
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
