//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import lordoftherings.transaction_managers.ResultHandler;
import lordoftherings.transaction_managers.QueryRequirements;

/**
 *
 * @author Amanda
 */
public class QueryContinueActionListener<T> implements ActionListener{

    QueryViewController<T> controller;
    
    public QueryContinueActionListener(QueryViewController<T> controller){
        this.controller = (QueryViewController<T>) controller;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ResultHandler<ArrayList<T>> resultHandler = controller.getHandle().getResultHandler();
        QueryRequirements<T> requirements = controller.getHandle().getRequirements();
        ArrayList<T> result = controller.getResult();
        if(requirements.accepts(result)){
            controller.deactivate();
            resultHandler.handle(result);
            controller.updateParentView();
        }
    }
    
}
