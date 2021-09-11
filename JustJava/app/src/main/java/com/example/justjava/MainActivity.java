package com.example.justjava;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.justjava.R;

import java.text.NumberFormat;

/**
 This app displays an order form to order coffee.
 */
public class MainActivity extends Activity {

    int quatity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "Total: " + displayPrice(quatity) + "/nThank You!";
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the plus button is clicked.
     * adds 1 to the given quatity
     */
    public void increment(View view) {
        quatity++;
        display(quatity);
    }

    /**
     * This method is called when the minus button is clicked.
     * subtracts 1 from the given quatity
     */
    public void decrement(View view) {
        if (quatity > 0) quatity--;
        display(quatity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private String displayPrice(int num) {
        int price = 5;
        //TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        return NumberFormat.getCurrencyInstance().format(price * num);
    }

    /**
     * This method displays the given text on the screen
     */
    private void displayMessage(String message)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void timer(View view) {
        TextView mTextField = (TextView) findViewById(R.id.timer);

        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();
    }




}