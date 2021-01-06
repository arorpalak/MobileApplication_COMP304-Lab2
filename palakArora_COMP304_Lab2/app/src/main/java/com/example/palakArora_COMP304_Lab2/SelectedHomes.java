package com.example.palakArora_COMP304_Lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelectedHomes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_homes);

        int index = 0;
        RadioGroup radioGroup = findViewById(R.id.radioGroupSelectedHomes);
        for (final Home home : Program.selectedHomes)
        {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(index++);
            radioButton.setText(home.getAddress()+" "+home.getPrice());


            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(getApplicationContext(), CheckoutActivity.class );
                    Bundle bundle=new Bundle();
                    bundle.putString("price",home.getPrice());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            radioGroup.addView(radioButton);
        }
    }
}
