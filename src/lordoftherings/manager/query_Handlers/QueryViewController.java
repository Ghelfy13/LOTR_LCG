/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import java.util.ArrayList;
import lordoftherings.gui.query_components.QueryView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.manager.actionComponents.GlobalViewController;
import lordoftherings.transaction_managers.CancelHandler;
import lordoftherings.transaction_managers.QueryHandle;

/**
 *
 * @author Amanda
 */
public abstract class QueryViewController<T> implements CancellableQueryViewController, GlobalViewController{
    private GameManagerViewController gameMVC;
    protected QueryMessageViewController messageVC;
    private ArrayList<T> resultList;
    protected QueryHandle<T> handle;
    
    public QueryViewController(GameManagerViewController gameMVC, QueryHandle handle){
        this.messageVC = new QueryMessageViewController(this, handle);
        this.handle = handle;
        this.gameMVC = gameMVC;
        this.resultList = new ArrayList<>();
    }
    
    public abstract QueryView makeView(String description);
    public abstract void updateView();
    public abstract QueryView getView();
    
    public QueryHandle getHandle(){
        return handle;
    }
    
    @Override
    public CancelHandler getCancelHandler() {
        return handle.getCancelHandler();
    }

    public void deactivate() {
        gameMVC.deactivateQueryVC();
    }

    public ArrayList<T> getResult() {
        return resultList;
    }
    
    public boolean resultIsFull(){
        return handle.getMax() == resultList.size();
    }

    boolean resultContains(T current) {
        return resultList.contains(current);
    }

    public void removeFromResult(T current) {
        resultList.remove(current);
    }

    public void addToResult(T current) {
        resultList.add(current);
    }
    
    void updateParentView() {
        gameMVC.updateView();
    }
    
}
