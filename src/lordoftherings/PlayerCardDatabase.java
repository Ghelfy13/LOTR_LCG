//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings;

import java.util.ArrayList;
import java.util.HashMap;
import lordoftherings.cardmodel.AllyCardModel;
import lordoftherings.cardmodel.EventCardModel;
import lordoftherings.cardmodel.HeroCardModel;
import lordoftherings.cardmodel.PlayerCardModel;
import lordoftherings.deckcomponents.ExpansionName;
import lordoftherings.deckcomponents.SphereOfInfluence;
import lordoftherings.effects.DiscardToAddModifiersEffect;
import lordoftherings.effects.DiscardToDrawEffect;
import lordoftherings.effects.DiscardToExhaustAndReadyEffect;
import lordoftherings.effects.DiscardToHealEffect;
import lordoftherings.effects.Effect;
import lordoftherings.effects.ExhaustToDrawEffect;
import lordoftherings.effects.ExhaustToRaiseWillPowerEffect;
import lordoftherings.effects.HealEffect;
import lordoftherings.effects.HealPlayersHerosAndDiscardCardEffect;
import lordoftherings.effects.PlayGrimResolveEffect;
import lordoftherings.effects.PlayRadagastsCunningEffect;
import lordoftherings.effects.PlayToFeintEffect;
import lordoftherings.effects.PlayToMoveEnemyToStagingAreaEffect;
import lordoftherings.effects.PlayToQuickStrikeEffect;
import lordoftherings.effects.PlayWillOfWestEffect;
import lordoftherings.effects.ReadyAllyToDiscardCardEffect;
import lordoftherings.modifiers.LifeSpanOfModifier;
import lordoftherings.modifiers.Modifier;
import lordoftherings.modifiers.TypeOfModifier;

/**
 *
 * @author Amanda
 */
public class PlayerCardDatabase {
    
    private static HashMap<Identification, PlayerCardModel> cardMap = null;
    
    public static PlayerCardModel get(Identification id) {
        initializeCardMap();
        PlayerCardModel desiredID = cardMap.get(id);
        if(desiredID != null){
            return desiredID;
        }
        else{
            throw new RuntimeException("No model found for this ID: " + id.setName + " " + id.numInSet);
        }
        
    }
    
    public static void initializeCardMap() {
        if(cardMap != null) return;
        cardMap = new HashMap<>();
        
        HealEffect healHero = new HealEffect(2);
        ArrayList<Effect> list = new ArrayList<>();
        list.add(healHero);
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
            list,
            false);
        cardMap.put(DaughterID, second);
        
        ReadyAllyToDiscardCardEffect discardToReady = new ReadyAllyToDiscardCardEffect();
        ArrayList<Effect> list2 = new ArrayList<>();
        list2.add(discardToReady);
        Identification EverVigilantID = new Identification(ExpansionName.CORE, 20);
        EventCardModel everVigilant = new EventCardModel(
            "Ever Vigilant", 
            SphereOfInfluence.LEADERSHIP,
            PlayerCardType.EVENT,
            new String[]{""},
            EverVigilantID,
            1,
            "Choose and ready 1 ally card and discard card",
            list2);
        cardMap.put(EverVigilantID, everVigilant);
        
        HealPlayersHerosAndDiscardCardEffect healPlayersHeros = new HealPlayersHerosAndDiscardCardEffect();
        ArrayList<Effect> list3 = new ArrayList<>();
        list3.add(healPlayersHeros);
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
        cardMap.put(BeornsHospitalityID, beornsHospitality);
        
        DiscardToDrawEffect discardToDraw = new DiscardToDrawEffect(3);
        ArrayList<Effect> list4 = new ArrayList<>();
        list4.add(discardToDraw);
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
        cardMap.put(loriensWealthID, loriensWealth);
        
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
        cardMap.put(BeravorID, beravor);
        
