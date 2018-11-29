/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;
import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;

/**
 *
 * @author Amanda
 */
public class EndOfGameMessageView extends JTextArea{
    public static final Font GAME_FONT = new Font(Font.SERIF, Font.BOLD, scale(50));
    
    public EndOfGameMessageView(int x, int y, String message){
        this.setBounds(scale(x), scale(y), EncounterZoneView.ZONE_WIDTH, PlayerZoneView.ZONE_HEIGHT);
        
        this.setFont(GAME_FONT);
        this.setForeground(Color.BLACK);
        setLineWrap(true);
        setWrapStyleWord(true);
        this.setText(message.toUpperCase());
        this.setOpaque(true);
    }
}
