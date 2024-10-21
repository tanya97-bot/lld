package org.example.CallbackAndEventRunner;

public interface RegistrationCallback {
    void onRegistrationComplete(String username) throws InterruptedException;
}
