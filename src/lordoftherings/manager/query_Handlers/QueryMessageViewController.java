//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.gui.query_components.CancelButtonView;
import lordoftherings.gui.query_components.ContinueButtonView;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.QueryHandle;

/**
 *
 * @author Amanda
 */
public class QueryMessageViewController<T> {
    
    private QueryMessageView view;
    private ContinueButtonView continueView;
    private CancelButtonView cancelView;
    private QueryHandle<T> handle;
    private QueryViewController controller;
   
    
    
    public QueryMessageViewController(QueryViewController<T> controller, QueryHandle<T> handle){
        this.controller = controller;
        view = null;
        continueView = null;
        cancelView = null;
        this.handle = handle;
    }
    
    public QueryMessageView makeView(int x, int y, String description){
        boolean canCancel = handle.getCancelHandler().canCancel();
        boolean canContinue = handle.getRequirements().accepts(controller.getResult());
        view = new QueryMessageView(x, y, description);
        continueView = new ContinueButtonView(25, 400, canContinue);
        continueView.addActionListener(new QueryContinueActionListener<T>(controller));
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
