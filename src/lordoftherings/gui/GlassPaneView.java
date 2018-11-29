//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class GlassPaneView  extends JPanel implements MouseListener, 
        MouseMotionListener, FocusListener{
    
    public GlassPaneView(int width, int height){
        setBackground(new Color(255, 255, 255, 65));
        addMouseListener(this);
        addMouseMotionListener(this);
        addFocusListener(this);
        this.setBounds(0, 0, scale(width), scale(height));
        this.setOpaque(false);
        
    }
    
    public void setVisible(boolean visible){
        if(visible){
            requestFocus();
        }
        super.setVisible(visible);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void focusGained(FocusEvent fe) {
    }

    @Override
    public void focusLost(FocusEvent fe) {
    }

    public void updateView() {
        revalidate();
        repaint();
    }

}
