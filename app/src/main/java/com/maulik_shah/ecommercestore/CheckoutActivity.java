package com.maulik_shah.ecommercestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CheckoutActivity extends AppCompatActivity {

    EditText name, email, cNumber, cardNumber, cardCVV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        name = findViewById(R.id.edtName);
        email = findViewById(R.id.edtEmail);
        cNumber = findViewById(R.id.edtPhone);
        cardNumber = findViewById(R.id.edtCreditCard);
        cardCVV = findViewById(R.id.edtCVV);
    }


    public void mail(View view) {
        sendMail();
    }

    private void sendMail() {
        String mail = email.getText().toString().trim();
        String message = "Order Information \n" + name.getText().toString().trim() + "\n" + "Your order has been placed from card no." + cNumber.getText().toString().trim() + "\n Thank You for placing order with us. Have a nice day.";
        String subject = "Your Order Invoice";

        JavaMailAPI javaMailAPI = new JavaMailAPI(this,mail,subject,message);
        //noinspection deprecation
        javaMailAPI.execute();

    }
}