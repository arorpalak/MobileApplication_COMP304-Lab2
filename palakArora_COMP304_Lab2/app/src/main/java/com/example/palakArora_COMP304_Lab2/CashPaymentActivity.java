package com.example.palakArora_COMP304_Lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CashPaymentActivity extends AppCompatActivity {


    TextView textView,textView2;
    String totalPayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_payment);
        setTitle("Payment");

        Intent intent=new Intent();
        Bundle bundle= getIntent().getExtras();





        textView=findViewById(R.id.pMethod);
        textView.setText("Your selected method of payment: Cash");

        totalPayment=bundle.getString("price");
        textView2=findViewById(R.id.total);
        textView2.setText("Your total payment: "+totalPayment);







    }
}
