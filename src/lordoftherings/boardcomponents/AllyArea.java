//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.cards.AllyCard;
import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.cards.CharacterCard;
import lordoftherings.characters.Ally;
/**
 *
 * @author Amanda
 */
public class AllyArea {
    private ArrayList <Ally> myAllies;
    private CharacterArea charArea;
    
    public AllyArea(CharacterArea charArea){
        myAllies = new ArrayList<>(10);
        this.charArea = charArea;
    }
    
    public boolean addAlly(AllyCard ally){
        Ally newAlly = new Ally(ally);
        ally.setLocation(0, LocationOnBoard.FIELD);
        return myAllies.add(newAlly);
    }
    
    public Ally removeAlly(Ally ally){
        myAllies.remove(ally);
        return ally;
    }
    
    public Ally removeAllyAt(int index){
        Ally myAlly = myAllies.get(index);
        myAllies.remove(index);
        return myAlly;
    }
    
    public int findAlly(Ally wantedAlly){
        return myAllies.indexOf(wantedAlly);
        
    }
    
    public int getIndexOfAllyByCard(CharacterCard card){
        for(int i = 0; i < myAllies.size(); ++i){
            if(myAllies.get(i).getCard() == card){
                return i;
            }
        }
        return -1;
    }
    
    public Ally getAllyAt(int index){
        return myAllies.get(index);
    }
    
    public ArrayList<Ally> getAllies(){
        return myAllies;
    }
    
    public int getSize(){
        return myAllies.size();
    }
    
    public String getInfo(int allyWanted){
        return myAllies.get(allyWanted).getCard().getIdentity();
    }

    public void unCommittAllies() {
        for(int i = 0; i < myAllies.size(); ++i){
            if(myAllies.get(i).isCommitted()){
                myAllies.get(i).unCommit();
            }
        }
    }

    public void readyAllies() {
        for(int i = 0; i < myAllies.size(); ++i){
            if(myAllies.get(i).isExhausted()){
                myAllies.get(i).unExhaust();
            }
        }
    }
    
    public int getQuestingTotal(){
        int questingTotal = 0;
        for(int i = 0; i < myAllies.size(); ++i){
            if(myAllies.get(i).isCommitted()){
                questingTotal += myAllies.get(i).getWillPower();
            }
        }
        return questingTotal;
    }
    
    
}
