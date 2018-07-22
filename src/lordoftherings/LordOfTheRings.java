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
import lordoftherings.deckcomponents.ExpansionName;
import lordoftherings.effects.DiscardToDrawEffect;
import lordoftherings.effects.Effect;
import lordoftherings.effects.ExhaustToDrawEffect;
import lordoftherings.effects.HealEffect;
import lordoftherings.effects.HealPlayersHerosAndDiscardCardEffect;
import lordoftherings.effects.ReadyAllyToDiscardCardEffect;
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
        HealEffect healHero = new HealEffect(2);
        ArrayList<Effect> list = new ArrayList<>();
        list.add(healHero);
        
        ReadyAllyToDiscardCardEffect discardToReady = new ReadyAllyToDiscardCardEffect();
        ArrayList<Effect> list2 = new ArrayList<>();
        list2.add(discardToReady);
        
        HealPlayersHerosAndDiscardCardEffect healPlayersHeros = new HealPlayersHerosAndDiscardCardEffect();
        ArrayList<Effect> list3 = new ArrayList<>();
        list3.add(healPlayersHeros);
        
        DiscardToDrawEffect discardToDraw = new DiscardToDrawEffect(3);
        ArrayList<Effect> list4 = new ArrayList<>();
        list4.add(discardToDraw);
        
        ExhaustToDrawEffect exhaustToDraw = new ExhaustToDrawEffect(2);
        ArrayList<Effect> list5 = new ArrayList<>();
        list5.add(exhaustToDraw);
        
        Identification BeravorID = new Identification(ExpansionName.CORE, 12);
        HeroCardModel beravor = new HeroCardModel(
            "Beravor",
            SphereOfInfluence.LORE,
            PlayerCardType.HERO,
            new String [] {"Dunedain", "Ranger"},
            BeravorID,
            2, 
            2,
            2,
            4,
            10,
            4,
            "",
            list5);
        
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
        
        Identification EverVigilantID = new Identification(ExpansionName.CORE, 20);
        EventCardModel everVigilant = new EventCardModel(
            "Ever Vigilant", 
            SphereOfInfluence.LEADERSHIP,
            PlayerCardType.EVENT,
            new String[]{""},
            EverVigilantID,
            1,
            "Choose and ready 1 ally card and discard card",
            list2) ;
        
        Identification loriensWealthID = new Identification(ExpansionName.CORE, 64);
        EventCardModel loriensWealth = new EventCardModel(
            "Lorien's Wealth",
            SphereOfInfluence.LORE,
            PlayerCardType.EVENT,
            new String[]{""},
            loriensWealthID,
            3,
            "Choose a player.  That player draws 3 cards",
            list4);
        
        Identification BeornsHospitalityID = new Identification(ExpansionName.CORE, 68);
        EventCardModel beornsHospitality = new EventCardModel(
            "Beorn's Hospitality", 
            SphereOfInfluence.LORE,
            PlayerCardType.EVENT,
            new String[]{""},
            BeornsHospitalityID,
            5,
            "Choose a player, and heal all damage on each hero controlled by that player.",
            list3);
        
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
          3,
          "Exhaust Daughter of Nimrodel to heal up to 2 damage on any 1 hero",
          list);
        
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
        mockDeck.add(everVigilant, 0);
        mockDeck.add(second, 0);
        mockDeck.add(beornsHospitality, 0);
        mockDeck.add(loriensWealth, 7);
        PlayerDeckBuild mockBuild = new PlayerDeckBuild(mockDeck);
        mockBuild.addHero(first);
        mockBuild.addHero(first);
        mockBuild.addHero(beravor);
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
        newBoard.getPlayerZoneAt(0).getCharZone().addAllyToAllyZone(second.createCard());
        newBoard.getPlayerZoneAt(0).getCharZone().addAllyToAllyZone(second.createCard());
        newBoard.getPlayerZoneAt(0).getCharZone().addAllyToAllyZone(second.createCard());
        newBoard.getPlayerZoneAt(0).getCharZone().addAllyToAllyZone(second.createCard());
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
