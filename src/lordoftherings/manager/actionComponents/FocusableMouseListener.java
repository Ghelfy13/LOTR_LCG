//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Amanda
 */
public class FocusableMouseListener implements MouseListener{
    private Focusable setting;
    protected FocusableActiveState fas;
    
    public FocusableMouseListener(FocusableActiveState fas, Focusable viewableSetting){
        setting = viewableSetting;
        this.fas = fas;
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
        fas.setFocusable(setting);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        fas.unsetFocusable(setting);
    }
}
