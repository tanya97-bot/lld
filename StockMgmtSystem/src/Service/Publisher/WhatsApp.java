package Service.Publisher;

public class WhatsApp implements Publisher {
    @Override
    public void publish(String message) {
        System.out.println("Message from Whataspp : "+message);
    }
}
