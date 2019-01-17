/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.game_engine;

import lordoftherings.game_engine.GameState;
import java.util.Stack;

/**
 *
 * @author Amanda
 */
interface StackAction {
    void execute(Stack<GameState> stack);
}
