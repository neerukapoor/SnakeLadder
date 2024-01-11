package Service;

import java.util.HashMap;

import objects.Dice;
import objects.Entities;

public class PlayGame {
    
    Dice dice;
    Entities entities;
    HashMap<String, Integer> playerLatestPosition;

    public PlayGame() {
        dice = new Dice();
        entities = Entities.getEntity();
        playerLatestPosition = new HashMap<>();
    }

    public void start() {
        initialize();
        int i=0;
        do {
            String playerName = entities.getPlayers().get(i);
            int diceN = dice.RollDice();
            int endP = playerLatestPosition.get(playerName) + diceN;
            String sl="";
            if(endP<=100) {
                System.out.print("Player " + playerName + " rolled a " + diceN + " and moved from " + playerLatestPosition.get(playerName));
                if(entities.getSnakes().get(endP)!=null) {
                    sl = " after snake dinner";
                    playerLatestPosition.put(playerName,entities.getSnakes().get(endP));
                }
                else {
                    if(entities.getLadders().get(endP)!=null){
                        // up ladder
                        sl = " after Ladder ride ";
                        playerLatestPosition.put(playerName,entities.getLadders().get(endP));
                    }
                    else{
                        playerLatestPosition.put(playerName,endP);
                    }
                }
                System.out.println(" to " + playerLatestPosition.get(playerName) + sl);
            }
            i++;
            if(i>=entities.getPlayers().size())
                i=0;
        }while(!isPlayerWon(entities.getPlayers().get(i)));
        System.out.println("Player " + entities.getPlayers().get(i) + " won!!");
    }


    public boolean isPlayerWon(String player) {
        return playerLatestPosition.get(player) == 100;
    }

    public void initialize() {
        for(int i=0;i<entities.getPlayers().size();i++) {
            playerLatestPosition.put(entities.getPlayers().get(i),0);
        }
    }
}
