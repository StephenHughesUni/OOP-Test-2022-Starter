package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Nematode {

    private String name;
    private float length;
    private boolean limbs;
    private String gender;
    private boolean eyes;


    // Accessor Methods - Getters and Setters 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean getLimbs() {
        return limbs;
    }
    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public boolean getEyes() {
        return eyes;
    }
    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser pa, float t)
    {
        pa.background(0);
        int nemWidth = 30;
        int textSize = 20;

        pa.noFill();
        pa.stroke(255);
        pa.ellipseMode(PApplet.CENTER);
        pa.textSize(textSize);
        pa.textAlign(PApplet.CENTER, PApplet.CENTER);

        //Jun should display as first name due to being first in csv file.
        pa.text(name, pa.width/2, (pa.height/2 - (nemWidth * length/2) - (textSize)));

    }

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }


    // Thought that gender was Char but process does not support in processing.
    // Changed from int to float, limbs + eyes to bool.
    // Class constructor 
    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"),
            tr.getFloat("length"),
            tr.getInt("limbs") == 1,
            tr.getString("gender"),
            tr.getInt("eyes") == 1
        );
    }


    // Processor table contruct TabelRow
    // Above was not working until this got added
    public Nematode(String name, float length, boolean limbs, String gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }
}