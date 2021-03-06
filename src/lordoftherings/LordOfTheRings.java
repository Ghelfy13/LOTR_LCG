//Copyright Amanda V. Harris 2018-present. All Rights Reserved.


package lordoftherings;

import lordoftherings.game_engine.GameData.Identification;
import lordoftherings.game_engine.GameData.PlayerCardDatabase;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.Location;
import lordoftherings.cardmodel.EnemyCardModel;
import lordoftherings.cardmodel.HeroCardModel;
import lordoftherings.cardmodel.KeyWords;
import lordoftherings.cardmodel.LocationCardModel;
import lordoftherings.cardmodel.PlayerCardModel;
import lordoftherings.cardmodel.QuestCardModel;
import lordoftherings.cards.AllyCard;
import lordoftherings.characters.Enemy;
import lordoftherings.deckcomponents.DeckBuild;
import lordoftherings.deckcomponents.EncounterBuild;
import lordoftherings.deckcomponents.EncounterDeckBuild;
import lordoftherings.deckcomponents.ExpansionName;
import lordoftherings.deckcomponents.PlayerDeckBuild;
import lordoftherings.deckcomponents.QuestSetBuild;
import lordoftherings.deckcomponents.ScenarioSymbol;
import lordoftherings.deckcomponents.SphereOfInfluence;
import lordoftherings.gui.GameManagerView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.transaction_managers.GameManager;

/**
 *
 * @author Amanda
 */
