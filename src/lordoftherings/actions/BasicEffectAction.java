//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.PlayerCard;
import lordoftherings.effects.Effect;

/**
 *
 * @author Amanda
 */
public class BasicEffectAction extends EffectAction{
    private Effect currentEffect;
    private PlayerCard cardWithEffect;
    
    public BasicEffectAction(PlayerCard card, Effect wantedEffect){
        super(card, wantedEffect);
        currentEffect = wantedEffect;
        cardWithEffect = card;
    }

    @Override
    public boolean execute(int askingID, Board boardState) {
        return currentEffect.execute(askingID, boardState, cardWithEffect);
    }

    @Override
    public void updateActionState(int askingID, Board boardState) {
        state = currentEffect.getCurrentState(askingID, boardState, cardWithEffect);
    }
    
}