        Identification DunhereID = new Identification(ExpansionName.CORE, 9);
        HeroCardModel dunhere = new HeroCardModel(
            "Dunhere",
            SphereOfInfluence.SPIRIT,
            PlayerCardType.HERO,
            new String[] {"Rohan", "Warrior"},
            DunhereID,
            1,
            2,
            1,
            4,
            8,
            2,
            "",
            new ArrayList<>());
        cardMap.put(DunhereID, dunhere);
        
        
        ExhaustToRaiseWillPowerEffect exhaustToRaiseWillPower = 
                new ExhaustToRaiseWillPowerEffect(1, new Modifier(1, TypeOfModifier.WILL_POWER, LifeSpanOfModifier.ENDOFPHASE));
        ArrayList<Effect> list6 = new ArrayList<>();
        list6.add(exhaustToRaiseWillPower);
        Identification FaramirID = new Identification(ExpansionName.CORE, 14);
        AllyCardModel faramir = new AllyCardModel(
            "Faramir",
            SphereOfInfluence.LEADERSHIP,
            PlayerCardType.ALLY,
            new String [] {"Gondor", "Noble", "Ranger"},
            FaramirID,
            4,
            2,
            1,
            2,
            3,
            "Exhaust Faramir to choose a player.  Each character controlled "
                    + "by the player gets +1 Willpower until the end of the phase.",
            list6,
            true);
        cardMap.put(FaramirID, faramir);
        
        ExhaustToDrawEffect exhaustToDrawGleowine = new ExhaustToDrawEffect(1);
        ArrayList<Effect> list7 = new ArrayList<>();
        list7.add(exhaustToDrawGleowine);
        Identification GleowineID = new Identification(ExpansionName.CORE, 62);
        AllyCardModel gleowine = new AllyCardModel(
            "Gleowine",
            SphereOfInfluence.LORE,
            PlayerCardType.ALLY,
            new String[]{"Minstrel", "Rohan"},
            GleowineID,
            2,
            1,
            0,
            2,
            2,
            "Exhaust Gleowine to choose a player.  That player draws 1 card.",
            list7,
            true);
        cardMap.put(GleowineID, gleowine);
        
        Modifier attack = new Modifier(1, TypeOfModifier.ATTACK, LifeSpanOfModifier.ENDOFPHASE);
        Modifier defense = new Modifier(1, TypeOfModifier.DEFENSE, LifeSpanOfModifier.ENDOFPHASE);
        ArrayList<Modifier> mods = new ArrayList<>();
        mods.add(attack);
        mods.add(defense);
        DiscardToAddModifiersEffect playBladeMastery = new DiscardToAddModifiersEffect(mods);
        ArrayList<Effect> list8 = new ArrayList<>();
        list8.add(playBladeMastery);
        Identification BladeMasteryID = new Identification(ExpansionName.CORE, 32);
        EventCardModel bladeMastery = new EventCardModel(
            "Blade Mastery",
            SphereOfInfluence.LORE,
            PlayerCardType.EVENT,
            new String []{""},
            BladeMasteryID,
            1,
            "Choose a character.  That character gets +1 attack and +1 defend this round",
            list8);
        cardMap.put(BladeMasteryID, bladeMastery);
        
        DiscardToExhaustAndReadyEffect exhaustReadyEffect = new DiscardToExhaustAndReadyEffect();
        ArrayList<Effect> list9 = new ArrayList<>();
        list9.add(exhaustReadyEffect);
        Identification CommonCauseID = new Identification(ExpansionName.CORE,21);
        EventCardModel commonCause = new EventCardModel(
            "Common Cause",
            SphereOfInfluence.LEADERSHIP,
            PlayerCardType.EVENT,
            new String []{""},
            CommonCauseID,
            0,
            "Exhaust 1 hero you control to choose and ready a different hero.",
            list9);
        cardMap.put(CommonCauseID, commonCause);
        
        DiscardToHealEffect discardToHealEffect = new DiscardToHealEffect();
        ArrayList<Effect> list10 = new ArrayList<>();
        list10.add(discardToHealEffect);
        Identification LoreOfImladrisID = new Identification(ExpansionName.CORE, 63);
        EventCardModel loreOfImladris = new EventCardModel(
            "Lore Of Imladris",
            SphereOfInfluence.LORE,
            PlayerCardType.EVENT,
            new String[] {""},
            LoreOfImladrisID,
            2,
            "Choose a character.  Heal all damage from that character.",
            list10);
        cardMap.put(LoreOfImladrisID, loreOfImladris);
        
