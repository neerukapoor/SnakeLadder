import java.util.Scanner;

import Service.PlayGame;
import objects.Entities;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Snake Ladder");
        Entities entities = Entities.getEntity();
        
        System.out.println("Enter number of snakes? ");
        int noOfSnakes = scan.nextInt();
        while(noOfSnakes>0) {
            System.out.println("Enter snake starting and ending position ");
            int startP = scan.nextInt();
            int endP = scan.nextInt();
            entities.setSnake(startP, endP);
            noOfSnakes--;
        }
        System.out.println("Enter number of ladders? ");
        int noOfLadders = scan.nextInt();
        while(noOfLadders>0){
            System.out.println("Enter ladder starting and ending position ");
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            entities.setLadder(startPosition, endPosition);
            noOfLadders--;
        }
        System.out.println("Enter number of players? ");
        int noOfPlayers = scan.nextInt();
        int i=0;
        while(noOfPlayers>0){
            System.out.println("Enter player name? ");
            String player = scan.next();
            entities.setPlayer(i++, player);
            noOfPlayers--;
        }
        System.out.println("yaha");
        PlayGame playGame = new PlayGame();
        playGame.start();
    }
}
