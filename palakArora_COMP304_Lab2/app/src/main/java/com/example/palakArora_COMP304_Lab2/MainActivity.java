package com.example.palakArora_COMP304_Lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("LeaseOrRentHome Inc");
    }


    public void goToNext(View view) {

        Intent intent = new Intent(this, MenuDisplayer.class);
        startActivity(intent);

    }


}
