package com.example.test_background;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Second extends AppCompatActivity {

    final private String TAG = "Second";
    Device m_device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate");

        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            m_device = (Device) arguments.getSerializable(Device.getName());
            Log.d(TAG, "Reused Device");
            Log.d(TAG, m_device.str);
        } else {
            m_device = new Device();
            m_device.str = "Second";
            Log.d(TAG, "Create Device");
        }

    }

    public void onClicButton(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(m_device.getName(),  m_device);
        startActivity(intent);
    }
}