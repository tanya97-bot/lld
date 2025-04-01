import Model.User;
import Service.Publisher.Publisher;
import Service.Publisher.Push;
import Service.Publisher.WhatsApp;
import Service.StockManager.StockPriceManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StockPriceManager spm = new StockPriceManager();
        spm.addStock("AAPL", 100.0f);
        spm.addStock("GOOGL", 1000.0f);
        spm.addStock("AMZN", 2000.0f);

        Publisher whastapp = new WhatsApp();
        Publisher push = new Push();

        User user1 = new User("Tanya");
        User user2 = new User("Rahul");

        user1.addToPublishers(whastapp);
        user1.addToPublishers(push);
        user2.addToPublishers(whastapp);

        spm.addUserToStock("AAPL", user1);
        spm.addUserToStock("AMZN", user1);
        spm.addUserToStock("GOOGL", user2);

        spm.updatePrice("AAPL", 101.0f);
        spm.updatePrice("GOOGL", 1001.0f);
        spm.updatePrice("AMZN", 2001.0f);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        }
    }
