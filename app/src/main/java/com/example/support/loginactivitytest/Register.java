package com.example.support.loginactivitytest;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) findViewById(i);
                msg = radioButton.getTag().toString();
                Toast.makeText(getApplicationContext(),"You select "+msg,Toast.LENGTH_SHORT).show();
            }
        });

        Button selectBtn = (Button) findViewById(R.id.nextBtnId);

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(msg.equalsIgnoreCase("seller")){
                    Intent intent = new Intent(getApplication(),Seller_Registration.class);
                    startActivity(intent);

                }

                else if(msg.equalsIgnoreCase("buyer")){
                    Intent intent = new Intent(getApplication(),BuyerRegistration.class);
                    startActivity(intent);

                }

                else if(msg.equalsIgnoreCase("buyerseller")){
                    Intent intent = new Intent(getApplication(),SellerBuyer_Registration.class);
                    startActivity(intent);
                }
            }
        });
    }
}
