package Service;

import Model.Game;
import Model.Player;

public class PlaySnakesAndLaddersImpl implements IPlaySnakesAndLadders{


    @Override
    public Player play(Game g) {
        while(true) {
            for (Player p : g.getPlayers()) {
                int ind = g.getDice().nextInt(1,6) + 1 + p.getPos();
                if (ind == g.getWinIndex()) {
                    System.out.println(p.getName() + " Won at " + ind);
                    return p;
                }
                ind = ind % g.getWinIndex();
                System.out.println(p.getName() + " index after dice roll " + ind);
                if (g.getLadders().containsKey(ind)) {
                    ind = g.getLadders().get(ind);
                    System.out.println(p.getName() + " got found a ladder and climbed to " + ind);
                } else if (g.getSnakes().containsKey(ind)) {
                    ind = g.getSnakes().get(ind);
                    System.out.println(p.getName() + " got bit by a snake and dropped to " + ind);
                }
                p.setPos(ind);
            }
        }
    }
}
