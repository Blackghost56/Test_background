package com.example.test_background;

import android.util.Log;

import java.io.Serializable;

import static java.lang.Thread.sleep;

public class Device implements Serializable {

    public String str;

    Device(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true){
                    count++;
                    Log.d("Thread", "" + count);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    static public String getName(){
        return "Device";
    }

}
