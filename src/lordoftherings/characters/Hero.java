//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.characters;

import lordoftherings.cards.HeroCard;

/**
 *
 * @author Amanda
 */
public class Hero extends GameCharacter{
    private int resources;
    private String heroInfo;
    private HeroCard card;
    private int positionOnBoard;
    
    public Hero(HeroCard newHero){
        this.card = newHero;
        heroInfo = newHero.getIdentity();
        resources = 0;
        positionOnBoard = 0;
    }
    
    public void increaseResources(int amount){
        resources += amount;
    }
    
    public String getInfo(){
        return heroInfo;
    }
    
    public int getThreatCost(){
        return card.getThreatCost();
    }
    
    public int getNumOfResources(){
        return resources;
    }
    
    public void setPositionInHeroArea(int i){
        positionOnBoard = i;
    }
    
    public int getPositionInHeroArea(){
        return positionOnBoard;
    }
    
    public int spendResources(int amount){
       if(amount <= resources){
            resources -= amount;
            return 0;
       }else{
           int debt = amount - resources;
           resources = 0; 
           return debt;
       }
    }
    
    

    @Override
    public HeroCard getCard() {
        return card;
    }
}
