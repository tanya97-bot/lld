package Model;

import java.util.*;

public class Game {

    List<Player> players;
    HashMap<Integer, Integer> snakes;
    HashMap<Integer, Integer> ladders;
    int winIndex =0;
    Random dice = new Random(6);

    public Game(int r, int c){
        players = new ArrayList<>();
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        winIndex = (r*c) -1;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayers(Player player) {
        this.players.add(player);
    }

    public int getWinIndex() {
        return winIndex;
    }

    public void setWinIndex(int winIndex) {
        this.winIndex = winIndex;
    }


    public Random getDice() {
        return dice;
    }

    public void setDice(Random dice) {
        this.dice = dice;
    }

    public void setSnakes(HashMap<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public void setLadders(HashMap<Integer, Integer> ladders) {
        this.ladders = ladders;
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }
}
