//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;

/**
 *
 * @author Amanda
 */
public abstract class FocusableActiveState {
    private Focusable currentFocusable;
    private JLabel focusableText;
    private MouseMotionListener mouseFollower;
    private GlobalViewController globalVC;
    
    public FocusableActiveState(GlobalViewController globalVC){
        this.currentFocusable = null;
        this.focusableText = new JLabel(""); 
        this.focusableText.setOpaque(true);
        this.mouseFollower = null;
        this.globalVC = globalVC;
    }
    
    public JLabel getFocusableText(){
        return focusableText;
    }
    
    public MouseMotionListener createMouseFollower(){
        if(mouseFollower == null){
            mouseFollower = new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent me) {
                    mouseMoved(me);
                }

                @Override
                public void mouseMoved(MouseEvent me) {
                    final Point mousePos = globalVC.getMousePosition();
                    if (mousePos == null) {
                        return;
                    }
                    moveFocusableText(mousePos.x, mousePos.y);
                }
            };
        }
        return mouseFollower;    
    }
    
    public void moveFocusableText(int x, int y){
        int textY = y + 50;
        int textX = x- focusableText.getWidth()/2;
        focusableText.setLocation(textX, textY);
    }
    
    public Focusable getCurrentFocusable() {
        return currentFocusable;
    }
    
    public void unsetFocusable(Focusable view) {
        if (view != currentFocusable) {
            return;
        }
        currentFocusable = null;
        focusableText.setVisible(false);
    }
    
    public void setFocusable(Focusable view) {
        currentFocusable = view;
        focusableText.setText(view.getViewingText());
        focusableText.setSize(focusableText.getPreferredSize());
        focusableText.setVisible(true);
    }
}
