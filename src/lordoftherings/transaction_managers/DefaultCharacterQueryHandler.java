//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class DefaultCharacterQueryHandler implements CharacterQueryHandler{

    private Board board;
    
    public DefaultCharacterQueryHandler(Board board){
        this.board = board;
    }
    
    
    @Override
    public void handleQuery(CharacterQueryHandle handle, String descriptionOfQuest) {
        int numOfMatchedChar = 0;
        ArrayList<GameCharacter> listOfCharacters = new ArrayList<>();
        if(handle.getMin() == 0){
            handle.getResultHandler().handle(listOfCharacters);
        }else{
            PlayerZone zone = board.getPlayerZoneAt(board.getCurrentPlayerNum());
            int numOfHeros = zone.getHeros().size();
            int numOfAllies = zone.getAllies().size();
            for(int i = 0; i < numOfHeros + numOfAllies; ++i){
                if(i < numOfHeros){
                    if(handle.getMatcher().matches(zone.getHeros().get(i))){
                        ++numOfMatchedChar;
                        listOfCharacters.add(zone.getHeros().get(i));
                    }
                    
                }else{
                    if(handle.getMatcher().matches(zone.getAllies().get(i-numOfHeros))){
                        ++numOfMatchedChar;
                        listOfCharacters.add(zone.getAllies().get(i-numOfHeros));
                    }
                }
                if(numOfMatchedChar == handle.getMin()){
                        break;
                }
            }
        }
        if(numOfMatchedChar == handle.getMin()){
            handle.getResultHandler().handle(listOfCharacters);
        }else{
            handle.getCancelHandler().cancel();
        }
    }

}
