//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings;

/**
 *
 * @author Amanda
 */
public class GameConfiguration {//Creates the scaling factor for the size of the game on someones scream
    
    public static double scalar = .5;
    
    public static int scale(int value){
        return (int) (value*scalar);
    }
    
    public static void setUpConfiguration(String[] args){
        for(int i = 1; i < args.length; ++i){
            if(args[i -1].equals("--scalar")){
                scalar = Double.parseDouble(args[i]);
            }
        }
    }
    
    public static double getScalar(){
        return scalar;
    }
    
}
