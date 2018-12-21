/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.gui;

import java.awt.Font;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class FontOptions {
    
    private Font messageFont;
    private Font cardFont;
    private Font endOfGameFont;
    private Font questPhaseFont;
    private Font threatFont;
    private Font victoryPointsLabelFont;
    private Font subPhaseFont;

    public FontOptions(GameConfiguration configuration) {
        messageFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, configuration.scaleFont(36));
        cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, configuration.scaleFont(12));
        endOfGameFont = new Font(Font.SERIF, Font.BOLD, configuration.scaleFont(50));
        questPhaseFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, configuration.scaleFont(30));
        threatFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, configuration.scaleFont(24));
        victoryPointsLabelFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, configuration.scaleFont(25));
        subPhaseFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, configuration.scaleFont(20));
    }
    
    public Font getSubPhaseFont(){
        return subPhaseFont;
    }
    
    public Font getVictoryPointsLabelFont(){
        return victoryPointsLabelFont;
    }
    
    public Font getThreatFont(){
        return threatFont;
    }
    
    public Font getMessageFont(){
        return messageFont;
    }
    
    public Font getCardFont(){
        return cardFont;
    }
    
    public Font getEndOfGameFont(){
        return endOfGameFont;
    }
    
    public Font getQuestPhaseFont(){
        return questPhaseFont;
    }
    
     /*public Font getFont(){
        int scale = scale(1);
        if(scale >= 1){
             return new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 20);
        }else if(scale >= 0.75 && scale < 1){
            return  new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 18);
        }else if(scale < 0.75 && scale > 0.5){
            return  new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 16);
        }else if(scale <= 0.5 && scale > 0.25){
            return  new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 14);
        }else{
            return  new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 12);
        }
    }*/
}
