package org.example.Observer;

public class MobileNotifObserver implements NotifcationAlertObserver{

    @Override
    public void update(int stock) {
        System.out.println("Mobile notif, units are updated to "+ stock);
    }
}
