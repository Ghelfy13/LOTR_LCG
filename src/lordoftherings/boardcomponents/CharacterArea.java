//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;
import lordoftherings.cards.HeroCard;
import lordoftherings.cards.AllyCard;
import java.util.ArrayList;
import lordoftherings.cards.CharacterCard;
import lordoftherings.characters.Ally;
import lordoftherings.characters.GameCharacter;
import lordoftherings.characters.Hero;
/**
 *
 * @author Amanda
 */
public class CharacterArea {
    private HeroArea heroZone;
    private AllyArea allyZone;
    private PlayerZone playerZone;
    
    public CharacterArea(ArrayList<HeroCard> myHeros, PlayerZone zone){
        heroZone = new HeroArea(myHeros);
        allyZone = new AllyArea(this);
        playerZone = zone;
    }
    
    public int getTotalNumResources(){
        return heroZone.sumOfResources();
    }
    
    public boolean addAllyToAllyZone(AllyCard newAlly){
        return allyZone.addAlly(newAlly);
    }
    
    public HeroArea getHeroArea(){
        return heroZone;
    }
    
    public AllyArea getAllyArea(){
        return allyZone;
    }
    
    public void moveDeadAllysToDiscardPile(){
        for(int i = 0; i < allyZone.getAllies().size(); ++i){
            Ally current = allyZone.getAllyAt(i);
            if(current.getDamage() >= current.getMaxHealth()){
                allyZone.removeAlly(current);
                playerZone.moveCharacterToDiscardPile(current.getCard());
            }
        }
    }
    
    public void moveDeadHerosToDiscardPile(){
        for(int i = 0; i < heroZone.getNumOfHeros(); ++i){
            Hero current = heroZone.getHeroAt(i);
            if(current.getDamage() >= current.getMaxHealth()){
                heroZone.getHeros().remove(i);
                playerZone.moveCharacterToDiscardPile(current.getCard());
            }
        }
    }
    
    public void addListOfAllies(ArrayList<AllyCard> list){
        for(int i = 0; i < list.size(); ++i){
            allyZone.addAlly(list.get(i));
        }
    }
    
    public GameCharacter getCharacterForCard(CharacterCard card) {
        GameCharacter character = findHero(card);
        if (character != null) {
            return character;
        }
        character = findAlly(card);
        return character;
    }
    
    public Hero findHero(CharacterCard card){
        int indexOfHero = heroZone.getIndexOfHeroByCard(card);
        if(indexOfHero != -1){
            return heroZone.getHeroAt(indexOfHero);
        }
        return null;
    }
    
    public Ally findAlly(CharacterCard card){
        int indexOfAlly = allyZone.getIndexOfAllyByCard(card);
        if(indexOfAlly != -1){
            return allyZone.getAllyAt(indexOfAlly);
        }
        return null;
    }

}