public class LordOfTheRings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Identification QuestID = new Identification(ExpansionName.CORE, 21);
        PlayerCardModel readyCard = PlayerCardDatabase.get(QuestID);
        System.out.print(readyCard);
        
        for (int i = 0; i < args.length; ++i) {
            System.out.println(args[i]);
        }
        
        Identification LocationID = new Identification(ExpansionName.CORE, 113);
        ArrayList<KeyWords> anduinKeyWords = new ArrayList<>();
        anduinKeyWords.add(KeyWords.FORCED);
        LocationCardModel firstLocation = new LocationCardModel(
        "Banks of the Anduin", 
        EncounterType.LOCATION, 
        new String[]{"Riverland"}, 
        LocationID, 
        1,
        3,
        2,
        "",
        anduinKeyWords);
        
        Identification OrcsID = new Identification (ExpansionName.CORE, 89);
        EnemyCardModel firstEnemy = new EnemyCardModel(
            "Dol Guldur Orcs", 
            EncounterType.ENEMY,
            new String[]{"Orc", "Dol Guldur"},
            OrcsID,
            10,
            2,
            3,
            2,
            1,
            2,
            "",
            new ArrayList<>());
        
        Identification AragornID = new Identification(ExpansionName.CORE, 1);
        ArrayList<KeyWords> aragornKeyWords = new ArrayList<>();
        aragornKeyWords.add(KeyWords.SENTINEL);
        aragornKeyWords.add(KeyWords.RESPONSE);
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
                0,
                "",
                new ArrayList<>(),
                aragornKeyWords);
        
        Identification QuestID2 = new Identification(ExpansionName.CORE, 122);
        QuestCardModel firstQuest = new QuestCardModel(
                "A Chosen Path: Beorn's Path",
                ScenarioSymbol.PASSAGE_THROUGH_MIRKWOOD,
                new String []{"Dol Guldur Orcs, Passage through Mirkwood, Spiders of Mirkwood"},
                "If players defeat Ungoliant's Spawn, they win the game automatically.",
                "Passage through Mirkwood",
                QuestID2,
                2);
        
        Identification QuestID3 = new Identification(ExpansionName.CORE, 120);
        QuestCardModel secondQuest = new QuestCardModel(
                "A Fork in the Road",
                ScenarioSymbol.PASSAGE_THROUGH_MIRKWOOD,
                new String [] {"Dol Guldur Orcs, Passage through Mirkwood, Spiders of Mirkwood"},
                "When you defeat this stage, proceed to Beorn's Path.",
                "Passage through Mirkwood",
                QuestID3,
                2);
        
        
        
        
        DeckBuild mockDeck = new DeckBuild();
        Identification GrimResolveID = new Identification(ExpansionName.CORE, 25);
        Identification WillOfWestID = new Identification(ExpansionName.CORE, 49);
        Identification LoreOfImladrisID = new Identification(ExpansionName.CORE, 63);
        Identification LightInDarkID = new Identification(ExpansionName.CORE, 52);
        Identification FeintID = new Identification(ExpansionName.CORE, 34);
        Identification QuickStrikeID = new Identification(ExpansionName.CORE, 35);
        Identification RadagastsCunningID = new Identification(ExpansionName.CORE, 65);
        Identification DunhereID = new Identification(ExpansionName.CORE, 9);
        Identification GleowineID = new Identification(ExpansionName.CORE, 62);
        
        mockDeck.add(PlayerCardDatabase.get(GleowineID), 3);
        mockDeck.add(PlayerCardDatabase.get(QuickStrikeID), 2);
        mockDeck.add(PlayerCardDatabase.get(FeintID), 1);
        mockDeck.add(PlayerCardDatabase.get(WillOfWestID), 1);
        mockDeck.add(PlayerCardDatabase.get(GrimResolveID), 2);
        mockDeck.add(PlayerCardDatabase.get(LoreOfImladrisID), 3);
        PlayerDeckBuild mockBuild = new PlayerDeckBuild(mockDeck);
        mockBuild.addHero(first);
        mockBuild.addHero((HeroCardModel)PlayerCardDatabase.get(DunhereID));
        Identification BeravorID = new Identification(ExpansionName.CORE, 12);
        mockBuild.addHero((HeroCardModel)PlayerCardDatabase.get(BeravorID));
        PlayerDeckBuild[] mockBuildArray = new PlayerDeckBuild[1];
        mockBuildArray[0] = mockBuild;
        
        EncounterDeckBuild encounterDB = new EncounterDeckBuild();
        QuestSetBuild questSB = new QuestSetBuild();
        questSB.addQuestCard(secondQuest);
        questSB.addQuestCard(firstQuest);
        EncounterBuild enemyBuild = new EncounterBuild(encounterDB, questSB);
        Enemy enemy = new Enemy(firstEnemy.createCard());
        Location location = new Location(firstLocation.createCard());
        
        
        GameManager manager = new GameManager(mockBuildArray, enemyBuild);
        Board newBoard = manager.getBoard();
        newBoard.getPlayerZoneAt(0).addResourcesToHero(0, 6);
        Identification DaughterID = new Identification(ExpansionName.CORE, 23);
        newBoard.getPlayerZoneAt(0).getCharZone().
                addAllyToAllyZone((AllyCard)PlayerCardDatabase.get(DaughterID).createCard());
        newBoard.getEncounterZone().addNumOfCardsToDeck(firstEnemy, 5);
        newBoard.getEncounterZone().addNumOfCardsToDeck(firstLocation, 3);
        newBoard.getPlayerZoneAt(0).getEngagementArea().addEnemy(enemy);
        newBoard.getEncounterZone().getStagingArea().addLocation(location);
        
        final int PANE_WIDTH = 2500;
        final int PANE_HEIGHT = 1300;
        
        GameConfiguration config = GameConfiguration.fromValue(1.0);
        JFrame LOTRFrame = new JFrame("LORD OF THE RINGS");
        LOTRFrame.setSize(
            config.scale(PANE_WIDTH),
            config.scale(PANE_HEIGHT));
        LOTRFrame.setLayout(null);
        LOTRFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LOTRFrame.setResizable(false);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        LOTRFrame.getContentPane().setBackground(backgroundColor);
        
        
        
        GameManagerViewController managerVC = new GameManagerViewController(manager, config);
        GameManagerView managerView = managerVC.makeView(0, 0);
        LOTRFrame.add(managerView);
        LOTRFrame.setVisible(true);
        
        
    }
}
