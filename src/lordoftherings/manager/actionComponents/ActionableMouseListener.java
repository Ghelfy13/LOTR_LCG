//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.awt.event.MouseEvent;

/**
 *
 * @author Amanda
 */
public class ActionableMouseListener extends FocusableMouseListener{
    private Actionable actionableSetting;
    private BoardActiveState bas;
    
    public ActionableMouseListener(BoardActiveState bas, Actionable viewableSetting) {
        super(bas, viewableSetting);
        actionableSetting = viewableSetting;
        this.bas = bas;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        bas.setActionable(actionableSetting);
    }
    
}
