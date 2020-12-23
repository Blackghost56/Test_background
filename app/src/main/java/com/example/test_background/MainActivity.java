package com.example.test_background;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final private String TAG = "MainActivity";

    Device m_device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate");

        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            m_device = (Device) arguments.getSerializable(Device.getName());
            Log.d(TAG, "Reused Device");
            Log.d(TAG, m_device.str);
        } else {
            m_device = new Device();
            m_device.str = "First";
            Log.d(TAG, "Create Device");
        }
    }

    public void clickedButton(View view) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(m_device.getName(),  m_device);
        startActivity(intent);
    }
}