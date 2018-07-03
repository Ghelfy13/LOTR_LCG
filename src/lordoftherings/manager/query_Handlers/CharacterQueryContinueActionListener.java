//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import lordoftherings.transaction_managers.ResultHandler;
import lordoftherings.characters.GameCharacter;
import lordoftherings.transaction_managers.QueryRequirements;

/**
 *
 * @author Amanda
 */
public class CharacterQueryContinueActionListener implements ActionListener{

    CharacterQueryViewController controller;
    
    public CharacterQueryContinueActionListener(CharacterQueryViewController controller){
        this.controller = controller;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ResultHandler<ArrayList<GameCharacter>> resultHandler = controller.getHandle().getResultHandler();
        QueryRequirements<GameCharacter> requirements = controller.getHandle().getRequirements();
        ArrayList<GameCharacter> result = controller.getResult();
        if(requirements.accepts(result)){
            controller.deactivate();
            resultHandler.handle(result);
            controller.updateParentView();
        }
    }
    
}
