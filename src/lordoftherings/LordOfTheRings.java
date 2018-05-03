//Copyright Amanda V. Harris 2018-present. All Rights Reserved.


package lordoftherings;

import lordoftherings.DeckComponents.ExpansionName;
import lordoftherings.DeckComponents.SphereOfInfluence;
import lordoftherings.DeckComponents.DeckBuild;
import lordoftherings.DeckComponents.PlayerDeckBuild;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.EnemyCardModel;
import lordoftherings.cardmodel.HeroCardModel;
import lordoftherings.cardmodel.AllyCardModel;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import lordoftherings.DeckComponents.EncounterBuild;
import lordoftherings.DeckComponents.EncounterDeckBuild;
import lordoftherings.transaction_managers.GameManager;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.GameManagerView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;

/**
 *
 * @author Amanda
 */
public class LordOfTheRings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Identification OrcsID = new Identification (ExpansionName.CORE, 3);
        EnemyCardModel firstEnemy = new EnemyCardModel(
            "Orcs of Dol Guldur", 
            EncounterType.ENEMY,
            new String[]{"Orc", "Dol Guldur"},
            OrcsID,
            10,
            2,
            3,
            2,
            1);
        Identification AragornID = new Identification(ExpansionName.CORE, 1);
        HeroCardModel first = new HeroCardModel(
                "Aragorn",
                SphereOfInfluence.LEADERSHIP,
                PlayerCardType.HERO, 
                new String[]{"Dunedain", "Noble", "Ranger"},
                AragornID,
                2,
                3,
                2,
                5,
                12,
                0);
        Identification DaughterID = new Identification(ExpansionName.CORE, 23);
        AllyCardModel second = new AllyCardModel(
          "Daughter of Nimrodel",
          SphereOfInfluence.LORE,
          PlayerCardType.ALLY,
          new String[]{"Silvan"},
          DaughterID,
          1,
          0,
          0,
          1,
          3);
        
        DeckBuild mockDeck = new DeckBuild();
        mockDeck.add(second, 4);
        PlayerDeckBuild mockBuild = new PlayerDeckBuild(mockDeck);
        mockBuild.addHero(first);
        mockBuild.addHero(first);
        mockBuild.addHero(first);
        PlayerDeckBuild[] mockBuildArray = new PlayerDeckBuild[1];
        mockBuildArray[0] = mockBuild;
        
        EncounterDeckBuild encounterDB = new EncounterDeckBuild();
        EncounterBuild enemyBuild = new EncounterBuild(encounterDB, null);
        Enemy enemy = new Enemy(firstEnemy.createCard());
        
        
        GameManager manager = new GameManager(mockBuildArray, enemyBuild);
        Board newBoard = manager.getBoard();
        newBoard.getPlayerZoneAt(0).addResourcesToHero(0, 6);
        newBoard.getEncounterZone().addNumOfCardsToDeck(firstEnemy, 5);
        newBoard.getPlayerZoneAt(0).getEngagementArea().addEnemy(enemy);
        
        final int PANE_WIDTH = 2500;
        final int PANE_HEIGHT = 1300;
        
        JFrame LOTRFrame = new JFrame("LORD OF THE RINGS");
        LOTRFrame.setSize(
            PANE_WIDTH,
            PANE_HEIGHT);
        LOTRFrame.setLayout(null);
        LOTRFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LOTRFrame.setResizable(false);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        LOTRFrame.getContentPane().setBackground(backgroundColor);
        
        GameManagerViewController managerVC = new GameManagerViewController(manager);
        GameManagerView managerView = managerVC.makeView(0, 0);
        LOTRFrame.add(managerView);
        LOTRFrame.setVisible(true);
        
        
    }
}
