//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.cards.PlayerCard;
import lordoftherings.effects.Effect;

/**
 *
 * @author Amanda
 */
public abstract class EffectAction extends Action{
    private Effect currentEffect;
    private PlayerCard card;
    
    public EffectAction(PlayerCard card, Effect wantedEffect){
        super(wantedEffect.createDescription(card));
        this.card = card;
        this.currentEffect = wantedEffect;
    } 
}
