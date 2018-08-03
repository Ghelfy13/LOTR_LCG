//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.cards.HeroCard;
import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.cards.CharacterCard;
import lordoftherings.characters.Hero;
/**
 *
 * @author Amanda
 */
public class HeroArea {
    private ArrayList <Hero> myHeros;
    private int numOfInitialHeros = 0;
    
    public HeroArea(ArrayList <HeroCard> heroCards){
        myHeros = new ArrayList<>(10);
        int size = heroCards.size();
        for(int i = 0; i < size; ++i){
            Hero newHero = new Hero(heroCards.get(i));
            newHero.getCard().setLocation(0, LocationOnBoard.FIELD);
            myHeros.add(newHero);
        }
        numOfInitialHeros = size;
    }
    public int getNumOfHeros(){
        return myHeros.size();
    }
    
    public boolean isEmpty(){
        return myHeros.isEmpty();
    }
    
    public int getNumOfInitialHeros(){
        return numOfInitialHeros;
    }
    
    public ArrayList<Hero> getHeros(){
        return myHeros;
    }
    
    public Hero getHeroAt(int index){
        return myHeros.get(index);
    }
    
    public int getIndexOfHeroByCard(CharacterCard card){
        for(int i = 0; i < myHeros.size(); ++i){
            if(myHeros.get(i).getCard() == card){
                return i;
            }
        }
        return -1;
    }
    
    public int getIndexOfHero(Hero wantedHero){
        for(int i = 0; i < myHeros.size(); ++i){
            if(myHeros.get(i) == wantedHero){
                return i;
            }
        }
        return -1;
    }
    
    public int getQuestingTotal(){
        int questingTotal = 0;
        for(int i = 0; i < myHeros.size(); ++i){
            if(myHeros.get(i).isCommitted()){
                questingTotal += myHeros.get(i).getWillPowerWithMods();
            }
        }
        return questingTotal;
    }
    
    public int sumOfResources(){
        int sum = 0; 
        for(int i = 0; i < myHeros.size(); ++i){
            sum += myHeros.get(i).getNumOfResources();
        }
        return sum;
    }
    
    public void addResourcesToHero(int heroIndex, int numOfResources){
        myHeros.get(heroIndex).increaseResources(numOfResources);
    }

    public void unCommittHeros() {
        for(int i = 0; i < myHeros.size(); ++i){
            if(myHeros.get(i).isCommitted()){
                myHeros.get(i).unCommit();
            }
        }
    }

    public void readyHeros() {
        for(int i = 0; i < myHeros.size(); ++i){
            if(myHeros.get(i).isExhausted()){
                myHeros.get(i).unExhaust();
            }
        }
    }

    public int findHero(Hero desiredHero) { //returns -1 if hero is not found
        for(int i = 0; i < myHeros.size(); ++i){
            if(myHeros.get(i) == desiredHero){
                return i;
            }
        }
        return -1;
    }
    
    public void removeHero(Hero deadHero){
        myHeros.remove(deadHero);
    }
}
