//Copyright Amanda V. Harris 2018-present. All Rights Reserved.


package lordoftherings;

import lordoftherings.deckcomponents.SphereOfInfluence;
import lordoftherings.deckcomponents.DeckBuild;
import lordoftherings.deckcomponents.PlayerDeckBuild;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.EnemyCardModel;
import lordoftherings.cardmodel.HeroCardModel;
import lordoftherings.cardmodel.AllyCardModel;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import lordoftherings.deckcomponents.EncounterBuild;
import lordoftherings.deckcomponents.EncounterDeckBuild;
import lordoftherings.deckcomponents.QuestSetBuild;
import lordoftherings.deckcomponents.ScenarioSymbol;
import lordoftherings.cardmodel.LocationCardModel;
import lordoftherings.cardmodel.QuestCardModel;
import lordoftherings.transaction_managers.GameManager;
import lordoftherings.characters.Enemy;
import lordoftherings.boardcomponents.Location;
import lordoftherings.cardmodel.EventCardModel;
import lordoftherings.cards.AllyCard;
import lordoftherings.deckcomponents.ExpansionName;
import lordoftherings.effects.DiscardToAddModifiersEffect;
import lordoftherings.effects.DiscardToDrawEffect;
import lordoftherings.effects.DiscardToExhaustAndReadyEffect;
import lordoftherings.effects.Effect;
import lordoftherings.effects.ExhaustToDrawEffect;
import lordoftherings.effects.ExhaustToRaiseWillPowerEffect;
import lordoftherings.effects.HealEffect;
import lordoftherings.effects.HealPlayersHerosAndDiscardCardEffect;
import lordoftherings.effects.ReadyAllyToDiscardCardEffect;
import lordoftherings.gui.GameManagerView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.modifiers.LifeSpanOfModifier;
import lordoftherings.modifiers.Modifier;
import lordoftherings.modifiers.TypeOfModifier;

/**
 *
 * @author Amanda
 */
public class LordOfTheRings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for (int i = 0; i < args.length; ++i) {
            System.out.println(args[i]);
        }
        
        Identification LocationID = new Identification(ExpansionName.CORE, 113);
        LocationCardModel firstLocation = new LocationCardModel(
        "Banks of the Anduin", 
        EncounterType.LOCATION, 
        new String[]{"Riverland"}, 
        LocationID, 
        1,
        3,
        "");
        
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
            1,
            "");
        
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
                0,
                "",
                new ArrayList<>());
        
        Identification QuestID = new Identification(ExpansionName.CORE, 122);
        QuestCardModel firstQuest = new QuestCardModel(
                "A Chosen Path: Beorn's Path",
                ScenarioSymbol.PASSAGE_THROUGH_MIRKWOOD,
                new String []{"Dol Guldur Orcs, Passage through Mirkwood, Spiders of Mirkwood"},
                "If players defeat Ungoliant's Spawn, they win the game automatically.",
                "Passage through Mirkwood",
                QuestID,
                2);
        
        Identification QuestID2 = new Identification(ExpansionName.CORE, 120);
        QuestCardModel secondQuest = new QuestCardModel(
                "A Fork in the Road",
                ScenarioSymbol.PASSAGE_THROUGH_MIRKWOOD,
                new String [] {"Dol Guldur Orcs, Passage through Mirkwood, Spiders of Mirkwood"},
                "When you defeat this stage, proceed to Beorn's Path.",
                "Passage through Mirkwood",
                QuestID2,
                2);
        
        DeckBuild mockDeck = new DeckBuild();
        Identification CommonCauseID = new Identification(ExpansionName.CORE,21);
        mockDeck.add(PlayerCardDatabase.get(CommonCauseID), 3);
       /*mockDeck.add(bladeMastery, 0);
        mockDeck.add(everVigilant, 0);
        mockDeck.add(second, 0);
        mockDeck.add(beornsHospitality, 0);
        mockDeck.add(faramir,0);
        mockDeck.add(gleowine, 0);
        mockDeck.add(loriensWealth, 0);*/
        PlayerDeckBuild mockBuild = new PlayerDeckBuild(mockDeck);
        mockBuild.addHero(first);
        mockBuild.addHero(first);
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
