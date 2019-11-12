package com.example.sys_lab34;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TamagotchiThread.TamagotchiThreadInterface {

    TamagotchiThread tama1 = new TamagotchiThread(this,0);
    TamagotchiThread tama2 = new TamagotchiThread(this,1);
    TamagotchiThread tama3 = new TamagotchiThread(this,2);
    TamagotchiThread tama4 = new TamagotchiThread(this,3);
    TamagotchiThread tama5 = new TamagotchiThread(this,4);

    ArrayList<TamagotchiThread> list = new ArrayList<>();
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

   int aliveCount = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button5 = findViewById(R.id.button_5);
        button4 = findViewById(R.id.button_4);

        startApp();

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feed(0);
            }
        });

        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feed(1);
            }
        });

        findViewById(R.id.button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feed(2);
            }
        });

        findViewById(R.id.button_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feed(3);
            }
        });

        findViewById(R.id.button_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feed(4);
            }
        });

    }

    public void tellFood(int food,int name){
        System.out.println(food +" Tamagotchi:" + name);
        if (name == 0)
        {
            button1.setText("Tamagotchi 1 food: "+food);
        }
        else if ( name==1)
        {
            button2.setText("Tamagotchi 2 food: "+food);
        }
        else if (name==2)
        {
            button3.setText("Tamagotchi 3 food: "+food);
        }
        else if (name==3){
            button4.setText("Tamagotchi 4 food: "+food);
        }
        else if (name == 4)
        {
            button5.setText("Tamagotchi 5 food: "+food);
        }


    }
    public void tellDead(final boolean isDead, final int name){
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               if (isDead)
               {
                   System.out.println("Tamagotchi: "+name+" died");
                   if (name == 0)
                   {
                       button1.setText("Tamagotchi 1 died");
                       button1.setBackgroundColor(Color.RED);
                       aliveCount = aliveCount -1;
                   }
                   else if ( name==1)
                   {
                       button2.setText("Tamagotchi 2 died");
                       button2.setBackgroundColor(Color.RED);
                       aliveCount = aliveCount -1;
                   }
                   else if (name==2)
                   {
                       button3.setText("Tamagotchi 3 died");
                       button3.setBackgroundColor(Color.RED);
                       aliveCount = aliveCount -1;
                   }
                   else if (name==3){
                       button4.setText("Tamagotchi 4 died");
                       button4.setBackgroundColor(Color.RED);
                       aliveCount = aliveCount -1;
                   }
                   else if (name == 4)
                   {
                       button5.setText("Tamagotchi 5 died");
                       button5.setBackgroundColor(Color.RED);
                       aliveCount = aliveCount -1;
                   }
                   //list.remove(name);

               }
               if (aliveCount == 0)
               {
                   alertView();
               }

           }
       }); // System.out.println();
       // stop();
    }

    public void startApp()
    {
        list.add(tama1);
        list.add(tama2);
        list.add(tama3);
        list.add(tama4);
        list.add(tama5);

        for(int i = 0;i < list.size();i++)
        {
            list.get(i).start();
        }

    }
    public void feed(int id)
    {
        for(int i = 0;i < list.size();i++)
        {
            if(i == id)
            {
                list.get(id).feed();
            }

        }

    }
    public void stop()
    {
        if(list.get(0).isDead == true)
        {
            System.out.println(list.isEmpty());
            
           alertView();

        }
    }

    private void alertView()
    {
        new AlertDialog.Builder(this).setTitle("WASTED")
                .setMessage("All DIED")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setNegativeButton(android.R.string.ok, null)
                .show();
    }

}
