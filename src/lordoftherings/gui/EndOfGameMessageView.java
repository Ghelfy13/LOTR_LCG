/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;
import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;

/**
 *
 * @author Amanda
 */
public class EndOfGameMessageView extends JLabel{
    
    public EndOfGameMessageView(int x, int y, String message){
        this.setBounds(x, y, EncounterZoneView.ZONE_WIDTH, PlayerZoneView.ZONE_HEIGHT);
        Font gameFont = new Font(Font.SERIF, Font.BOLD, 100);
        this.setFont(gameFont);
        this.setForeground(Color.RED);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        this.setText(message.toUpperCase());
        this.setOpaque(false);
    }
}