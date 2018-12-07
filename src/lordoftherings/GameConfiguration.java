//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings;

import lordoftherings.gui.FontOptions;

/**
 *
 * @author Amanda
 */
public class GameConfiguration {//Creates the scaling factor for the size of the game on someones scream
    
    private static final double DEFAULT_SCALE = 0.5;
    
    private double scalar;
    private FontOptions fonts;
    
    private GameConfiguration(double scalar) {
        this.scalar = scalar;
        fonts = new FontOptions(this);
    }
    
    public int scale(int value){
        return (int) (value*scalar);
    }
    
    public int scaleFont(int value) {
        // TODO change later.
        return scale(value); 
    }
    
    public static GameConfiguration fromArgs(String[] args){
        double scalar = DEFAULT_SCALE;
        for(int i = 1; i < args.length; ++i){
            if(args[i -1].equals("--scalar")){
                scalar = Double.parseDouble(args[i]);
            }
        }
        return new GameConfiguration(scalar);
    }
    
    public static GameConfiguration fromValue(double scalar) {
        return new GameConfiguration(scalar);
    }
    
    public double getScalar(){
        return scalar;
    }
    
    public FontOptions getFonts() {
        return fonts;
    }
    
}
