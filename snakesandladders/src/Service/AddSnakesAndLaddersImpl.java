package Service;

import Model.Game;

import java.util.HashSet;
import java.util.Random;

public class AddSnakesAndLaddersImpl implements IAddSnakesAndLadders {

    Random random;
    HashSet<Integer> added;

    public AddSnakesAndLaddersImpl(){
        random = new Random();
        added = new HashSet<>();
    }

    @Override
    public void addSnakes(int sc, Game g) {
        int li = g.getWinIndex();
        for (int i=0;i< sc ;i++){
            int si = random.nextInt(li-2)+1;
            while(added.contains(si)){
                si = random.nextInt(li-2) +1;
            }
            added.add(si);
            int ei = random.nextInt(si);
            while(added.contains(ei)) {
                ei = random.nextInt(si);
            }
            added.add(ei);
            System.out.println("Added a snake hissing from "+si+" "+ei);
            g.getSnakes().put(si, ei);
        }
    }

    @Override
    public void addLadders(int lc, Game g) {
        int li = g.getWinIndex();
        for (int i=0;i< lc ;i++){
            int si = random.nextInt(li-2)+1;
            while(added.contains(si)){
                si = random.nextInt(li-2) +1;
            }
            added.add(si);
            int ei = random.nextInt(li - si + 1 ) + si;
            while(added.contains(ei)) {
                ei = random.nextInt(li - si) + si;
            }
            added.add(ei);
            System.out.println("Added a ladder climbing from "+si+" "+ei);
            g.getLadders().put(si, ei);
        }
    }
}
