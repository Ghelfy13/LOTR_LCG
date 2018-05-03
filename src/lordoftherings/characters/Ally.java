//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.characters;

import lordoftherings.cards.AllyCard;

/**
 *
 * @author Amanda
 */
public class Ally extends GameCharacter{
    private AllyCard card;
    
    public Ally(AllyCard allyCard){
        this.card = allyCard;
    }
    
    @Override
    public AllyCard getCard(){
        return card;
    }
    
    
    
        
}
