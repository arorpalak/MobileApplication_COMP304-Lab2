package com.example.palakArora_COMP304_Lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {
private TextView selectedItem,item,paymentInfo;
String price;
//    private double paymentTotal;
    private String paymentOption;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        selectedItem=findViewById(R.id.tvSelection);
        setTitle("Checkout");

        Intent intent=new Intent();
        Bundle bundle= getIntent().getExtras();
        price=bundle.getString("price");


        item=findViewById(R.id.tvItem);
        item.setText("Your total payment: "+price.toString());




        ((RadioGroup) findViewById(R.id.paymentMethod)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idChecked) {
                Bundle bundle;

                switch (idChecked) {
                    case R.id.cashRadioButton:
                        paymentOption = getResources().getString(R.string.cashOption);
                        break;
                    case R.id.creditCardRadioButton:
                        paymentOption = getResources().getString(R.string.creditcardOption);
                        break;
                    case R.id.debitCardRadioButton:
                        paymentOption = getResources().getString(R.string.debitcardOption);
                        break;
                }
            }
        });

        findViewById(R.id.checkoutBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle;

                switch (((RadioGroup) findViewById(R.id.paymentMethod)).getCheckedRadioButtonId()) {
                    case R.id.cashRadioButton:


                        Intent intent= new Intent(CheckoutActivity.this, CashPaymentActivity.class );
                        bundle = new Bundle();
                        bundle.putString("price",price);

                        intent.putExtras(bundle);
                        startActivity(intent);




                        break;
                    case R.id.creditCardRadioButton:
                    case R.id.debitCardRadioButton:
                        intent= new Intent(CheckoutActivity.this, CardPaymentActivity.class );
                        bundle = new Bundle();
                        bundle.putString("price",price);
                        intent.putExtras(bundle);
                        startActivity(intent);

                        break;
                }
            }
        });







           }
}
