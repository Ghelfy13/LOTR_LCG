//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.gui.query_components.CancelButtonView;
import lordoftherings.gui.query_components.ContinueButtonView;
import lordoftherings.gui.query_components.CharacterQueryMessageView;
import lordoftherings.transaction_managers.CharacterQueryHandle;

/**
 *
 * @author Amanda
 */
public class CharacterQueryMessageViewController {
    
    private CharacterQueryMessageView view;
    private ContinueButtonView continueView;
    private CancelButtonView cancelView;
    private CharacterQueryHandle handle;
    
    private CharacterQueryViewController controller;
   
    
    
    public CharacterQueryMessageViewController(CharacterQueryViewController controller, CharacterQueryHandle handle){
        this.controller = controller;
        view = null;
        continueView = null;
        cancelView = null;
        this.handle = handle;
    }
    
    public CharacterQueryMessageView makeView(int x, int y, String description){
        boolean canCancel = handle.getCancelHandler().canCancel();
        boolean canContinue = handle.getRequirements().accepts(controller.getResult());
        view = new CharacterQueryMessageView(x, y, description);
        continueView = new ContinueButtonView(25, 400, canContinue);
        continueView.addActionListener(new CharacterQueryContinueActionListener(controller));
        cancelView = new CancelButtonView(270, 400, canCancel);
        cancelView.addActionListener(new CancelButtonActionListener(controller));
        view.add(continueView);
        view.add(cancelView);
        continueView.setVisible(true);
        cancelView.setVisible(true);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        boolean canCancel = handle.getCancelHandler().canCancel();
        boolean canContinue = handle.getRequirements().accepts(controller.getResult());
        continueView.updateView(canContinue);
        cancelView.updateView(canCancel);
    }
    
    

   
}
