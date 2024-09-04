import Model.Game;
import Model.Player;
import Service.AddSnakesAndLaddersImpl;
import Service.IAddSnakesAndLadders;
import Service.IPlaySnakesAndLadders;
import Service.PlaySnakesAndLaddersImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Player p1 = new Player("t1");
        Player p2 = new Player("t2");
        Player p3 = new Player("t3");


        Game g = new Game(8,8);
        g.addPlayers(p1);
        g.addPlayers(p2);
        g.addPlayers(p3);

        IAddSnakesAndLadders addSnakesAndLadders = new AddSnakesAndLaddersImpl();

        addSnakesAndLadders.addLadders(4, g);
        addSnakesAndLadders.addSnakes(5, g);

        IPlaySnakesAndLadders playSnakesAndLadders = new PlaySnakesAndLaddersImpl();

        playSnakesAndLadders.play(g);

    }
}