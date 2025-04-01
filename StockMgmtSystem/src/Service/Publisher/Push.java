package Service.Publisher;

public class Push implements Publisher {
    @Override
    public void publish(String message) {
        System.out.println("Message from Push : "+message);
    }
}

