//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings;

/**
 *
 * @author Amanda
 */
public class GameConfiguration {//Creates the scaling factor for the size of the game on someones scream
    
    public static double scalar = 1.0;
    
    public GameConfiguration(){}
    
    public int scalar(int value){
        return (int) (value*scalar);
    }
    
    public static void setUpConfiguration(String[] args){
        for(int i = 1; i < args.length; ++i){
            if(args[i -1] == "--scalar"){
                scalar = Double.parseDouble(args[i]);
            }
        }
    }
    
}
