/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.game_engine;

import java.util.Stack;


/**
 *
 * @author Amanda
 */
public class GameEngine {
    private final Stack<GameState> gameStack;
    private boolean running;
    
    public GameEngine(){
        gameStack = new Stack<>();
        running = false;
    }

    // public void execute(StackAction[] actions)
    // gameEngine.execute(new PushAction(GS1), new PushAction(GS2))
    public void execute(StackAction... actions) {
        for (StackAction action : actions) {
            action.execute(gameStack);
        }
        if (!gameStack.empty() && running) {
            gameStack.peek().onResume(this);
        }
        // TODO: if gameStack is empty after execution close GE.
        // TODO: add close method
    }
    
    public void start() {
        if (gameStack.empty()) {
            return;
        }
        // creates the JFrame (or at least makes it visible).
        // other stuff (maybe grab system-level persistant game data, blah blah).
        running = true;
        gameStack.peek().onResume(this);
    }
    
}

static void main(String[] args) {
  GameEngine ge = new GameEngine(args);
  ge.execute(PushAction.get(new BoardGS()));
  ge.start();
}

// Push Action: idles the active state (if active) and pushes and creates a new GS.
// Pop Action: idles the active state and destroys and removes the active state.
// Pop-to: idles the active state and destroys and removes until a state with the GST is found. (may empty stack)
