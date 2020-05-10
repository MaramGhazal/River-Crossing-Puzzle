package Crossers.Herb;

import Crossers.ICrosser;

import java.awt.image.BufferedImage;

public class Goat extends Herbivorous implements ICrosser {
    public Goat() {
        setEatingRank(super.getEatingRank());
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