        PlayToMoveEnemyToStagingAreaEffect moveEnemyEffect = new PlayToMoveEnemyToStagingAreaEffect();
        ArrayList<Effect> list11 = new ArrayList<>();
        list11.add(moveEnemyEffect);
        Identification LightInDarkID = new Identification(ExpansionName.CORE, 52);
        EventCardModel aLightInTheDark = new EventCardModel(
            "A Light in the Dark", 
            SphereOfInfluence.SPIRIT,
            PlayerCardType.EVENT,
            new String[]{""},
            LightInDarkID,
            2,
            "Choose an enemy engaged with a player.  Return that enemy to the staging area.",
            list11);
        cardMap.put(LightInDarkID, aLightInTheDark);
        
        PlayToFeintEffect feintEffect = new PlayToFeintEffect();
        ArrayList<Effect> list12 = new ArrayList<>();
        list12.add(feintEffect);
        Identification FeintID = new Identification(ExpansionName.CORE, 34);
        EventCardModel feint = new EventCardModel(
            "Feint",
            SphereOfInfluence.TACTICS,
            PlayerCardType.EVENT,
            new String[]{""},
            FeintID,
            1,
            "Choose an enemy engaged with a player.  That enemy cannot attack this phase.",
            list12);
        cardMap.put(FeintID, feint);
        
        Identification QuickStrikeID = new Identification(ExpansionName.CORE, 35);
        PlayToQuickStrikeEffect quickStrikeEffect = new PlayToQuickStrikeEffect();
        ArrayList<Effect> list13 = new ArrayList<>();
        list13.add(quickStrikeEffect);
        EventCardModel quickStrike = new EventCardModel(
            "Quick Strike",
            SphereOfInfluence.TACTICS,
            PlayerCardType.EVENT,
            new String[]{""},
            QuickStrikeID,
            1,
            "Exhaust a character you control to immediately declare it as an attacker "
                    + "and resolve its attack against any enemy engaged with that player.",
            list13);
        cardMap.put(QuickStrikeID, quickStrike);
        
        Identification RadagastsCunningID = new Identification(ExpansionName.CORE, 65);
        PlayRadagastsCunningEffect radagastsEffect = new PlayRadagastsCunningEffect();
        ArrayList<Effect> list14 = new ArrayList<>();
        list14.add(radagastsEffect);
        EventCardModel radagastsCunning = new EventCardModel(
            "Radagast's Cunning",
            SphereOfInfluence.LORE,
            PlayerCardType.EVENT,
            new String[]{""},
            RadagastsCunningID,
            1,
            "Choose an enemy in the staging area.  Until the end of phase, that enemy's threat"
                    + " does not contribute to the threat count.",
            list14);
        cardMap.put(RadagastsCunningID, radagastsCunning);
        
        Identification WillOfTheWestID = new Identification(ExpansionName.CORE, 49);
        PlayWillOfWestEffect willOfWestEffect = new PlayWillOfWestEffect();
        ArrayList<Effect> list15 = new ArrayList<>();
        list15.add(willOfWestEffect);
        EventCardModel willOfWest = new EventCardModel(
            "Will of the West",
            SphereOfInfluence.SPIRIT,
            PlayerCardType.EVENT,
            new String[]{""},
            WillOfTheWestID,
            1,
            "Choose a player.  Shuffle that player's discard pile back into his deck.",
            list15);
        cardMap.put(WillOfTheWestID, willOfWest);
        
        Identification GrimResolveID = new Identification(ExpansionName.CORE, 25);
        PlayGrimResolveEffect grimResolveEffect = new PlayGrimResolveEffect();
        ArrayList<Effect> list16 = new ArrayList<>();
        list16.add(grimResolveEffect);
        EventCardModel grimResolve = new EventCardModel(
            "Grim Resolve",
            SphereOfInfluence.LEADERSHIP,
            PlayerCardType.EVENT,
            new String[]{""},
            GrimResolveID,
            5,
            "After playing, ready all character cards in play.",
            list16);
        cardMap.put(GrimResolveID, grimResolve);
    }
    
    
    
}
