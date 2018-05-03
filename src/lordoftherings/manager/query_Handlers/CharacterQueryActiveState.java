//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.manager.actionComponents.Selectable;
import lordoftherings.manager.actionComponents.SelectableActiveState;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class CharacterQueryActiveState extends SelectableActiveState<GameCharacter> {
    private CharacterQueryViewController charQueryVC;

    public CharacterQueryActiveState(CharacterQueryViewController charQueryVC) {
        super(charQueryVC);
        this.charQueryVC = charQueryVC;
    }

    @Override
    public void selectOrDeselect(Selectable<GameCharacter> selectedElement) {
        if(charQueryVC.resultContains(selectedElement.get())){
            selectedElement.onDeselect();
            charQueryVC.removeFromResult(selectedElement.get());
        }
        else{
            if(!charQueryVC.resultIsFull()){
                selectedElement.onSelect();
                charQueryVC.addToResult(selectedElement.get());
            }
        }
        charQueryVC.updateView();
    }
    
}
