package com.example.sys_lab34;

public class TamagotchiThread extends Thread {
    int food = 5;
    boolean isDead = false;
    int givenName;
    TamagotchiThreadInterface callBackInterface;

    public interface TamagotchiThreadInterface
    {
        void tellFood(int food, int name);
        void tellDead(boolean dead, int name);

    }

    public TamagotchiThread(TamagotchiThreadInterface cb, int id)
    {
        // while(true){
        callBackInterface = cb;
        givenName = id;

        // cb.tellFood(food);
        //  }

    }

    public void run(){
        try{

            while(true){
                food--;
                callBackInterface.tellFood(food,givenName);

                sleep(2000);
                if (food <= 0)
                {
                    isDead= true;
                    callBackInterface.tellDead(isDead,givenName);
                    return;
                }
                else if (food > 20)
                {
                    isDead=true;
                    callBackInterface.tellDead(isDead,givenName);
                    return;
                }
                callBackInterface.tellDead(isDead,givenName);
            }

        }catch(Exception e){

        }
    }

    public void feed(){
        food = food + 10;
    }

}
