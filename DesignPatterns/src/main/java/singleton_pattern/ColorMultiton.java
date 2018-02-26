package singleton_pattern;

import javax.naming.NameNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ColorMultiton {

    private static Map<String, ColorMultiton> colorSingletons;

    private int red;
    private int blue;
    private int green;
    private double alpha;

    public ColorMultiton(int red, int blue, int green, double alpha) {
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.alpha = alpha;
    }

    public static ColorMultiton instance(String name) throws NameNotFoundException {

        if(colorSingletons == null){
            colorSingletons = new HashMap<>();

            colorSingletons.put("magic pink",
                            new ColorMultiton(255,0,255, 1.0));
            colorSingletons.put("lime green",
                    new ColorMultiton(50,205,50, 1.0));
        }

        if(!colorSingletons.containsKey(name)){
            throw new NameNotFoundException("Color is exception");
        }
        else{
            return colorSingletons.get(name);
        }
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {

        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {

        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
}
