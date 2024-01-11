package objects;

import java.util.HashMap;

public class Entities {
    static HashMap<Integer,Integer> snakes;
    static HashMap<Integer,Integer>ladders;
    static HashMap<Integer,String>players;
    static Entities instance = null;

    private Entities() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new HashMap<>();
    }

    public void setSnake(int startP, int endP) {
        snakes.put(startP, endP);
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setLadder(int startP, int endP) {
        ladders.put(startP,endP);
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setPlayer(int index,String playerName) {
        players.put(index,playerName);
    }

    public HashMap<Integer, String> getPlayers() {
        return players;
    }

    public static Entities getEntity() {
        if(instance==null)
            instance = new Entities();
        return instance;
    }
 }
