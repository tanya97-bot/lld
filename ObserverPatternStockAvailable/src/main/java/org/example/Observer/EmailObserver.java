package org.example.Observer;

public class EmailObserver implements NotifcationAlertObserver {
    @Override
    public void update(int stock) {
        System.out.println("Email notif, units are updated to "+ stock);
    }
}
