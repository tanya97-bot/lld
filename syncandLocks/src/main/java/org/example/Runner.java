package org.example;

public class Runner implements Runnable {

    private boolean flag  = false;

    public void setFlag(boolean b){
        this.flag = b;
    }
    @Override
    public void run() {
        if(flag){
            methodA();
        }else{
            methodB();
        }
    }

    private void methodA(){System.out.println("methodA");}
    private void methodB(){System.out.println("methodB");}
}
