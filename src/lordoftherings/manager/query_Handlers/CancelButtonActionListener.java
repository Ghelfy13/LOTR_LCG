//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lordoftherings.transaction_managers.CancelHandler;

/**
 *
 * @author Amanda
 */
public class CancelButtonActionListener implements ActionListener{

    private CancellableQueryViewController controller;
    
    public CancelButtonActionListener(CancellableQueryViewController controller){
        this.controller = controller;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        CancelHandler handler = controller.getCancelHandler();
        if(handler.canCancel()){
            controller.deactivate();
            handler.cancel();
        }
    }
    
}
