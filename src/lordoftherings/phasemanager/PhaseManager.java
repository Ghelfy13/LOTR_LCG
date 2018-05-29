//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public interface PhaseManager {
    
    void onStartSubPhase(Board board);
    
    void onEndSubPhase(Board board);
    
    PhaseManager getNextPhase(Board board);
    
    GamePhase getPhase();
    
    SubPhase getSubPhase();
    
    boolean canProgress(Board board);
    
    boolean isActionable();
    
}
