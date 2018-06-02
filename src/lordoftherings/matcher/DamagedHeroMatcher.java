/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.matcher;

import lordoftherings.PlayerCardType;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class DamagedHeroMatcher implements Matcher<GameCharacter>{

    @Override
    public boolean matches(GameCharacter element) {
        return (element.getCard().getCardType() == PlayerCardType.HERO &&
                element.getDamage()>0);
    }
    
}
